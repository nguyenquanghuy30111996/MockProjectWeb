package com.vn.entities;

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

@Entity
@Table(name = "TYPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Type {

	@Id
	@GeneratedValue
	@Column(name = "TYPE_ID")
	private Integer typeId;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private List<MovieType> movieTypes;
}
