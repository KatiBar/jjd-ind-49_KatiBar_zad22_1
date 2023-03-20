package com.example.jjdind49_katibar_zad22_1;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String senderEmail, String receiverEmail, String content, String title) {
        logger.debug("Wysyłam maila do {}", receiverEmail);

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setReplyTo(senderEmail);
            helper.setFrom(senderEmail);
            helper.setSubject(title);
            helper.setText(content, true);
            helper.setTo(receiverEmail);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.warn("Błąd podczas wysyłania wiadomości do {}", receiverEmail);
        }

        logger.debug("Mail do {} wysłany poprawnie", receiverEmail);
    }
}
