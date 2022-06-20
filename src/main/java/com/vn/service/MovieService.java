package com.vn.service;

import org.springframework.data.domain.Page;

import com.vn.entities.Movie;

public interface MovieService {

	public Page<Movie> findAll(Integer page, Integer size);
}
