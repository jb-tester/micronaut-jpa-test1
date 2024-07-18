package com.mytests.micronaut.data;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
@Serdeable
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "city", length = 15)
    private String city;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "street", length = 15)
    private String street;

    @Column(name = "building")
    private Integer building;

    @Column(name = "flat")
    private Integer flat;

    @Column(name = "rooms_amount")
    private Integer roomsAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Integer getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(Integer roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public Address() {
    }
}