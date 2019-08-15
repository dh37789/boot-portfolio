package com.mho.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mho.portfolio.domain.Project;
import com.mho.portfolio.repository.ProjectRepository;
import com.mho.portfolio.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;

  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public List<List<Project>> getProjList() {
  	List tmp = projectRepository.findAll();
		List project = new ArrayList<List<Project>>();
		for (int i = 0; i < tmp.size(); i+=2){
			List card = new ArrayList<Project>();
			card.add(tmp.get(i));
			if (tmp.size()-1 >= i+1) {
				card.add(tmp.get(i+1));
			}
			project.add(card);
		}
    return project;
  }

}
