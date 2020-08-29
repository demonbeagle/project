package com.uabc.project.project.repository;

import com.uabc.project.project.model.Cigarros;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CigarrosRepository extends CrudRepository<Cigarros, Long> {

    List<Cigarros> findByCigarrosNombre(String cigarrosNombre);

    @Query("SELECT a FROM Cigarros a WHERE a.cigarrosNombre=:cigarrosNombre")
    List<Cigarros> fetchCigarros(@Param("cigarrosNombre") String cigarrosNombre);
}
