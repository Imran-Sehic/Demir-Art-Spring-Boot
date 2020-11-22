package com.pictures_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    
    private String name;
    private String lastname;
    private Long cellphone;
    private String image_url;
    
}
