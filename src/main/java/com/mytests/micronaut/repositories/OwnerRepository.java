package com.mytests.micronaut.repositories;

import com.mytests.micronaut.data.Owner;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 12.10.2020.</p>
 * <p>Project: micronaut-jpa-test1</p>
 * *
 */
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    List<Owner> findAll();

    @Query("select o from Owner o where o.name like :oname order by o.ownerId")
    List<Owner> query1(String oname);


}
