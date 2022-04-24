package fr.univrouen.rss22xml.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
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

    public Item() {
    }

    public Item(UUID guid, String title, String published, Content content, Image image) {
        this.guid = guid;
        this.title = title;
        this.published = published;
        this.content = content;
        this.image = image;
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

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid + ") Le = " + published );
    }
}