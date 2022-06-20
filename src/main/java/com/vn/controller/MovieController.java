package com.vn.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entities.Movie;
import com.vn.service.MovieService;
import com.vn.utils.Const;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/list_movie")
	public String getListMovie() {
		return "/admin/movie/list_movie";
	}
	
	@GetMapping("/movie")
	public String getMovie(
			@RequestParam(value = "page", required = false, defaultValue = Const.Paging.PAGE_DEFAULT_STR) Integer page,
			@RequestParam(value = "size", required = false, defaultValue = Const.Paging.SIZE_DEFAULT_STR) Integer size,
			Model model
			) {
		
		Page<Movie> pageData = movieService.findAll(page, size);
		model.addAttribute("list", pageData);
		
		
		int totalPages = pageData.getTotalPages();
		if(totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "admin_movie_list";
	}
	

	@GetMapping("/admin/movie/edit")
	public String showEditScreen(@RequestParam("id") Integer id, Model model) {
		//model.add..
		return "admin_movie_edit";
	}
	
}
