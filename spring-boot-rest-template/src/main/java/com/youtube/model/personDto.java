package com.youtube.model;

import java.util.List;

public class personDto {
    private Long id;
    private String name;
    private Double contact;
    private List<String> address;

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

    public Double getContact() {
        return contact;
    }

    public void setContact(Double contact) {
        this.contact = contact;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
