package com.vn.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vn.entities.Role;
import com.vn.entities.Users;

public class CustomUserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	Users users;
	List<Role> roles;
	
	public CustomUserDetail(Users users, List<Role> roles) {
		super();
		this.users = users;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		roles.forEach(x -> {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(x.getName());
			authorities.add(authority);
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return users.getActive();
	}

	public Users getUsers() {
		return users;
	}

	public List<Role> getRoles() {
		return roles;
	}

}
