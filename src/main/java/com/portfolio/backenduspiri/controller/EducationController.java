package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Education;
import com.portfolio.backenduspiri.service_interface.IEducationService;
import com.portfolio.backenduspiri.service_interface.IPersonService;
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
@RequestMapping("/education")
@CrossOrigin( origins = "http://localhost:4200" )
public class EducationController {
    
    @Autowired
    private IEducationService educationService;
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping
    @ResponseBody
    public List<Education> getEducation(){
        return educationService.getEducation();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Education getEducation( @PathVariable Long id ){
        return educationService.getEducation( id );
    }
    
    @GetMapping("person/{id}")
    public List<Education> getEducationByPersonId( @PathVariable Long id ){
        return educationService.findByPersonId(id);
    }
    
    @PostMapping("/{id}")
    public Education saveEducation( @PathVariable Long id, @RequestBody Education edu ){
        edu.setPerson(personService.getPerson(id));
        educationService.createEducation(edu);
        return educationService.getEducation(edu.getId());
    }
    
    @PutMapping("/{id}")
    public Education updateEducation( @PathVariable Long id, @RequestBody Education edu ){
        Education eduToUpdate = educationService.getEducation(id);
        
        eduToUpdate.setWhere(edu.getWhere());
        eduToUpdate.setDegree(edu.getDegree());
        eduToUpdate.setIs_actual(edu.getIs_actual());
        eduToUpdate.setStart_date(edu.getStart_date());
        eduToUpdate.setEnd_date(edu.getEnd_date());
        eduToUpdate.setImg_url(edu.getImg_url());
        eduToUpdate.setLink(edu.getLink());
        eduToUpdate.setEnabled_link(edu.getEnabled_link());
        
        return educationService.updateEducation(eduToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEducation( @PathVariable Long id ){
        educationService.deleteEducation(id);
    }
    
    
}
