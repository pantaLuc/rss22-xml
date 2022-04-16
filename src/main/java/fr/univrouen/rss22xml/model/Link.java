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


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getHref() {
        return href;
    }


    public void setHref(String value) {
        this.href = value;
    }

    public String getRel() {
        return rel;
    }


    public void setRel(String value) {
        this.rel = value;
    }

    public Link() {
    }

    public Link(String value, String href, String rel, String type) {
        this.value = value;
        this.href = href;
        this.rel = rel;
        this.type = type;
    }

    public String getType() {
        return type;
    }


    public void setType(String value) {
        this.type = value;
    }

}
