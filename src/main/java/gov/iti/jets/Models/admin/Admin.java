package gov.iti.jets.Models.admin;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Admin {

    private String name;
    private String email;
    private String password;
    private int id;

    public Admin() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [email=" + email + ", id=" + id + ", name=" + name + ", password=" + password + "]";
    }
}
