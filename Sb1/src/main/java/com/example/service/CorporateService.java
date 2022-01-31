package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.CorporateRepository;
import com.example.model.CorporateModel;

@Service
public class CorporateService {
	
	@Autowired
	CorporateRepository coRepo;
	
	 public List<CorporateModel> viewAll(String yes)
	  {
		  
		  return coRepo.findAllById(yes);
	  }

	public void addCorporate(CorporateModel cm) {

		 	coRepo.save(cm);
	}
	public void softDeleteCorporate(int cid)
	{
			String no="No";
			coRepo.softdelete(no,cid);
	}

	public CorporateModel getCorporateById(int cid) {
		
		 return coRepo.getById(cid);
	}

	

}
