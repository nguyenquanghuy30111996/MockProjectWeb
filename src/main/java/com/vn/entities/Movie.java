package com.vn.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Integer id;

	@Column(length = 255, nullable = false)
	private String actor;

	@Column(length = 1000, nullable = false)
	private String content;

	@Column(length = 255, nullable = false)
	private String director;

	@Column(nullable = false)
	private Integer duration;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "from_date", nullable = false)
	private LocalDate fromDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "to_date", nullable = false)
	private LocalDate toDate;

	@Column(name = "movie_production_company", length = 255, nullable = false)
	private String movieProductionCompany;

	@Column(length = 255, nullable = false)
	private String version;

	@Column(name = "movie_name_english", length = 255, nullable = false)
	private String movieNameEnglish;

	@Column(name = "movie_name_vn", length = 255, nullable = false)
	private String movieNameVN;

	@Column(name = "large_image", length = 255, nullable = false)
	private String largeImage;

	@Column(name = "small_image", length = 255, nullable = false)
	private String smallImage;

	@OneToMany(mappedBy = "movie")
	private List<Movie_Type> moTypes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Number getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getMovieProductionCompany() {
		return movieProductionCompany;
	}

	public void setMovieProductionCompany(String movieProductionCompany) {
		this.movieProductionCompany = movieProductionCompany;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMovieNameEnglish() {
		return movieNameEnglish;
	}

	public void setMovieNameEnglish(String movieNameEnglish) {
		this.movieNameEnglish = movieNameEnglish;
	}

	public String getMovieNameVN() {
		return movieNameVN;
	}

	public void setMovieNameVN(String movieNameVN) {
		this.movieNameVN = movieNameVN;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public List<Movie_Type> getMoTypes() {
		return moTypes;
	}

	public void setMoTypes(List<Movie_Type> moTypes) {
		this.moTypes = moTypes;
	}

}
