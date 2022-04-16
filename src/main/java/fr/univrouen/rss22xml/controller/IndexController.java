package fr.univrouen.rss22xml.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class IndexController {
    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    String getIndex(Model model) {
        model.addAttribute("something" ,"comming from the controller");
        return "index";
    }
    @RequestMapping(value="/help" ,method = RequestMethod.GET)
    String getHelp(Model model){
        return "help";
    }
}