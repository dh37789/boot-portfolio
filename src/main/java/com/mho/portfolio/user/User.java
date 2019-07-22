package com.mho.portfolio.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class User{
	
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

}