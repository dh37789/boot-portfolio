package com.mho.portfolio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Project")
@Getter @Setter
@NoArgsConstructor
public class Project {
	
	@Id
	@Column(name = "PROJ_NO")
	private String proj_no;
	
	@Column(name = "PROJ_TITLE")
	private String proj_title;
	
	@Column(name = "PROJ_SUBCON")
	private String proj_subcon;
	
	@Column(name = "PROJ_CON")
	private String proj_con;
	
	@Column(name = "PROJ_START")
	private String proj_start;
	
	@Column(name = "PROJ_END")
	private String proj_end;
	
	@Column(name = "PROJ_DATE")
	private String proj_date;
	
	@Column(name = "PROJ_GIT")
	private String proj_git;
	
	@Builder
	public Project(String proj_no, String proj_title, String proj_subcon, String proj_con, String proj_start,
			String proj_end, String proj_date, String proj_git) {
		this.proj_no = proj_no;
		this.proj_title = proj_title;
		this.proj_subcon = proj_subcon;
		this.proj_con = proj_con;
		this.proj_start = proj_start;
		this.proj_end = proj_end;
		this.proj_date = proj_date;
		this.proj_git = proj_git;
	}
	
	
}
