package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Project;
import com.portfolio.backenduspiri.service_interface.IPersonService;
import com.portfolio.backenduspiri.service_interface.IProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@CrossOrigin( origins = "http://localhost:4200" )
public class ProjectController {
    
    @Autowired
    private IProjectService projectService;
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping
    @ResponseBody
    public List<Project> getProject(){
        return projectService.getProjects();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Project getProject( @PathVariable Long id ){
        return projectService.getProject( id );
    }
    
    @GetMapping("person/{id}")
    public List<Project> getProjectByPersonId( @PathVariable Long id ){
        return projectService.findByPersonId(id);
    }
    
    @PostMapping("/{id}")
    public void saveProject( @PathVariable Long id, @RequestBody Project project ){
        project.setPerson(personService.getPerson(id));
        projectService.createProject(project);
    }
    
    @PutMapping("/{id}")
    public Project updateProject( @PathVariable Long id, @RequestBody Project project ){
        Project projectToUpdate = projectService.getProject(id);
        
        projectToUpdate.setName(project.getName());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setImg_url(project.getImg_url());
        projectToUpdate.setLink(project.getLink());
        projectToUpdate.setEnabled_link(project.getEnabled_link());
        
        return projectService.updateProject(projectToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProject( @PathVariable Long id ){
        projectService.deleteProject(id);
    }
    
}
