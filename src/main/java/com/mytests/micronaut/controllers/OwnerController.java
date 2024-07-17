package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.CatOwner;
import com.mytests.micronaut.repositories.OwnerRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;

import java.util.List;


@Controller("/owners")
public class OwnerController {

    @Inject
    OwnerRepository repo;

    @Transactional
    @Get("/all")
    public List<CatOwner> getAll() {

        return repo.findAll();
    }

    @Get("/byname/{name}")
    public List<CatOwner> getbyname(@PathVariable String name) {

        return repo.query1(name);
    }
}    