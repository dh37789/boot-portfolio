package com.mho.portfolio.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String>{}
