package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Image;
import com.portfolio.backenduspiri.service_interface.IImageService;
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
@RequestMapping("/image")
@CrossOrigin( origins = "http://localhost:4200" )
public class ImageController {
    
    @Autowired
    private IImageService imgService;
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping
    @ResponseBody
    public List<Image> getImage(){
        return imgService.getImages();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Image getImage( @PathVariable Long id ){
        return imgService.getImage( id );
    }
    
    @GetMapping("person/{id}")
    public Image getImageByPersonId( @PathVariable Long id ){
        return imgService.findByPersonId(id);
    }
    
    @PostMapping("/{id}")
    public void saveImage( @PathVariable Long id, @RequestBody Image img ){
        img.setPerson(personService.getPerson(id));
        imgService.createImage(img);
    }
    
    @PutMapping("/{id}")
    public Image updateImage( @PathVariable Long id, @RequestBody Image img ){
        Image imgToUpdate = imgService.getImage(id);
        
        imgToUpdate.setAbout(img.getAbout());
        imgToUpdate.setHeader(img.getHeader());
        
        return imgService.updateImage(imgToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteImage( @PathVariable Long id ){
        imgService.deleteImage(id);
    }
    
}
