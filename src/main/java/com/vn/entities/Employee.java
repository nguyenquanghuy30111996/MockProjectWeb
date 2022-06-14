package com.vn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	
	
	@OneToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	public Employee(Account account) {
		super();
		this.account = account;
	}
}
