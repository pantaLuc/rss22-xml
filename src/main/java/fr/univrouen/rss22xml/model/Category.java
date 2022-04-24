package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;


@Entity
@Table(name="category")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "category", namespace = "http://univrouen.fr/rss22")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="value")
    @XmlValue
    protected String value;
    @Column(name="term")
    @XmlAttribute(name = "term")
    protected String term;
    @OneToMany(mappedBy = "category")
    private List<Item> item;

    public Category() {
    }

    public Category(String value, String term, List<Item> item) {
        this.value = value;
        this.term = term;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}