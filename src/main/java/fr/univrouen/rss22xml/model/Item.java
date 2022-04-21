package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@Entity
@Table(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "guid",
        "title",
        "published"
})
@XmlRootElement(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @XmlElement(required = true)
    protected Long guid;
    @Column(name="title")
    @XmlElement(required = true)
    protected String title;
    @Column(name="published")
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected String published;
    public Item() {
    }

    public Item(Long guid, String title, String published) {
        this.guid = guid;
        this.title = title;
        this.published = published;
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid + ") Le = " + published );
    }
}