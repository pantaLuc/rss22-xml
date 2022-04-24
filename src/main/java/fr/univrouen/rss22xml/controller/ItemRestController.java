package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.exceptions.RessourceNotFoundExceptions;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.model.Items;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping(value="/rss22")
public class ItemRestController {
    @Autowired
    private ItemRepository itemRepository;
    // with xml

    @GetMapping(value="/resume/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public Items getItems(){
        List<Item> items=itemRepository.findAll();
        Items items1=new Items();
        items1.setItems(items);
        return items1;
    }

    //insert item
    @PostMapping(value = "/insert" ,consumes = "application/xml")
    public  Item createEmployee(@RequestBody Item item){
        UUID uuid = UUID.randomUUID();

        item.setGuid(uuid);
        return this.itemRepository.save(item);
    }

    // get  item by  guid
    @GetMapping("/xml/{guid}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "guid") UUID itemguid) throws RessourceNotFoundExceptions {
        Item item = itemRepository.findById(itemguid)
                .orElseThrow(() -> new RessourceNotFoundExceptions("Item not found for this id ::" + itemguid));
        return  ResponseEntity.ok().body(item);
    }
    @DeleteMapping(value = "/delete/{guid}",produces =MediaType.APPLICATION_XML_VALUE )
    public Map<String ,Boolean> deleteEmployee(@PathVariable(value="guid") UUID itemguid)throws RessourceNotFoundExceptions{
          Item item= itemRepository.findById(itemguid)
                .orElseThrow(()->new RessourceNotFoundExceptions("Item not Found for guid ::"+itemguid));
        this.itemRepository.delete(item);
        Map<String ,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }


}
