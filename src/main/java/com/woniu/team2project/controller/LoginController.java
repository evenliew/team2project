package com.woniu.team2project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/toindex")
	public String toIndex() {
		return "system/index/index.html";
	}
}
