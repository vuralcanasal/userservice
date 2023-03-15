package com.catdog.userservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private final String iban;
    private final LocalDateTime creationDate;

    public Account() {
        this.id = "";
        this.iban = "";
        this.creationDate = null;
    }
    public Account(String id, String iban, LocalDateTime creationDate) {
        this.id = id;
        this.iban = iban;
        this.creationDate = creationDate;
    }

    public Account(String iban) {
        this.iban = iban;
        this.creationDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
