package com.klef.fsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User
{
    @Id
    @Column(name = "uid")
    private int id;

    @Column(name = "uname", length = 50, nullable = false)
    private String name;

    @Column(name = "ugender", length = 10, nullable = false)
    private String gender;

    @Column(name = "uphno", length = 20, unique = true, nullable = false)
    private String contact;

    @Column(name = "ulocation", length = 100, nullable = false)
    private String location;

    // Getters and Setters
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString Method
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", contact=" + contact + ", location=" + location + "]";
    }
}
