package fr.univrouen.rss22xml.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "image", namespace = "http://univrouen.fr/rss22")
public class Image {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "alt")
    protected String alt;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "length")
    protected Short length;
    @XmlAttribute(name = "type")
    protected String type;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getAlt() {
        return alt;
    }


    public void setAlt(String value) {
        this.alt = value;
    }


    public String getHref() {
        return href;
    }


    public void setHref(String value) {
        this.href = value;
    }


    public Short getLength() {
        return length;
    }


    public void setLength(Short value) {
        this.length = value;
    }


    public String getType() {
        return type;
    }


    public void setType(String value) {
        this.type = value;
    }


}