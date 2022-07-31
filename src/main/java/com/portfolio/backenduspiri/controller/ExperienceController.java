package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Experience;
import com.portfolio.backenduspiri.service_interface.IExperienceService;
import com.portfolio.backenduspiri.service_interface.IJobTypeService;
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
@RequestMapping("/experience")
@CrossOrigin( origins = "http://localhost:4200" )
public class ExperienceController {
    
    @Autowired
    private IExperienceService expService;
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping
    @ResponseBody
    public List<Experience> getExperience(){
        return expService.getExperience();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Experience getExperience( @PathVariable Long id ){
        return expService.getExperience( id );
    }
    
    @GetMapping("person/{id}")
    public List<Experience> getExperienceByPersonId( @PathVariable Long id ){
        return expService.findByPersonId(id);
    }
    
    @PostMapping("/{id}")
    public void saveExperience( @PathVariable Long id, @RequestBody Experience exp ){
        exp.setPerson(personService.getPerson(id));
        expService.createExperience(exp);
    }
    
    @PutMapping("/{id}")
    public Experience updateEducation( @PathVariable Long id, @RequestBody Experience exp ){
        Experience expToUpdate = expService.getExperience(id);
        
        expToUpdate.setCompany(exp.getCompany());
        expToUpdate.setJob(exp.getJob());
        expToUpdate.setIs_actual(exp.getIs_actual());
        expToUpdate.setStart_date(exp.getStart_date());
        expToUpdate.setEnd_date(exp.getEnd_date());
        expToUpdate.setImg_url(exp.getImg_url());
        expToUpdate.setLink(exp.getLink());
        expToUpdate.setEnabled_link(exp.getEnabled_link());
        expToUpdate.setJob_type(exp.getJob_type());
        
        return expService.updateExperience(expToUpdate);
        
    }
    
    @DeleteMapping("/{id}")
    public void deleteExperience( @PathVariable Long id ){
        expService.deleteExperience(id);
    }
    
}
