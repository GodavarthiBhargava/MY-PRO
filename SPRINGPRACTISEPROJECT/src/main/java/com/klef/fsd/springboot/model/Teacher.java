package com.klef.fsd.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_table")
public class Teacher
{
    @Id
    @Column(name = "tid")
    private int id;

    @Column(name = "tname", length = 50, nullable = false)
    private String name;

    @Column(name = "tgender", length = 10, nullable = false)
    private String gender;

    @Column(name = "tcontact", length = 20, unique = true, nullable = false)
    private String contact;

    @Column(name = "tsubject", length = 100, nullable = false)
    private String subject;

    // Getters & Setters
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender +
               ", contact=" + contact + ", subject=" + subject + "]";
    }
}
