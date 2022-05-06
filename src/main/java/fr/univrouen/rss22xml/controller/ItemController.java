package fr.univrouen.rss22xml.controller;

import fr.univrouen.rss22xml.exceptions.RessourceNotFoundExceptions;
import fr.univrouen.rss22xml.model.Item;
import fr.univrouen.rss22xml.repository.ItemRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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
    @GetMapping(value = "rss22/delete/{guid}")
    String deleteItem(@PathVariable(value = "guid") UUID itemguid) throws RessourceNotFoundExceptions{
        Item item = itemRepository.findById(itemguid)
                .orElseThrow(() -> new RessourceNotFoundExceptions("Item not found for this id ::" + itemguid));
        itemRepository.delete(item);

        return  "redirect:/rss22/resume/html";
    }
    @RequestMapping(value = "/rss22/insert", method = RequestMethod.POST )
    public String createItem(@RequestParam(value = "itemxml") String xmlInput,Model model) throws RessourceNotFoundExceptions {
        if (validationxml()==true) {
            try {
                JAXBContext context = JAXBContext.newInstance(Item.class);
                Unmarshaller un = context.createUnmarshaller();
                Document doc = convertStringToXMLDoc(xmlInput);
                Item item = (Item) un.unmarshal(doc);
                itemRepository.save(item);
                return "redirect:/rss22/resume/html";
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/rss22/resume/html";
    }

    public  boolean validationxml()throws RessourceNotFoundExceptions{
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/static/xsd/item.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("src/main/resources/static/xml/item.xml")));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

    private static Document convertStringToXMLDoc(String strXMLValue) {

        try {

            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(strXMLValue)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
