package com.catdog.userservice.dto;

public class AddressDto {
    private final String id;
    private final String line;
    private final String city;
    private final String province;

    public AddressDto(String id, String line, String city, String province) {
        this.id = id;
        this.line = line;
        this.city = city;
        this.province = province;
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
}
