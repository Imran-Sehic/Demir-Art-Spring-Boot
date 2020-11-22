package com.pictures_shop.model;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "picture")
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements Serializable{
    
    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;
    private String name;
    private String description;
    private String image_url;
    private String sold;
    
}
