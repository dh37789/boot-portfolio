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
@Getter @Setter
@NoArgsConstructor
@Table(name="SKILLCLS")
public class SkillCls {

	@Id
	@Column(name = "SKILL_CLS_NO", length = 1)
	private String skill_cls_no;
	
	@Column(name = "skill_cls_nm", length = 20)
	private String skill_cls_nm;

	@Builder
	public SkillCls(String skill_cls_no, String skill_cls_nm) {
		this.skill_cls_no = skill_cls_no;
		this.skill_cls_nm = skill_cls_nm;
	}

	@Override
	public String toString() {
		return "SkillCls {" +
				"skill_cls_no='" + skill_cls_no + '\'' +
				", skill_cls_nm='" + skill_cls_nm + '\'' +
				'}';
	}
}
