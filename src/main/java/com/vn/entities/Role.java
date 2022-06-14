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



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ROLE")
public class Role {
	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private Integer roleId;
	
	@Column(name = "ROLE_NAME", nullable = false)
	
	private String roleName;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<AccountRole> accountRoles;
}
