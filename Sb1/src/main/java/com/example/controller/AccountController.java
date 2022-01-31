package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.AccountModel;
import com.example.model.CorporateModel;
import com.example.model.UserModel;
import com.example.service.AccountService;
import com.example.service.CorporateService;

@Controller
public class AccountController {

	@Autowired
	CorporateService coService;
	
	@Autowired
	AccountService accService;
	
	@RequestMapping("/accountPage")
	public String accountsetupPage(Model m)
	{
		String yes="Yes";
		List<CorporateModel> list =coService.viewAll(yes);
		m.addAttribute("list",list);
		return "accountSetup";
	}
	
	@RequestMapping("/acclist")
	public String accountList(@RequestParam("id") int cid,Model m)
	{
		String yes = "Yes";
		List<AccountModel> list = accService.viewById(yes, cid);
		m.addAttribute("list", list);
		m.addAttribute("cid",cid);
		System.out.println(cid);
		return "accList";
	}
	
	
	//Add Account Button 
	@RequestMapping("/addAccount{cid}")
	public String addaccPage(Model m,@PathVariable("cid") String id)
	{
		String yes="Yes";
		int cid=Integer.valueOf(id);
		AccountModel accModel=new AccountModel();
		accModel.setAccountstatus(yes);
		accModel.setCorporateid(cid);
		m.addAttribute("account",accModel);
		return "addAccount";
	}
	
	@PostMapping("/addAccount")
	public String submitAddAccount(@Valid @ModelAttribute("account") AccountModel acc,BindingResult bid,@RequestParam("corporateid") int id)
	{
		if (bid.hasErrors()) {
			return "addAccount";
		}
		acc.setAccountstatus("Yes");
		accService.addAccount(acc);
		return "redirect:/accList"+id;
	}
	
	//Add Account page : Back button
	@RequestMapping("/accList{id}")
	public String addAccBack(@PathVariable("id") int cid,Model m)
	{
		String yes = "Yes";
		List<AccountModel> list=accService.viewById(yes, cid);  
		m.addAttribute("list",list);
		m.addAttribute("cid",cid);
		return "accList";
	}
	
	@RequestMapping("/accDelete")
	public String delete(@RequestParam("cid") int cid, @RequestParam("accno") int accno) {
		
		accService.softDeleteUser(cid,accno);
		return "redirect:/accList"+cid;
	}

	
	
	
}
