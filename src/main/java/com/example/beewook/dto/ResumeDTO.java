package com.example.beewook.dto;

import com.example.beewook.model.Resume;

import java.util.List;

public class ResumeDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String city;
    private List<String> stack;
    private String contacts;
    private Long userId;


    public ResumeDTO(Long id, String first_name, String last_name, String city, List<String> stack, String contacts, Long userId) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.stack = stack;
        this.contacts = contacts;
        this.userId = userId;
    }

    public ResumeDTO(Resume resume) {
        this(resume.getId(), resume.getFirst_name(), resume.getLast_name(), resume.getCity(), resume.getStack(), resume.getContacts(),  resume.getUserId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getUserId() { return userId; }

}
