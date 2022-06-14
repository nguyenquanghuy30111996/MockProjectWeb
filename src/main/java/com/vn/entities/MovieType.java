package com.vn.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MOVIE_TYPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieType {

	@EmbeddedId
	private MovieTypeId movieTypeId;

	@ManyToOne
	@MapsId("movieId")
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

	@ManyToOne
	@MapsId("typeId")
	@JoinColumn(name = "TYPE_ID")
	private Type type;
}
