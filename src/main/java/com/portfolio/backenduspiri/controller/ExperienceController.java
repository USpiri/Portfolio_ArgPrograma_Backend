package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Experience;
import com.portfolio.backenduspiri.service_interface.IExperienceService;
import com.portfolio.backenduspiri.service_interface.IPersonService;
import com.portfolio.backenduspiri.util.FileUploadUtil;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}")
    public Experience saveExperience( @PathVariable Long id, @RequestBody Experience exp ){
        exp.setPerson(personService.getPerson(id));
        expService.createExperience(exp);
        return expService.getExperience(exp.getId());
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Experience updateExperience( @PathVariable Long id, @RequestBody Experience exp ){
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
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/image")
    public Experience updateExperienceImage( @PathVariable Long id, @RequestParam("experience") MultipartFile exp ) throws IOException{
        Experience expToUpdate = expService.getExperience(id);
        
        String apiURL = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/";
        String uploadDir = "user-photos/" + expToUpdate.getPerson().getId() + "/experience";
        
        //Updates Image Object
        expToUpdate.setImg_url(apiURL + uploadDir + "/" + expToUpdate.getId() + ".jpg");
        
        //Save images in folders
        FileUploadUtil.saveFile(uploadDir, expToUpdate.getId() + ".jpg", exp);
        
        return expService.updateExperience(expToUpdate);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteExperience( @PathVariable Long id ) throws IOException{
        String fileDir = "user-photos/" + expService.getExperience(id).getPerson().getId() + "/experience";
        String fileName = id + ".jpg";
        
        FileUploadUtil.deleteFile(fileDir, fileName);
        expService.deleteExperience(id);
    }
    
}
