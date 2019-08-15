package com.mho.portfolio.controller;

import com.mho.portfolio.model.response.ListInListResult;
import java.util.List;
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
	public ListInListResult<List<Project>> getProjList(){
		List<List<Project>> a = projectService.getProjList();
		for (List<Project> b : a){
			for (int i = 0; i < b.size(); i++){
				System.out.println(b.get(i).getProj_title());
			}
		}
		return responseService.getListInListResult(projectService.getProjList());
	}
}
