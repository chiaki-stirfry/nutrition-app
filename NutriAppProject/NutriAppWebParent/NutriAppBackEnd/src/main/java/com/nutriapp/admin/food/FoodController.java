package com.nutriapp.admin.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

	
	@GetMapping("/food")
	public String listFood() {

	 return "food/food";
	}

	
	
	

}
