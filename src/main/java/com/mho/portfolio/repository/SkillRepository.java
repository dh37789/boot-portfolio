package com.mho.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mho.portfolio.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, String>{

}
