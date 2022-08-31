package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.Owner;
import com.mytests.micronaut.repositories.OwnerRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.util.List;

/**
 * *
 * <p>Created by irina on 12.10.2020.</p>
 * <p>Project: micronaut-jpa-test1</p>
 * *
 */
@Controller("/owners")
public class OwnerController {

    @Inject
    OwnerRepository repo;

    @Get("/all")
    public List<Owner> getAll() {

        return repo.findAll();
    }

    @Get("/byname/{name}")
    public List<Owner> getbyname(@PathVariable String name) {

        return repo.query1(name);
    }
}    