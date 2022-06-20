package com.vn.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String actor;

	private String content;

	private String director;

	private Integer duration;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fromDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate toDate;

	private String movieProductionCompany;

	private String version;

	private String movieNameEnglish;

	private String movieNameVN;

	private String largeImage;

	private String smallImage;

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


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
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

}
