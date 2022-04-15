package fr.univrouen.rss22xml.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "title",
        "pubDate",
        "copyright",
        "link",
        "item"
})
@XmlRootElement(name = "feed", namespace = "http://univrouen.fr/rss22")
public class Feed {

    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String title;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String pubDate;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String copyright;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected Link link;
    @XmlElement(namespace = "http://univrouen.fr/rss22")
    protected List<Item> item;
    @XmlAttribute(name = "lang")
    protected String lang;

    public Feed() {
    }

    public Feed(String title, String pubDate, String copyright, Link link, List<Item> item, String lang) {
        this.title = title;
        this.pubDate = pubDate;
        this.copyright = copyright;
        this.link = link;
        this.item = item;
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String value) {
        this.title = value;
    }


    public String getPubDate() {
        return pubDate;
    }


    public void setPubDate(String value) {
        this.pubDate = value;
    }


    public String getCopyright() {
        return copyright;
    }


    public void setCopyright(String value) {
        this.copyright = value;
    }


    public Link getLink() {
        return link;
    }


    public void setLink(Link value) {
        this.link = value;
    }


    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }


    public void setLang(String value) {
        this.lang = value;
    }

}