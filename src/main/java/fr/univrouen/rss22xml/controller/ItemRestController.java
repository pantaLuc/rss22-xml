package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.exceptions.RessourceNotFoundExceptions;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


import javax.xml.bind.JAXBContext;
import java.util.*;

@RestController
@RequestMapping(value="/rss22")
public class ItemRestController {
    @Autowired
    private ItemRepository itemRepository;
    // with xml
    @GetMapping(value="/resume/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    //insert item
    @PostMapping(value = "/insert" ,consumes = "application/xml")
    public  Item createEmployee(@RequestBody Item item){
        UUID uuid = UUID.randomUUID();
        String s = Long.toString(uuid.getMostSignificantBits(), 40).replace("-", "") ;
        item.setGuid(Long.parseLong(s));
        return this.itemRepository.save(item);
    }

    // get  item by  guid
    @GetMapping("/xml/{guid}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "guid") Long itemguid) throws RessourceNotFoundExceptions {
        Item item = itemRepository.findById(itemguid)
                .orElseThrow(() -> new RessourceNotFoundExceptions("Item not found for this id ::" + itemguid));
        return  ResponseEntity.ok().body(item);
    }
    @DeleteMapping("/delete/{guid}")
    public Map<String ,Boolean> deleteEmployee(@PathVariable(value="guid") Long itemguid)throws RessourceNotFoundExceptions{
          Item item= itemRepository.findById(itemguid)
                .orElseThrow(()->new RessourceNotFoundExceptions("Item not Found for guid ::"+itemguid));
        this.itemRepository.delete(item);
        Map<String ,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }


}