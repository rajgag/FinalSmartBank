package com.example.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.CorporateModel;

public interface CorporateRepository extends JpaRepository<CorporateModel, Integer>{

	
	@Transactional
	@Modifying
	@Query("update CorporateModel c set c.status=?1 where c.corporateid=?2")
	void softdelete(String no,int cid);

	
	@Transactional
	@Modifying
	@Query("from CorporateModel c where c.status=?1")
	List<CorporateModel> findAllById(String yes);

	
	
	

	
}

