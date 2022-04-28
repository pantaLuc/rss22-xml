package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.exceptions.RessourceNotFoundExceptions;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    public List<Item> getItemHtml(){
        var items = (List<Item>) itemRepository.findAll();

        return items;
    }
    public Item getItemById(@PathVariable(value = "guid") UUID itemguid) throws RessourceNotFoundExceptions {
        Item item = itemRepository.findById(itemguid)
                .orElseThrow(() -> new RessourceNotFoundExceptions("Item not found for this id ::" + itemguid));
        return  item;
    }

    @RequestMapping(value="/rss22/resume/html" ,method = {RequestMethod.GET , RequestMethod.POST})
    String listItem(Model model){
        model.addAttribute("items",getItemHtml());
        Item item=new Item();
        model.addAttribute("item",item);
        return "listItem";
    }
    @RequestMapping(value="/rss22/resume/html/{guid}")
    String getItem(@PathVariable(value = "guid")UUID item,Model model ) throws RessourceNotFoundExceptions {
        model.addAttribute("item" ,getItemById(item));
        return "item";
    }
}
