package gov.iti.jets.Models.customer;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private String name;
    private String email;
    private int id;
    private String interst;
    private String jop;
    private String address;
    private String gender;
    private double creditLimit;

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

    @Override
    public String toString() {
        return "Customer [address=" + address + ", creditLimit=" + creditLimit + ", email=" + email + ", gender="
                + gender + ", id=" + id + ", interst=" + interst + ", jop=" + jop + ", name=" + name + "]";
    }

}
