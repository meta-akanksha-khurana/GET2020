package com.metacube.metaparkingsystemv2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.metaparkingsystemv2.models.User;

/**
 * This interface is used to find users from database
 * @author Akanksha
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String userName);
}
