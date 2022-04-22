package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name="link")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "link", namespace = "http://univrouen.fr/rss22")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name="value")
    @XmlValue
    protected String value;
    @XmlAttribute(name = "href")
    @Column(name="href")
    @XmlSchemaType(name = "anyURI")
    protected String href;
    @Column(name="rel")
    @XmlAttribute(name = "rel")
    protected String rel;
    @Column(name="type")
    @XmlAttribute(name = "type")
    protected String type;
    @OneToOne(mappedBy = "link")
    private Feed feed;

    public Link() {
    }

    public Link(String value, String href, String rel, String type, Feed feed) {
        this.value = value;
        this.href = href;
        this.rel = rel;
        this.type = type;
        this.feed = feed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
