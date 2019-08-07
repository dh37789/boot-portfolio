package com.mho.portfolio.service;

import java.util.List;

import com.mho.portfolio.domain.UserSkill;

public interface UserSkillService{
	public List<UserSkill> findAllById(String user_id);
}
