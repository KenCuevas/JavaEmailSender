package com.mailsender.emailsend.Services;

import com.mailsender.emailsend.Model.EmailResponse;

public interface EmailService {
    void sendMail(EmailResponse email);
}
