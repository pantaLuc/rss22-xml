package fr.univrouen.rss22xml.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "category", namespace = "http://univrouen.fr/rss22")
public class Category {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "term")
    protected String term;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getTerm() {
        return term;
    }


    public void setTerm(String value) {
        this.term = value;
    }

}