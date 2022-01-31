package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.AccountRepository;
import com.example.model.AccountModel;
import com.example.model.UserModel;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;
	
	public List<AccountModel> viewById(String yes, int cid) {
		
		return accRepo.viewUserById(yes, cid);  
		
	}

	public void addAccount(AccountModel acc) {
		
		 accRepo.save(acc);
		
	}

	public void softDeleteUser(int cid, int accno) {
		
		String no="No";
		accRepo.softDelete(cid,accno,no);
		
	}

	public List<AccountModel> viewAll(int cid) {
		// TODO Auto-generated method stub
		
			String yes="Yes";
			return accRepo.viewUserById(yes, cid);
	}

	public List<AccountModel> viewDetails(int accno) {
		// TODO Auto-generated method stub
		return accRepo.viewByaccNo(accno);
	}

}
