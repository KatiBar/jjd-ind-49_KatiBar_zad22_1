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

    public boolean sendMail(String senderEmail, String content, String title) {
        boolean emailSentResponse = false;
        boolean emailSentToReceiver = sendingEmail(senderEmail,RECEIVER_EMAIL, content, title);

        if (emailSentToReceiver) {
            emailSentResponse = sendingEmail(RECEIVER_EMAIL, senderEmail,
                    "Wiadomość dostarczona. Dziękujemy za kontakt, odezwiemy się najszybciej, jak to możliwe." +
                            "Pozdrawiamy, Kath Automation", "Potwierdzenie dostarczenia wiadomości");
        }
        return emailSentResponse;
    }

    private boolean sendingEmail(String senderEmail, String receiverEmail, String content, String title) {
        boolean result = false;
        logger.debug("Wysyłam maila do {}", receiverEmail);

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setReplyTo(senderEmail);
            helper.setFrom(receiverEmail);
            helper.setSubject("Nowa wiadomość ze strony: " + title);
            helper.setText("Treść wiadomości: \n" + content, true);
            helper.setTo(receiverEmail);

            mailSender.send(mimeMessage);
            result = true;
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.warn("Błąd podczas wysyłania wiadomości do {}", receiverEmail);
        }
        logger.debug("Mail do {} wysłany poprawnie", receiverEmail);
        return result;
    }
}
