package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Repository.CorporateRepository;
import com.example.model.CorporateModel;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CorporateTesting {
	
	@Autowired 
	CorporateRepository coRepo;
	
	@Test
	public void saveCoporate()
	{
		CorporateModel cmodel=new CorporateModel(67,"Maharajan","Tamil Nadu","7788778877");
		coRepo.save(cmodel);
		System.out.println("Done Succesfully");
	}
	
	@Test
	public void softdeleteCorporate()
	{
		CorporateModel cmodel=coRepo.getById(67);
		coRepo.delete(cmodel);
	}
	
	
}
