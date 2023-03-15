package com.catdog.userservice.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private final UserType type;
    @Column(nullable = false)
    private final String name;
    @Column(nullable = false)
    private final String surname;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "communication_id", referencedColumnName = "id", nullable = false)
    private final Communication communication;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private final Account account;

    private final LocalDateTime creationDate;

    public User() {
        this.id = "";
        this.type = null;
        this.name = "";
        this.surname = "";
        this.communication = null;
        this.account = null;
        this.creationDate = null;
    }
    public User(String id,
                UserType type,
                String name,
                String surname,
                Communication communication,
                Account account,
                LocalDateTime creationDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.communication = communication;
        this.account = account;
        this.creationDate = creationDate;
    }

    public User(UserType type, String name, String surname, Communication communication) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.communication = communication;
        this.account = null;
        this.creationDate = LocalDateTime.now();
    }

    public User(UserType type, String name, String surname) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.communication = null;
        this.account = null;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && type == user.type && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(communication, user.communication) && Objects.equals(account, user.account) && Objects.equals(creationDate, user.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, surname, creationDate);
    }

    public String getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Communication getCommunication() {
        return communication;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
