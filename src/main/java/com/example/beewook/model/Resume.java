package com.example.beewook.model;

import com.example.beewook.dto.ResumeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String first_name;

    @Column(length = 50)
    private String last_name;

    private String city;

    @ElementCollection
    @CollectionTable(name = "resume_stack", joinColumns = @JoinColumn(name = "resume_id"))
    @Column(name = "stack_item")
    @Size(max = 50)
    private List<String> stack;

    private String contacts;

    @Column(name = "user_id", nullable = false)
    private Long userId;


    public Resume() {}

    public Resume(ResumeDTO dto) {
        this(dto.getId(), dto.getFirst_name(), dto.getLast_name(), dto.getCity(), dto.getStack(), dto.getContacts(), dto.getUserId());
    }

    public Resume(Long id, String first_name, String last_name, String city, List<String> stack, String contacts, Long userId) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.stack = stack;
        this.contacts = contacts;
        this.userId = userId;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCity() {
        return city;
    }

    public List<String> getStack() {
        return stack;
    }

    public String getContacts() {
        return contacts;
    }

    public Long getUserId() {
        return userId;
    }

}
