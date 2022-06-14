package com.vn.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vn.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "REGISTER_DATE")
	private LocalDate registerDate;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dateOfBirth;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FULL_NAME")
	private String fullname;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "IDENTITYCARD")
	private String identityCard;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private AccountStatus status;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<AccountRole> accountRoles;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Member member;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Employee employee;

	@OneToMany(mappedBy = "account")
	private List<Booking> bookings;
	
	
	
	
	
}
