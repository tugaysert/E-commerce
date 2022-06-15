package com.menorise.secondhand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menorise.secondhand.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
