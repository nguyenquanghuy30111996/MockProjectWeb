package com.vn.MockProjectWeb.member;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username", unique = true)

	@Size(min = 6, max = 15, message = "Username length must be between 6 and 15 !")
	@NotNull(message = "The required fields are null")
	private String username;

	@NotNull(message = "The required fields are null !")
	@Size(min = 6, message = "Password must be at least 6 characters !")
	private String password;

	@NotNull
	@Column(name = "re_password")
	@NotBlank(message = "The required fields are not blank !")
	private String rePassword;

	@NotNull
	@NotBlank(message = "The required fields are not blank !")
	private String fullName;

	@NotNull
	@NotBlank(message = "The required fields are not blank !")
	private String dateOfBirth;

	private String gender;

	@Email(message = "Email is invalid , please enter email correct !")
	@NotBlank(message = "The required fields are not blank !")
	@NotNull
	private String email;

	@NotNull
	@NotBlank(message = "The required fields are not blank !")
	private String identityCard;

	@NotNull
	@NotBlank(message = "The required fields are not blank !")
	private String phoneNumber;

	@NotNull
	@NotBlank(message = "The required fields are not blank !")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
