package com.mho.portfolio.user;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mho.portfolio.authority.Authority;

import lombok.*;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@Builder
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

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

	@ManyToMany
	@JoinTable(name="userauth",
			   joinColumns = @JoinColumn(name = "user_mail"),
			   inverseJoinColumns = @JoinColumn(name = "auth_id"))
	private Set<Authority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) authorities;
	}
	
	@Builder
	public User(String user_mail, String user_pass, String user_nm, String user_tel, String user_add) {
		this.user_mail = user_mail;
		this.user_pass = user_pass;
		this.user_nm = user_nm;
		this.user_tel = user_tel;
		this.user_add = user_add;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
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