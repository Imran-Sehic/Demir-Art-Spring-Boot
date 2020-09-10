package com.pictures_shop.service;

import com.pictures_shop.dto.InfoDto;
import com.pictures_shop.mail.MailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoService {
    
    public void sendInfo(InfoDto info){
        MailSender.sendEmail(info);
    }
    
}
