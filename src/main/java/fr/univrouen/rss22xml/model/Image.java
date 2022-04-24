package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="image")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "image", namespace = "http://univrouen.fr/rss22")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @Column(name="value")
    @XmlValue
    protected String value;
    @Column(name="alt")
    @XmlAttribute(name = "alt")
    protected String alt;
    @Column(name="href")
    @XmlAttribute(name = "href")
    protected String href;
    @Column(name="length")
    @XmlAttribute(name = "length")
    protected Short length;
    @Column(name="type")
    @XmlAttribute(name = "type")
    protected String type;
    @OneToOne(mappedBy = "image")
    private Item item;

    public Image() {
    }

    public Image(String value, String alt, String href, Short length, String type, Item item) {
        this.value = value;
        this.alt = alt;
        this.href = href;
        this.length = length;
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

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
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