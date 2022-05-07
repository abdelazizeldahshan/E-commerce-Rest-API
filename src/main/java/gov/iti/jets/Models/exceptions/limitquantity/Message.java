package gov.iti.jets.Models.exceptions.limitquantity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + "]";
    }
}
