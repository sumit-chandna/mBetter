package com.mbetter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController extends BaseController {
	@RequestMapping(method = { RequestMethod.GET })
	public String homePage(HttpServletRequest request, ModelMap model) {
		return "index";
	}

	@RequestMapping("default")
	public String defaultAfterLogin(HttpServletRequest request) {
		return "redirect:/";
	}

	@RequestMapping("login/form")
	public String login() {
		return "login";
	}

	@RequestMapping("/errors/403")
	public String error403() {
		return "/errors/403";
	}
}
