package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, String> {

	@Query("from LoginModel l where l.username=?1")
	Optional<LoginModel> findByUsername(String username);
}
