package fr.univrouen.rss22xml.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="contributor")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {

        "name",
        "uri",
})
@XmlRootElement(name = "contributor", namespace = "http://univrouen.fr/rss22")
public class Contributor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String name;
    @Column(name="uri")
    @XmlElement(namespace = "http://univrouen.fr/rss22", required = true)
    protected String uri;
    @ManyToMany(fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
    private Set<Item> list_item;

    public Contributor() {
    }

    public Contributor(String name, String uri, Set<Item> list_item) {
        this.name = name;
        this.uri = uri;
        this.list_item = list_item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Set<Item> getList_item() {
        return list_item;
    }

    public void setList_item(Set<Item> list_item) {
        this.list_item = list_item;
    }
}