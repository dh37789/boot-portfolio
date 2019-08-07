package com.mho.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mho.portfolio.domain.Skill;
import com.mho.portfolio.repository.SkillRepository;
import com.mho.portfolio.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{

	private final SkillRepository skillRepository;
	
	public SkillServiceImpl(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}
	
	@Override
	public List<Skill> getList() {
		List<Skill> list = null;
		list = skillRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getSkill_nm());
		}
		return list;
	}

}
