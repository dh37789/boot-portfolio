package com.mho.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mho.portfolio.domain.UserSkill;
import com.mho.portfolio.repository.UserSkillRepository;
import com.mho.portfolio.service.UserSkillService;

@Service
public class UserSkillServiceImpl implements UserSkillService{

	private final UserSkillRepository userSkillRepository;
	
	public UserSkillServiceImpl(UserSkillRepository userSkillRepository) {
		this.userSkillRepository = userSkillRepository;
	}
	
	@Override
	public List<UserSkill> findAllById(String user_id) {
		return userSkillRepository.findAllById(user_id);
	}

}
