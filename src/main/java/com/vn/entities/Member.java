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
import lombok.ToString;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table( name = "MEMBER")
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private String memberId;
	
	@Column(name = "SCORE", nullable = false)
	
	private Integer score;
	
	@OneToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
}
