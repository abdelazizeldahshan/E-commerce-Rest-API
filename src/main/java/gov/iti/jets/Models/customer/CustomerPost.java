package gov.iti.jets.Models.customer;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerPost {

    private String name;
    private String email;
    private String interst;
    private String jop;
    private String address;
    private String gender;
    private double creditLimit;
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

    public String getInterst() {
        return interst;
    }

    public void setInterst(String interst) {
        this.interst = interst;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerPost [address=" + address + ", creditLimit=" + creditLimit + ", email=" + email + ", gender="
                + gender + ", interst=" + interst + ", jop=" + jop + ", name=" + name + ", password=" + password + "]";
    }

}
