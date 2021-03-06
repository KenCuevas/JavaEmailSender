package com.mailsender.emailsend.Controller;

import com.mailsender.emailsend.Model.EmailResponse;
import com.mailsender.emailsend.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendMail(@RequestBody EmailResponse emailResponse){
        emailService.sendMail(emailResponse);
        return new ResponseEntity<>("Email sent successfully!!", HttpStatus.OK);
    }
}
