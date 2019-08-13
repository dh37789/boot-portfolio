package com.mho.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mho.portfolio.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, String>{

}
