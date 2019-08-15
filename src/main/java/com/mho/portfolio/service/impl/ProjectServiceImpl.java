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
  public List<Project> getProjList() {
    return projectRepository.findAll();
  }
}
