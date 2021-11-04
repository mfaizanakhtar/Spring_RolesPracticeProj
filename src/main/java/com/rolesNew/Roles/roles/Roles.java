package com.rolesNew.Roles.roles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roles {

    @Id
    @GeneratedValue
    private int id;
    private String description;
//    @JsonSerialize(using=StringBooleanSerializer.class)
    private Boolean status;

    public Roles() {
    }

    public Roles(String description, Boolean status) {
        this.description = description;
        this.status = status;
    }

    public Roles(int id, String description, Boolean status) {
        this.description = description;
        this.status = status;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
