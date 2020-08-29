package com.uabc.project.project.repository;

import com.uabc.project.project.model.Cigarros;
import com.uabc.project.project.model.Sodas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SodasRepository extends CrudRepository<Sodas, Long> {

    List<Sodas> findBySodasNombre(String sodasNombre);

    @Query("SELECT a FROM Sodas a WHERE a.sodasNombre=:sodasNombre")
    List<Sodas> fetchSodas(@Param("sodasNombre") String sodasNombre);
    }