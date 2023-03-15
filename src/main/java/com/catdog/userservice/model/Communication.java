package com.catdog.userservice.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Communication")
public class Communication {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private final String email;
    private final String phone;

    @OneToMany(mappedBy = "communication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final Set<Address> addresses;

    private final LocalDateTime creationDate;

    public Communication() {
        this.id = "";
        this.email = "";
        this.phone = "";
        this.addresses = null;
        this.creationDate = null;
    }
    public Communication(String id, String email, String phone, Set<Address> addresses, LocalDateTime creationDate) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
        this.creationDate = creationDate;
    }

    public Communication(String email) {
        this.email = email;
        this.phone = "";
        this.addresses = null;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Communication that = (Communication) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(addresses, that.addresses) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone, creationDate);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
