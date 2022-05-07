package gov.iti.jets.Models.clerks;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClerkPost {

    private String name;
    private String email;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClerkPost [email=" + email + ", name=" + name + ", password=" + password + "]";
    }
}
