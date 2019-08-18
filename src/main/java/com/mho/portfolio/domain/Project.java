package com.mho.portfolio.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Project")
@Getter
@Setter
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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="PEOJECTSKILL",
             joinColumns = @JoinColumn(name = "PROJ_NO", referencedColumnName = "PROJ_ID"),
             inverseJoinColumns = @JoinColumn(name = "SKILL_NO", referencedColumnName = "SKILL_NO"))
  private List<Skill> skill = new ArrayList<>();

  @Builder
  public Project(String proj_no, String proj_title, String proj_subcon, String proj_con,
      String proj_start,  String proj_end, String proj_date, String proj_git) {
    this.proj_no = proj_no;
    this.proj_title = proj_title;
    this.proj_subcon = proj_subcon;
    this.proj_con = proj_con;
    this.proj_start = proj_start;
    this.proj_end = proj_end;
    this.proj_date = proj_date;
    this.proj_git = proj_git;
  }

  @Override
  public String toString() {
    return "Project {" +
        "proj_no='" + proj_no + '\'' +
        ", proj_title='" + proj_title + '\'' +
        ", proj_subcon='" + proj_subcon + '\'' +
        ", proj_con='" + proj_con + '\'' +
        ", proj_start='" + proj_start + '\'' +
        ", proj_end='" + proj_end + '\'' +
        ", proj_date='" + proj_date + '\'' +
        ", proj_git='" + proj_git + '\'' +
        ", skill=" + skill +
        '}';
  }
}
