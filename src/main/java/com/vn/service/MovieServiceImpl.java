package com.vn.service;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.entities.Movie;
import com.vn.models.MovieDTO;
import com.vn.repository.MovieRepository;
import com.vn.utils.Const;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Page<Movie> findAll(Integer page, Integer size) {
		if (page == null)
			page = Const.Paging.PAGE_DEFAULT;
		if (size == null)
			size = Const.Paging.SIZE_DEFAULT;
		Pageable pageable = PageRequest.of(page - 1, size);

		Page<Movie> movie = movieRepository.findAll(pageable);

		
		return movie;
	}

}
