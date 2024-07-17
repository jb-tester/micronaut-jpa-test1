package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.Cat;
import com.mytests.micronaut.data.CatOwner;
import com.mytests.micronaut.repositories.CatsRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;


@Controller("/cats")
public class CatsController {

    @Inject
    CatsRepository repo;



    @Get("/byownercity/{city}")
    public List<String> getbyownercity(@PathVariable("city") String city) {
        List<Cat> cats = repo.findByOwnerAddressCity(city);
        List<String> rez = new ArrayList<>();
        for (Cat s : cats) {
            rez.add(s.toString());
        }
        return rez;
    }
    @Get("/byownername/{name}")
    public List<String> getbyownername(@PathVariable("name") String name) {
        
        return repo.findCatNameByOwnerName(name) ;
    }
    @Get("/ownerbycatname/{name}/")
    public List<String> getownerbycatname(@PathVariable("name") String name) {
        List<String> rez = new ArrayList<>();
        List<CatOwner> o = repo.findOwnerByCatName(name);
        for (CatOwner owner : o) {
            rez.add(o.toString());
        }
        return rez;
    }

    @Get("/join")
    public List<String> join() {
        List<Cat> cats = repo.list();
        List<String> rez = new ArrayList<>();
        for (Cat s : cats) {
            rez.add(s.toString());
        }
        return rez;
    }

    @Get("/graph")
    public List<String> graph() {
        List<Cat> cats = repo.find();
        List<String> rez = new ArrayList<>();
        for (Cat s : cats) {
            rez.add(s.toString());
        }
        return rez;
    }


}
