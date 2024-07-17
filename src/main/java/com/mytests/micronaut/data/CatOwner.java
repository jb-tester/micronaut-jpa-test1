package com.mytests.micronaut.data;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cat_owners")
@Serdeable
public class CatOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "name", length = 15)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address")
    private Address address;
/*
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<com.mytests.micronaut.data.Cat> cats = new LinkedHashSet<>();*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



}