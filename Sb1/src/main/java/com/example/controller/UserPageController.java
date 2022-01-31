package com.example.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.AccountModel;
import com.example.model.UserModel;
import com.example.service.AccountService;
import com.example.service.UserService;

@Controller
public class UserPageController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accService;

	
	
	@GetMapping("/user")
	public String userlogin(HttpServletRequest req) {

		Principal principal = req.getUserPrincipal();
		String username = principal.getName();
		UserModel userm = userService.getbyId(username);
		String condition = userm.getPasschanged();
		System.out.println(condition);
		int corpid = userm.getCorporateid();

		if (condition.equals("Yes"))
			return "redirect:/userHomePage/" + corpid + "/" + username;
		else
			return "redirect:/changePassword/" + corpid + "/" + username;
	}

	@RequestMapping("/changePassword/{id}/{userid}")
	public String chngePassword(@PathVariable("id") int cid, @PathVariable("userid") String uid, Model m) {
		m.addAttribute("cid", cid);
		m.addAttribute("uid", uid);
		m.addAttribute("user", new UserModel());
		return "changePassword";

	}

	@RequestMapping("/userHomePage/{id}/{userid}")
	public String userPage(Model m, @PathVariable("id") int cid, @PathVariable("userid") String uid) {
		List<AccountModel> list = accService.viewAll(cid);
		m.addAttribute("list", list);
		m.addAttribute("cid", cid);
		m.addAttribute("uid", uid);
		return "userPage";
	}
	
	@RequestMapping(value = "/userLogin1/{cid}", method = RequestMethod.POST)
	public String userLogin1(@ModelAttribute("user") UserModel userm,@RequestParam("username") String uid,@PathVariable("cid") int corpId) {
		 userService.changePassword(userm);
		 
			return "redirect:/userHomePage/"+corpId+"/"+uid;

	}
	
	@RequestMapping("/accDetails")
	public String viewAccDetails(@RequestParam("accno") int accno,@RequestParam("uid") String id,@RequestParam("cid") int cid,Model m)
	{
		List<AccountModel> list=accService.viewDetails(accno);
		m.addAttribute("list",list);
		m.addAttribute("acno",accno);
		m.addAttribute("cid",cid);
		m.addAttribute("uid",id);
		return "accDetailPage";
		
	}
	
	
	
	
}
