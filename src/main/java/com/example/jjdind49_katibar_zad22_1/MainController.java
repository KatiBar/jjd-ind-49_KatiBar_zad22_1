package com.example.jjdind49_katibar_zad22_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class MainController {
    private final OfferRepository offerRepository;
    private final MailService mailService;

    public MainController(OfferRepository offerRepository, MailService mailService) {
        this.offerRepository = offerRepository;
        this.mailService = mailService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/aboutUs")
    public String showDescription(Model model) {
        Collection<Offer> offers = offerRepository.findAll();
        model.addAttribute("offers", offers);
        return "aboutUs";
    }

    @GetMapping("/contactUs")
    public String contact() {
        return "contactUs";
    }

    @PostMapping("/contactUs")
    String sendEmail(@RequestParam (name = "email") String senderEmail,
                     @RequestParam (name = "content") String content,
                     @RequestParam (name = "title") String title) {
        mailService.sendMail(senderEmail, content, title);
        return "index";
    }



}
