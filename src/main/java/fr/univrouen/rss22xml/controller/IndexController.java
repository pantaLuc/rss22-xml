package fr.univrouen.rss22xml.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.SimpleDateFormat;

@RestController
public class IndexController {
    @GetMapping("/" )
    public String getIndex(Model model) {
// Initialisation du message
        String message = "Test Thymeleaf !";
// Mise en forme de la date
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String today = format.format(new Date());
// Création des attributs pour insertion dans la page HTML via Thymeleaf
        model.addAttribute("message", message);
        model.addAttribute("today", today);
// Création de la page HTML avec le template "accueil.html"
        return "accueil";
    }
}