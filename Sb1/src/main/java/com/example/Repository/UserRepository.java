package com.example.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.LoginModel;
import com.example.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String>{

	Optional<UserModel> findByUsername(String username);

	
	
	@Transactional
	@Modifying
	@Query("from UserModel u where u.status=?1")
	List<UserModel> findAllById(String yes);
	
	
	@Transactional
	@Modifying
	@Query("from UserModel u where u.status=?1 and u.corporateid=?2")
	List<UserModel> viewUserById(String yes, int id);

	@Transactional
	@Modifying
	@Query("update UserModel u set u.status=?1 where u.username=?2")
	void softdelete(String no, String cid);



	Optional<UserModel> findByUsername(int id);


	@Transactional
	@Modifying
	@Query("update UserModel u set u.passchanged=?3,u.password=?2 where u.username=?1")
	void changepassword(String username, String password, String yes);

	
	
	
}
