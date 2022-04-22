package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="feed")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
        "title",
        "pubDate",
        "copyright",
        "link",
        "item"
})
@XmlRootElement(name = "feed", namespace = "http://univrouen.fr/rss22")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long Id ;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String title;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String pubDate;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String copyright;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected Link link;
    @XmlElement(namespace = "http://univrouen.fr/rss22")
    @ManyToMany
    protected List<Item> item;
    @Column(name = "lang")
    @XmlAttribute(name = "lang")
    protected String lang;

    public Feed(String title, String pubDate, String copyright, Link link, List<Item> item, String lang) {
        this.title = title;
        this.pubDate = pubDate;
        this.copyright = copyright;
        this.link = link;
        this.item = item;
        this.lang = lang;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}