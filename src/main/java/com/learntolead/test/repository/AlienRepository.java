package com.learntolead.test.repository;

import com.learntolead.test.entity.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlienRepository extends JpaRepository<Alien, Integer> {

    List<Alien> findByName(String name);

    @Query(value = "select * from Alien a where a.gender = ?1" ,nativeQuery = true)
    List<Alien> getByAlienGender(String gender);
}
