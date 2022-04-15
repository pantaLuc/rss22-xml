package fr.univrouen.rss22xml.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "guid",
        "title",
        "published"
})
@XmlRootElement(name = "item")
public class Item {

    @XmlElement(required = true)
    protected String guid;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected String published;

    public Item() {
    }

    public Item(String guid, String title, String published) {
        this.guid = guid;
        this.title = title;
        this.published = published;
    }

    public String getGuid() {
        return guid;
    }


    public void setGuid(String value) {
        this.guid = value;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String value) {
        this.title = value;
    }


    public String getPublished() {
        return published;
    }


    public void setPublished(String value) {
        this.published = value;
    }

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid + ") Le = " + published );
    }
}