package com.aleks.EverythingToPng.controller;

import com.aleks.EverythingToPng.model.Image;
import com.aleks.EverythingToPng.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //build create image rest api
    @PostMapping()
    public ResponseEntity<Image> saveImage(@RequestBody Image image){
        return new ResponseEntity<Image>(imageService.saveImage(image), HttpStatus.CREATED);
    }

    //build get all images rest api
    @GetMapping
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

    //build get image by id rest api
    //http://localhost:8080/api/images/?
    @GetMapping("{id}")
    public ResponseEntity<Image> getImageById(@PathVariable("id") long imageId){
        return new ResponseEntity<Image>(imageService.getImageById(imageId), HttpStatus.OK);
    }

    //build update image rest api
    //http://localhost:8080/api/images/?
    @PutMapping("{id}")
    public ResponseEntity<Image> updateImage(@PathVariable("id") long id, @RequestBody Image image){
        return new ResponseEntity<Image>(imageService.updateImage(image, id), HttpStatus.OK);
    }

    //build delete image rest api
    //http://localhost:8080/api/images/?
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") long id){
        imageService.deleteImage(id);

        return new ResponseEntity<String>("Image successfully deleted.", HttpStatus.OK);
    }
}
