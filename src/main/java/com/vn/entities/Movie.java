package com.vn.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "MOVIE")
public class Movie {
	@Id
	@GeneratedValue
	@Column(name = "MOVIE_ID")
	private String movieId;

	@Column(name = "ACTOR")
	private String actor;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "FROM_DATE")
	private LocalDate fromDate;

	@Column(name = "TO_DATE")
	private LocalDate toDate;

	@Column(name = "MOVIE_PRODUCTION_COMPANY")
	private String movieProductionCompany;

	@Column(name = "VERSION")
	private String version;

	@Column(name = "MOVIE_NAME_ENGLISH")
	private String movieNameEnglish;

	@Column(name = "MOVIE_NAME_VN")
	private String movieNameVn;

	@Column(name = "DURATION")
	private Integer duration;

	@Column(name = "small_image")
	private String smallImage;

	@Column(name = "large_image")
	private String largeImage;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieType> movieTypes;

	@OneToMany(mappedBy = "movie")
	private List<Show> shows;
}

