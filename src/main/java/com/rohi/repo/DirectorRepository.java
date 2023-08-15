package com.rohi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohi.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
//    List<Director> findByFirstNameAndLastName(String firstName, String lastName);
    List<Director> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
