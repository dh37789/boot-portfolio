package com.mho.portfolio.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User{
	
	@Id
	@Column(length = 100)
	private String id;
	
	@Column(length = 100)
	private String pass;
	
	@Column(length = 100)
	private String name;
}
