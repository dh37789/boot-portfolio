package com.mho.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.mho.portfolio.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	public Optional<User> findById(String user_mail);
}
