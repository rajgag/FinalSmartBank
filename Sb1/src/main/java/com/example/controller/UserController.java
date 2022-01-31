package com.example.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.model.CorporateModel;
import com.example.model.UserModel;
import com.example.service.CorporateService;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	CorporateService coService;

	@RequestMapping("/userPage")
	public String userpage(Model m) {
		String yes = "Yes";
		List<CorporateModel> list = coService.viewAll(yes);
		m.addAttribute("userlist", list);
		return "userSetup";
	}

	@RequestMapping("/addUserPage")
	public String addUser(Model m, @RequestParam("corporateid") int id) {
		UserModel userm = new UserModel();
		userm.setCorporateid(id);
		m.addAttribute("user", userm);

		return "addUser";
	}

	@PostMapping("/addUser")
	public String addingUser(@Valid @ModelAttribute("user") UserModel userm, BindingResult bid) {
		if (bid.hasErrors()) {
			return "addUser";
		}
		userm.setPasschanged("No");
		userm.setRole("ROLE_USER");
		userm.setStatus("Yes");
		userm.setActive(true);
		userService.saveUser(userm);
		return "redirect:/userPage";
	}

	@RequestMapping("/userListPage")
	public String viewUser(Model m, @RequestParam("corporateid") int id) {
		String yes = "Yes";
		List<UserModel> list = userService.viewById(yes, id);
		m.addAttribute("list", list);
		return "userList";
	}

	@RequestMapping("/userModifyPage")
	public String modify(Model m, @RequestParam("uid") String uid, @RequestParam("cid") int id) {
		UserModel model = userService.getUserById(uid);
		m.addAttribute("cid", id);
		m.addAttribute("user", model);
		return "Umodify";

	}

	@RequestMapping("/userModify")
	public String modifyLogic(@Valid @ModelAttribute("user") UserModel usermodel,BindingResult bid, @RequestParam("corporateid") int id,
			Model m) {
		
		if(bid.hasErrors())
			return "Umodify";
		
		userService.saveUser(usermodel);
		return "redirect:/userListPage" + id;

	}

	@RequestMapping("/userListPage{id}")
	public String userlistonSbt(@PathVariable("id") int cid, Model m) {
		String yes = "Yes";
		List<UserModel> userlist = userService.viewById(yes, cid);
		m.addAttribute("list", userlist);
		return "userList";
	}

	@RequestMapping("/userDelete")
	public String delete(@RequestParam("cid") String uid, @RequestParam("cid") String cid) {
		
		userService.softDeleteUser(uid);
		return "redirect:/userListPage"+cid;
	}

}
