package com.pictures_shop.controller;

import com.pictures_shop.dto.InfoDto;
import com.pictures_shop.service.InfoService;
import lombok.AllArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/info/")
@AllArgsConstructor
public class InfoController {
    
    private final InfoService infoService;
    
    @PostMapping
    public ResponseEntity<Void> sendInfo(@RequestBody InfoDto infoDto){
        infoService.sendInfo(infoDto);
        return new ResponseEntity<>(CREATED);
    }
    
}
