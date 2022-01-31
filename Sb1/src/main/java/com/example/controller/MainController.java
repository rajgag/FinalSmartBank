package com.example.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.AccountModel;
import com.example.model.CorporateModel;
import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.example.service.AccountService;
import com.example.service.CorporateService;
import com.example.service.UserDetailsImpl;
import com.example.service.UserService;

@Controller
public class MainController {

	@Autowired
	CorporateService coService;

	@Autowired
	AccountService accService;

	@Autowired
	UserService userService;
	
	final static Logger logger = LogManager.getLogger(MainController.class);

	@RequestMapping("/login")
	public String adminlogin(Model m, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
			logger.info("invalid login attempt");
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
			logger.info("Logged out Successfully");
		}
		m.addAttribute("errorMessge", errorMessge);

		m.addAttribute("user", new UserModel());
		return "login";
	}

	

	@GetMapping("/admin")
	public String admin(Model m) {
		String yes = "Yes";
		List<CorporateModel> list = coService.viewAll(yes);
		m.addAttribute("list", list);
		return "admin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}

	@RequestMapping("/addCorporate")
	public String addCorporatePage(Model m) {

		m.addAttribute("corporate", new CorporateModel());
		return "addCorporate";
	}

	@PostMapping("/addCorporate")
	public String addCorporate(@Valid @ModelAttribute("corporate") CorporateModel cm,BindingResult bid) {
		if(bid.hasErrors())
			return "addCorporate";
		coService.addCorporate(cm);
		return "redirect:/admin";
	}

	@RequestMapping("/updateCorporate")
	public String modifyCorpPage(@RequestParam("corporateid") int Cid, Model m) {
		CorporateModel Cmodel = coService.getCorporateById(Cid);
		m.addAttribute("Corpmodify", Cmodel);

		return "Cmodify";
	}

	@RequestMapping("/updateCorporatePage")
	public String modifybtn(@Valid @ModelAttribute("Corpmodify") CorporateModel cmodel,BindingResult bid) {
		if(bid.hasErrors())
			return "Cmodify";
		CorporateModel cm = coService.getCorporateById(cmodel.getCorporateid());
		cmodel.setstatus(cm.getstatus());
		coService.addCorporate(cmodel);
		return "redirect:/admin";

	}

	@RequestMapping("/deleteCorporate")
	public String deletebtn(@RequestParam("corporateid") int Cid, Model m) {
		coService.softDeleteCorporate(Cid);
		return "redirect:/admin";
	}

}
