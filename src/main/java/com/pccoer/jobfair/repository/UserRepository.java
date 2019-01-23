package com.pccoer.jobfair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pccoer.jobfair.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String username);

}
