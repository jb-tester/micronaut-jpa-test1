package com.mytests.micronaut.repositories;

import com.mytests.micronaut.data.Cat;
import com.mytests.micronaut.data.CatOwner;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.annotation.EntityGraph;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;


@Repository
public interface CatsRepository extends CrudRepository<Cat, Integer> {
    
    List<Cat> findByOwnerAddressCity(String owner_address_city);
    
    List<String> findCatNameByOwnerName(String owner_name);

    List<CatOwner> findOwnerByCatName(String catName);

    @Join(value = "owner", type = Join.Type.FETCH)   // columns references
    List<Cat> list();
    
    @EntityGraph(attributePaths = {"owner"})   // columns references
    List<Cat> find();


}
