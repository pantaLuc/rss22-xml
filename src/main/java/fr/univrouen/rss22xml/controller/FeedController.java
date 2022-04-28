package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.model.Feed;
import fr.univrouen.rss22xml.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rss22")
public class FeedController {
    @Autowired
    FeedRepository feedRepository;

    @PostMapping(value="/feed" ,consumes = "application/xml")
    public Feed createContent(@RequestBody Feed feed){
     return this.feedRepository.save(feed);
    }
}
