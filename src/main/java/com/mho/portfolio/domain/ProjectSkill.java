package com.mho.portfolio.domain;

import java.io.Serializable;
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
@Table(name = "PROJECTSKILL")
@NoArgsConstructor
public class ProjectSkill implements Serializable{

  @Id
  @Column(name = "PROJ_NO")
  private String proj_no;

  @Id
  @Column(name = "SKILL_NO")
  private String skill_no;

  @Builder
  public ProjectSkill(String proj_no, String skill_no) {
    this.proj_no = proj_no;
    this.skill_no = skill_no;
  }

  @Override
  public String toString() {
    return "ProjectSkill {" +
        "proj_no='" + proj_no + '\'' +
        ", skill_no='" + skill_no + '\'' +
        '}';
  }
}
