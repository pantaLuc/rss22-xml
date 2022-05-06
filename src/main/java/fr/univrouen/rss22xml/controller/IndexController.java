package fr.univrouen.rss22xml.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    String getIndex(Model model) {
        model.addAttribute("something" ,"comming from the controller");
        return "index";
    }
    @RequestMapping(value="/help" ,method = RequestMethod.GET)
    String getHelp(Model model){
        return "help";
    }



}
