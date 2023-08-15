package com.rohi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohi.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieTitleIgnoreCase(String movieTitle);
}
