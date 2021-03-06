package com.pictures_shop.service;

import com.pictures_shop.exception.PictureNotFoundException;
import com.pictures_shop.model.Picture;
import com.pictures_shop.repository.PictureRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PictureService {
    
    private final PictureRepository pictureRepository;
    
    @Transactional(readOnly = true)
    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Picture getPicture(String _id) {
        Picture picture = pictureRepository.findById(new ObjectId(_id)).orElseThrow(() -> new PictureNotFoundException(_id));
        return picture;
    }
    
}
