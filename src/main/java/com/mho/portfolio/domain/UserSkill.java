package com.mho.portfolio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@IdClass(UserSkill.class)
@Table(name="USERSKILL")
public class UserSkill implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID", length = 20)
	private String id; 

	@Id
	@Column(name = "SKILL_NO", length = 5)
	private String skill_no;

	@Column(name = "SKILL_LEV", length = 1)
	private String skill_lev;

	@Id
	@OneToOne
	@JoinColumn(name = "SKILL_NO",
	insertable = false, updatable = false)
	private Skill skill;   

	@Builder
	public UserSkill(String id, String skill_no, Skill skill, String skill_lev) {
		this.id = id;
		this.skill_no = skill_no;
		this.skill_lev = skill_lev;
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "UserSkill {" +
				"id='" + id + '\'' +
				", skill_no='" + skill_no + '\'' +
				", skill_lev='" + skill_lev + '\'' +
				", skill=" + skill +
				'}';
	}
}
