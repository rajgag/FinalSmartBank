package com.example.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("from AccountModel a where a.accountstatus=?1 and a.corporateid=?2")
	List<AccountModel> viewUserById(String yes, int cid);

	
	
	@Transactional
	@Modifying
	@Query("update AccountModel a set a.accountstatus=?3 where a.corporateid=?1 and a.accountno=?2")
	void softDelete(int cid, int accno, String no);



	@Transactional
	@Modifying
	@Query("from AccountModel a where a.accountno=?1")
	List<AccountModel> viewByaccNo(int accno);


	
	
	

}
