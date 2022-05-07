package gov.iti.jets.Models.clerks;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clerk {

    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clerk [email=" + email + ", id=" + id + ", name=" + name + "]";
    }
}
