package fr.univrouen.rss22xml.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "guid",
        "title",
        "category",
        "published",
        "image",
        "content",
        "author",
        "contributor"
})

@XmlRootElement(name = "item")
public class Item {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "guid", updatable = false, nullable = false)
    @XmlElement(required = true)
    protected UUID guid;
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
    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;
    @XmlElement(required = true)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @XmlElement(required = true)
    @ManyToMany(fetch=FetchType.EAGER )
    private Set<Author> author;
    @XmlElement(required = true)
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Contributor> contributor;

    public Item() {
    }

    public Item(String title, String published, Content content, Image image, Category category, Set<Author> author, Set<Contributor> contributor) {
        this.title = title;
        this.published = published;
        this.content = content;
        this.image = image;
        this.category = category;
        this.author = author;
        this.contributor = contributor;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public Set<Contributor> getContributor() {
        return contributor;
    }

    public void setContributor(Set<Contributor> contributor) {
        this.contributor = contributor;
    }

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid + ") Le = " + published );
    }
}