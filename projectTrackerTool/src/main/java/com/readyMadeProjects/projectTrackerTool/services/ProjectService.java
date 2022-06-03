package com.readyMadeProjects.projectTrackerTool.services;

import com.readyMadeProjects.projectTrackerTool.domain.Project;
import com.readyMadeProjects.projectTrackerTool.exceptions.ProjectIdException;
import com.readyMadeProjects.projectTrackerTool.exceptions.ProjectNotFoundException;
import com.readyMadeProjects.projectTrackerTool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project)
    {
        return projectRepository.save(project);
    }
    public Project saveProject(Project project){
        try{

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception e){

            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");

        }

    }

    public Project findProjectByIdentifier(String Id){
        Project project = projectRepository.findByProjectIdentifier(Id.toUpperCase());

        if(project == null){
            throw new ProjectNotFoundException("Project not found");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }


    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectNotFoundException("Cannot delete project: "+projectId+" as it doesn't exist");
        }

        projectRepository.delete(project);

    }

}
