package com.pictures_shop.repository;

import com.pictures_shop.model.Picture;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends MongoRepository<Picture, ObjectId>{
    
}
