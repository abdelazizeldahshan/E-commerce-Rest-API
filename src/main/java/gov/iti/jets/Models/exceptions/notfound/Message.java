package gov.iti.jets.Models.exceptions.notfound;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

    private String message;
    private String fixingErrorMessage;

    public Message(String message, int code, String fixingErrorMessage) {
        this.message = message;
        this.fixingErrorMessage = fixingErrorMessage;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFixingErrorMessage() {
        return fixingErrorMessage;
    }

    public void setFixingErrorMessage(String fixingErrorMessage) {
        this.fixingErrorMessage = fixingErrorMessage;
    }

    @Override
    public String toString() {
        return "Message [fixingErrorMessage=" + fixingErrorMessage + ", message=" + message + "]";
    }
}
