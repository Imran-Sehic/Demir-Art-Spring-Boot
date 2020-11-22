package com.pictures_shop.mail;

import com.pictures_shop.dto.InfoDto;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;

public class MailSender {

    public static void sendEmail(InfoDto info) {

        final String username = "demir.art.app@gmail.com";
        final String password = "demirartapp";
        final String fromEmail = "demir.art.app@gmail.com";
        final String toEmail = "demirhusicic20@gmail.com";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Kupovina slike");

            MimeMultipart multipart = new MimeMultipart("related");

            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<p>Dobar dan! <br>Javljam se povodom kupovine slike. Ispod su moji podaci.<br>Ime: "
                    + info.getName() + "<br>Prezime: " + info.getLastname() + "<br>Broj telefona: " + info.getCellphone() + "</p>";
            messageBodyPart.setContent(htmlText, "text/html");

            MimeBodyPart attachImg = new MimeBodyPart();

            URL url = new URL(info.getImage_url());
            File file = new File("image.jpeg");
            FileUtils.copyURLToFile(url, file);
            attachImg.attachFile(file);

            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachImg);
            
            msg.setContent(multipart);

            Transport.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
