package fr.univrouen.rss22xml.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "content", namespace = "http://univrouen.fr/rss22")
public class Content {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "type")
    protected String type;

    public Content() {
    }

    public Content(String value, String href, String type) {
        this.value = value;
        this.href = href;
        this.type = type;
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


    public void setHref(String value) {
        this.href = value;
    }


    public String getType() {
        return type;
    }


    public void setType(String value) {
        this.type = value;
    }

}