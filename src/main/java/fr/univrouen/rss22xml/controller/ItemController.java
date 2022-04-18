package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.exceptions.RessourceNotFoundExceptions;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    public List<Item> getItemHtml(){
        var items = (List<Item>) itemRepository.findAll();

        return items;
    }
    public ResponseEntity<Item> getItemById(@PathVariable(value = "guid") Long itemguid) throws RessourceNotFoundExceptions {
        Item item = itemRepository.findById(itemguid)
                .orElseThrow(() -> new RessourceNotFoundExceptions("Item not found for this id ::" + itemguid));
        return  ResponseEntity.ok().body(item);
    }

    @RequestMapping(value="/rss22/resume/html" ,method = RequestMethod.GET)
    String listItem(Model model){
        model.addAttribute("items",getItemHtml());
        return "listItem";
    }
    @RequestMapping(value="/rss22/resume/html/{guid}")
    String getItem(@PathVariable(value = "guid")Long item,Model model ) throws RessourceNotFoundExceptions {
        model.addAttribute("item" ,getItemById(item));
        return "item";
    }
}
