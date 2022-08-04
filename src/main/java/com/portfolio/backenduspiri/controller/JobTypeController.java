package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.JobType;
import com.portfolio.backenduspiri.service_interface.IJobTypeService;
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
@RequestMapping("/jobtype")
@CrossOrigin( origins = "http://localhost:4200" )
public class JobTypeController {
    
    @Autowired
    private IJobTypeService jobService;
    
    @GetMapping
    @ResponseBody
    public List<JobType> getJobType(){
        return jobService.getJobTypes();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public JobType getJobType( @PathVariable Long id ){
        return jobService.getJobType( id );
    }
    
    @PostMapping
    public void saveJobType( @RequestBody JobType job ){
        jobService.createJobType(job);
    }

    @PutMapping("/{id}")
    public JobType updateJobType( @PathVariable Long id, @RequestBody JobType job ){
        JobType jobToUpdate = jobService.getJobType(id);
        
        jobToUpdate.setName(job.getName());
        
        return jobService.updateJobType(jobToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteJobType( @PathVariable Long id ){
        jobService.deleteJobType(id);
    }
    
}
