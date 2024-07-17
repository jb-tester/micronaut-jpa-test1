package com.mytests.micronaut.repositories;

import com.mytests.micronaut.data.CatOwner;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface OwnerRepository extends CrudRepository<CatOwner, Integer> {


    List<CatOwner> findAll();

    @Query("select o from CatOwner o where o.name like :oname order by o.id")
    List<CatOwner> query1(String oname);


}
