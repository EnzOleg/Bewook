package com.example.beewook.model;

import com.example.beewook.dto.StartupDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="startups")
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 1000)
    private String idea;

    private String description;

    @ElementCollection
    @CollectionTable(name = "startup_stack", joinColumns = @JoinColumn(name = "startup_id"))
    @Column(name = "stack_item")
    @Size(max = 50)
    private List<String> stack;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String contacts;

    public Startup(StartupDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.idea = dto.getIdea();
        this.description = dto.getDescription();
        this.stack = dto.getStack();
        this.userId = dto.getUserId();
        this.contacts = dto.getContacts();
    }


    public Startup(Long id, String name, String idea, String description, List<String> stack, Long userId, String contacts) {
        this.id = id;
        this.name = name;
        this.idea = idea;
        this.description = description;
        this.stack = stack;
        this.contacts = contacts;
        this.userId = userId;
    }

    public Startup() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdea() {
        return idea;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getStack() {
        return stack;
    }

    public Long getUserId() {
        return userId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
