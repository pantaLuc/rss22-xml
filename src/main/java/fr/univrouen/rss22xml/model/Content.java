package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "content")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "content", namespace = "http://univrouen.fr/rss22")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="value")
    @XmlValue
    protected String value;
    @Column(name="href")
    @XmlAttribute(name = "href")
    protected String href;
    @Column(name="type")
    @XmlAttribute(name = "type")
    protected String type;
    @OneToOne(mappedBy = "content")
    private Item item;

    public Content() {
    }

    public Content(String value, String href, String type, Item item) {
        this.value = value;
        this.href = href;
        this.type = type;
        this.item = item;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}