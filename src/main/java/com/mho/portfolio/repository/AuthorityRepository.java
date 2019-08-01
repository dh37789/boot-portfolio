package com.mho.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mho.portfolio.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{}
