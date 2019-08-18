package com.mho.portfolio.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID", length = 20)
	private String user_id;

	@Column(name = "USER_MAIL", length = 20)
	private String user_mail;
	
	@Column(name = "USER_PASS", length = 500)
	private String user_pass;
	
	@Column(name = "USER_NM", length = 10)
	private String user_nm;

	@Column(name = "USER_TEL", length = 20)
	private String user_tel;
	
	@Column(name = "USER_ADD", length = 50)
	private String user_add;
	
	@Column(name = "USER_DTL", length = 2000)
	private String user_dtl;
	
	@Column(name="USER_GITURL", length = 200)
	private String user_gitUrl;
	
	@Column(name="USER_BLOGURL", length = 200)
	private String user_blogUrl;

	@Column(name = "USER_BIRTH", length = 200)
	private String user_birth;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="userauth",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "auth_id"))
	private Set<Authority> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>(roles.size());
		for (Authority role : roles){
			authorities.add(new SimpleGrantedAuthority(role.getAuth_name()));
		}
		return authorities;
	}
	
	@Builder
	public User(String user_id, String user_mail, String user_pass, String user_nm, String user_tel, String user_add,
			String user_dtl, String user_gitUrl, String user_blogUrl, String user_birth) {
		this.user_id = user_id;
		this.user_mail = user_mail;
		this.user_pass = user_pass;
		this.user_nm = user_nm;
		this.user_tel = user_tel;
		this.user_add = user_add;
		this.user_dtl = user_dtl;
		this.user_gitUrl = user_gitUrl;
		this.user_blogUrl = user_blogUrl;
		this.user_birth = user_birth;
	}

	@Override
	public String getUsername() {
		return this.user_id;
	}
	
	@Override
	public String getPassword() {
		return this.user_pass;
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

	@Override
	public String toString() {
		return "User {" +
				"user_id='" + user_id + '\'' +
				", user_mail='" + user_mail + '\'' +
				", user_pass='" + user_pass + '\'' +
				", user_nm='" + user_nm + '\'' +
				", user_tel='" + user_tel + '\'' +
				", user_add='" + user_add + '\'' +
				", user_dtl='" + user_dtl + '\'' +
				", user_gitUrl='" + user_gitUrl + '\'' +
				", user_blogUrl='" + user_blogUrl + '\'' +
				", user_birth='" + user_birth + '\'' +
				'}';
	}
}