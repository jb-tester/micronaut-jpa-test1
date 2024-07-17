package com.mytests.micronaut.data;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

@Entity
@Table(name = "cats")
@Serdeable
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "cat_name", length = 15)
    private String catName;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "breed", length = 15)
    private String breed;

    @jakarta.validation.constraints.Size(max = 15)
    @Column(name = "color", length = 15)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    //@JoinColumn(name = "owner", referencedColumnName = "owner_id")
    private CatOwner owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CatOwner getOwner() {
        return owner;
    }

    public void setOwner(CatOwner owner) {
        this.owner = owner;
    }

}