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
        "published",
        "content"
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
    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;

    public Item() {
    }

    public Item(Long guid, String title, String published, Content content) {
        this.guid = guid;
        this.title = title;
        this.published = published;
        this.content = content;
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid + ") Le = " + published );
    }
}