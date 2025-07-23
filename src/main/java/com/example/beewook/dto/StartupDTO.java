package com.example.beewook.dto;

import com.example.beewook.model.Startup;

import java.util.List;

public class StartupDTO {
    private Long id;
    private String name;
    private String idea;
    private String description;
    private List<String> stack;
    private String contacts;
    private Long userId;

    public StartupDTO() {}

    public StartupDTO(Long id, String name, String idea, String description, List<String> stack, String contacts, Long userId) {
        this.id = id;
        this.name = name;
        this.idea = idea;
        this.description = description;
        this.stack = stack;
        this.contacts = contacts;
        this.userId = userId;
    }

    public StartupDTO(Startup startup) {
        this.id = startup.getId();
        this.name = startup.getName();
        this.idea = startup.getIdea();
        this.description = startup.getDescription();
        this.stack = startup.getStack();
        this.contacts = startup.getContacts();
        this.userId = startup.getUserId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
