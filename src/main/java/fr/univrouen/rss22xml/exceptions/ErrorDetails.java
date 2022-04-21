package fr.univrouen.rss22xml.exceptions;


import javax.xml.bind.annotation.*;
import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "timestamps",
        "message",
        "details"
})
@XmlRootElement(name = "error")
public class ErrorDetails {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date timestamps;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String details;

    public ErrorDetails() {
    }

    public ErrorDetails(Date timestamps, String message, String details) {
        this.timestamps = timestamps;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}