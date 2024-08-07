package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.Address;
import com.mytests.micronaut.repositories.AddressRepoClass;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.util.List;


@Controller("/address")
public class AddressController {
    @Inject
    AddressRepoClass repoClass;

    @Get("/all")
    public List<Address> allAdresses(){
        return (List<Address>) repoClass.findAll();
    }
    @Get("/byId/{id}")
    public Address adressById(@PathVariable String id){
        return repoClass.findByIdOrCreate(Integer.valueOf(id));
    }
}
