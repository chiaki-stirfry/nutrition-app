package com.nutriapp.site;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
//	@GetMapping("/login")
//	public String viewLoginPage() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//			return "login";
//		}
//		
//		return "redirect:/";
//	}

}
