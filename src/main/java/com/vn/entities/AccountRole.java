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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_ROLE")
public class AccountRole {

	@EmbeddedId
	private AccountRoleId accountRoleId;
	
	@ManyToOne
	@MapsId("accountId")
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	@ManyToOne
	@MapsId("roleId")
	@JoinColumn(name="ROLE_ID")
	private Role role;
}
