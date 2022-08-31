package com.mytests.micronaut.repositories;

import com.mytests.micronaut.data.Cat;
import com.mytests.micronaut.data.Owner;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.annotation.EntityGraph;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 05.10.2020.</p>
 * <p>Project: micronaut-jpa-test1</p>
 * *
 */
@Repository
public interface CatsRepository extends CrudRepository<Cat, Integer> {
    
    List<Cat> findByOwnerAddressCity(String owner_address_city);
    
    List<String> findCatNameByOwnerName(String owner_name);
    
    List<Owner> findOwnerByCatName(String catName);
    
    @Join(value = "owner", type = Join.Type.FETCH)   // columns references
    List<Cat> list();
    
    @EntityGraph(attributePaths = {"owner"})   // columns references
    List<Cat> find();


}
