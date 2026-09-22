package com.tyss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findByUsernameAndPassword(String username,String password);

}
