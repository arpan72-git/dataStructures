package com.training.defecttrack.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.defecttrack.userregistration.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}
