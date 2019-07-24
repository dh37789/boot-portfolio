package com.mho.portfolio.authority;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "authority")
@Getter @Setter
@NoArgsConstructor
public class Authority {
	
	@Id
	@Column(length = 20)
	private String auth_id;
	
	@Column(length = 20)
	private String auth_name;
	
	@Builder
	public Authority(String auth_id, String auth_name) {
		this.auth_id = auth_id;
		this.auth_name = auth_name;
	}
	
}
