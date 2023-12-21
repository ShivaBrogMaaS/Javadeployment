package com.test.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.time.model.ForgotPassword;
import com.test.time.model.RandomKey;
import com.test.time.model.User;
import com.test.time.service.EmailService;
import com.test.time.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService service;

	@Autowired
	private EmailService dhinesh;

	String subject = "Password Reset";

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@ModelAttribute("currentUser")
	public UserDetails getCurrentUser(Authentication authentication) {
		return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
	}

	@RequestMapping("/newhome")
	public String root() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/registration")
	public String showForm(Model mv) {
		User us = new User();
		mv.addAttribute("user", us);
		return "registration";
	}

	@PostMapping("/addnewUser")
	public String addNewUser(@ModelAttribute("user") User user, Errors errors, RedirectAttributes redirectAttributes) {
		User us = new User(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getConfirmemail(),
				user.getConfirmpass());
		List<User> rajan = service.getEmail(user.getEmail());
		List<User> pramo = service.getName(user.getName());
		if (rajan.isEmpty() == true || pramo.isEmpty() == true) {
			service.addNewMem(us);
			redirectAttributes.addFlashAttribute("errorMessage", "New Member Added Sucessfully");

		}

		else {
			errors.rejectValue("email", "Email Already Exist");
			redirectAttributes.addFlashAttribute("errorMessage", "This User Exist Already");
		}
		return "redirect:/registration";
	}

	@RequestMapping("/newPass")
	public String forgotpassword(Model mv) {
		User fp = new User();
		mv.addAttribute("fp", fp);
		return "forgotpassword";
	}

	@PostMapping("/uppass")
	public String updatePassword(@ModelAttribute("fp") User u, Errors errors, RedirectAttributes redirectAttributes) {
		List<User> rs = service.getEmail(u.getEmail());
		try {
			if (rs.size() > 0) {
				RandomKey k = new RandomKey();
				String s = k.getPassword();
				String message = " Hello " + rs.get(0).getName() + " ;" + "\n"
						+ "As per your request your password has been reseted.Your New Password is" + s
						+ " please Change password after login!!!.This Password has No expiry";
				dhinesh.sendMail("shivaraman.s@tvslsl.com", u.getEmail(), subject, message);
				service.addByPassword(s, u.getEmail());
				redirectAttributes.addFlashAttribute("errorMessage", "Password Has been sent to your Email");

			} else {
				errors.rejectValue("email", "Email Could Not Be Found in Our Records");
				redirectAttributes.addFlashAttribute("errorMessage", "Email Could Not BeFound in Our Records");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Something went Wrong due to security issue ");
		}
		return "redirect:/login";
	}

	@RequestMapping("/changepass")
	public String changepassword(Model mv) {
		ForgotPassword np = new ForgotPassword();
		mv.addAttribute("np", np);
		return "changepassword";
	}

	@PostMapping("/donepass")
	public String changeValuePassword(@ModelAttribute("np") ForgotPassword np) {
		service.addNewPassword(np.getNewpassword(), np.getOldpassword());
		System.out.println(np.getOldpassword() + "" + np.getNewpassword());
		return "redirect:/login";
	}

}
