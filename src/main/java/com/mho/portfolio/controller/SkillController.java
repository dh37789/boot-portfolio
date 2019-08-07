package com.mho.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.domain.Skill;
import com.mho.portfolio.domain.UserSkill;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.service.ResponseService;
import com.mho.portfolio.service.SkillService;
import com.mho.portfolio.service.UserSkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

	private final ResponseService responseService;
	private final SkillService skillService;
	private final UserSkillService userSkillService;
	
	public SkillController(ResponseService responseService, SkillService skillService, 
			UserSkillService userSkillService) {
		this.responseService = responseService;
		this.skillService = skillService;
		this.userSkillService = userSkillService;
	}
	
	@GetMapping("")
	public ListResult<Skill> list(){
		return responseService.getListResult(skillService.getList());
	}
	
	@GetMapping("/{user_id}")
	public ListResult<UserSkill> userSkillList(@PathVariable String user_id){
		return responseService.getListResult(userSkillService.findAllById(user_id));
	}
}
