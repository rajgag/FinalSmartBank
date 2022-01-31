package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;
import com.example.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public void saveUser(UserModel employee) {

		userRepo.save(employee);

	}

	public Optional<UserModel> getById(int id) {

		System.out.println("into");
		return userRepo.findByUsername(id);

	}

	public void softDeleteUser(String uid)
	{
			String no="No";
			userRepo.softdelete(no,uid);
	}

	public void updateEmployee(UserModel employee)

	{
		userRepo.save(employee);

	}

	public List<UserModel> viewAll(String yes) {

		return userRepo.findAllById(yes);
	}

	public List<UserModel> viewById(String yes, int id) {

		return userRepo.viewUserById(yes, id);

	}
	
	public UserModel getUserById(String id) {

		return userRepo.getById(id);

	}

	//this is for userhome page 
	public UserModel getbyId(String username) {
		// TODO Auto-generated method stub
		return userRepo.getById(username);
	}

	public void changePassword(UserModel userm) {
		
		String yes="Yes";
		userRepo.changepassword(userm.getUsername(),userm.getPassword(),yes); 
	}
}
