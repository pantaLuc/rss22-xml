package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.model.Content;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;
    //getContent
    @GetMapping(value = "/content",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Content> getContent(){
        return this.contentRepository.findAll();
    }
    //create content
    @PostMapping(value = "/content" ,consumes = "application/xml")
    public Content createEmployee(@RequestBody Content content){
        content.setId(2L);
        return this.contentRepository.save(content);
    }
}
