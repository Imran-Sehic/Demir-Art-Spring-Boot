package com.pictures_shop.controller;

import com.pictures_shop.model.Picture;
import com.pictures_shop.service.PictureService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pictures/")
@AllArgsConstructor
public class PictureController {
    
    private final PictureService pictureService;
    
    @GetMapping
    public ResponseEntity<List<Picture>> getAllPictures(){
        return status(HttpStatus.OK).body(pictureService.getAllPictures());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Picture> getPost(@PathVariable Integer id) {
        return status(HttpStatus.OK).body(pictureService.getPicture(id));
    }
    
}
