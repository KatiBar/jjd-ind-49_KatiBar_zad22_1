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
    static final String RECEIVER_EMAIL = "kati.bar.javastart@gmail.com";

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String senderEmail, String content, String title) {
        logger.debug("Wysyłam maila do {}", RECEIVER_EMAIL);

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setReplyTo(senderEmail);
            helper.setFrom(RECEIVER_EMAIL);
            helper.setSubject("Nowa wiadomość ze strony: " + title);
            helper.setText("Treść wiadomości: \n" + content, true);
            helper.setTo(RECEIVER_EMAIL);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.warn("Błąd podczas wysyłania wiadomości do {}", RECEIVER_EMAIL);
        }

        logger.debug("Mail do {} wysłany poprawnie", RECEIVER_EMAIL);
    }
}
