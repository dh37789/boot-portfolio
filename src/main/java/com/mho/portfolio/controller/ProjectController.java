package com.mho.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.domain.Project;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.service.ProjectService;
import com.mho.portfolio.service.ResponseService;

@RestController
@RequestMapping("projects")
public class ProjectController {

	private final ResponseService responseService;
	private final ProjectService projectService;
	
	public ProjectController(ResponseService responseService, ProjectService projectService) {
		this.responseService = responseService;
		this.projectService = projectService;
	}
	
	@GetMapping("")
	public ListResult<Project> getProjList(){
		return responseService.getListResult(projectService.getProjList());
	}
}
