package fr.univrouen.rss22xml.model;


import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "uri"
})
@XmlRootElement(name = "author", namespace = "http://univrouen.fr/rss22")
public class Author {

    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String name;
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String uri;

    public Author() {
    }

    public Author(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String value) {
        this.uri = value;
    }

}