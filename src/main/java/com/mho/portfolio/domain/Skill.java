package com.mho.portfolio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SKILL")
@Getter
@Setter
@NoArgsConstructor
public class Skill {

  @Id
  @Column(name = "SKILL_NO", length = 5)
  private String skill_no;

  @Column(name = "SKILL_NM", length = 30)
  private String skill_nm;

  @Column(name = "SKILL_CLS_NO", length = 1)
  private String skill_cls_no;

  @Column(name = "SKILL_IMG", length = 20)
  private String skill_img;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "SKILL_CLS_NO",
      insertable = false, updatable = false)
  private SkillCls skillCls;

  @Builder
  public Skill(String skill_no, String skill_nm, String skill_cls_no, String skill_img) {
    this.skill_no = skill_no;
    this.skill_nm = skill_nm;
    this.skill_cls_no = skill_cls_no;
    this.skill_img = skill_img;
  }
}
