package com.crud.customer;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

//Customer Object
public class Customer {

    private Long id;
    
    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @Email
    private String email;
    
    private String phone;

    public Customer(Long id, String fName, String lName, String email, String phone){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
