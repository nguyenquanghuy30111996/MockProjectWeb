package com.vn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MovieTypeId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "MOVIE_ID")
	private String movieId;

	@Column(name = "TYPE_ID")
	private Integer typeId;

}