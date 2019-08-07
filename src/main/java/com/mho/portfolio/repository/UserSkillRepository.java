package com.mho.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mho.portfolio.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, String>{
	public List<UserSkill> findAllById(String user_id);
}
