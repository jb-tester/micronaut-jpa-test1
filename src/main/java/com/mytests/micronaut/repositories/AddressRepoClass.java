package com.mytests.micronaut.repositories;

import com.mytests.micronaut.data.Address;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public abstract class AddressRepoClass implements CrudRepository<Address,Integer> {

    // this issue is addressed in the request IDEA-???? - already fixed
    public Address findByIdOrCreate(Integer id){
        Optional<Address> optionalAddress = findById(id);
        Address m;
        if (optionalAddress.isEmpty()) {
            m = new Address();
            m = save(m);
        } else {m = optionalAddress.get();}
       return m;
    }

}