package com.vn.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountRoleId implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "ROLE_ID")
	private Integer roleId;

	@Override
	public int hashCode() {
		return Objects.hash(accountId, roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountRoleId other = (AccountRoleId) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(roleId, other.roleId);
	}

	
	
	
	
}
