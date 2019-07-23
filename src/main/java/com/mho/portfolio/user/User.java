package com.mho.portfolio.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

@Entity
@Table(name = "USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails{
	
	@Id
	@Column(length = 20)
	private String user_mail;
	
	@Column(length = 500)
	private String user_pass;
	
	@Column(length = 10)
	private String user_nm;

	@Column(length = 12)
	private String user_tel;
	
	@Column(length = 50)
	private String user_add;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return user_mail;
	}

	@Override
	public String getPassword() {
		return user_pass;
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
		return true;
	}

}