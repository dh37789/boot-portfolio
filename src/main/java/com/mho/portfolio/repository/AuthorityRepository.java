package com.mho.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mho.portfolio.domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String>{}
