package com.vn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Page<Movie> findAll(Pageable pageable);
}
