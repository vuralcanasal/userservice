package com.catdog.userservice.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private final String line;
    private final String city;
    private final String province;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "communication_id", nullable = false)
    private final Communication communication;

    private final LocalDateTime creationDate;

    public Address(String id, String line, String city, String province, Communication communication, LocalDateTime creationDate) {
        this.id = id;
        this.line = line;
        this.city = city;
        this.province = province;
        this.communication = communication;
        this.creationDate = creationDate;
    }

    public Address() {
        this.line = "";
        this.city = "";
        this.province = "";
        this.communication = null;
        this.creationDate = null;
    }
    public Address(String line, String city, String province, Communication communication) {
        this.line = line;
        this.city = city;
        this.province = province;
        this.communication = communication;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(line, address.line) && Objects.equals(city, address.city) && Objects.equals(province, address.province) && Objects.equals(communication, address.communication) && Objects.equals(creationDate, address.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, line, city, province, creationDate);
    }

    public String getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public Communication getCommunication() {
        return communication;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
