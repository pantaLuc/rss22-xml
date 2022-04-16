package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/rss22/resume" ,produces = MediaType.APPLICATION_XML_VALUE)
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/xml")
    public List<Item> getItems(){
        return this.itemRepository.findAll();
    }
    //insert item
    @PostMapping(value = "/insert" ,consumes = "application/xml")
    public  Item createEmployee(@RequestBody Item item){
        UUID uuid = UUID.randomUUID();
        String s = Long.toString(uuid.getMostSignificantBits(), 40).replace("-", "") ;
        item.setGuid(Long.parseLong(s));
        return this.itemRepository.save(item);
    }

    // get  item by  id



}
