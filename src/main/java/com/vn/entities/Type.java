package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private Integer id;

	@Column(name = "type_name", length = 255, nullable = false)
	private String typeName;

	@OneToMany(mappedBy = "type")
	private List<Movie_Type> moTypes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Movie_Type> getMoTypes() {
		return moTypes;
	}

	public void setMoTypes(List<Movie_Type> moTypes) {
		this.moTypes = moTypes;
	}

}
