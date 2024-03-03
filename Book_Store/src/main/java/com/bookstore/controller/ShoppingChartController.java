package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.ShoppingChartService;

@Controller
public class ShoppingChartController {
	
	@Autowired
	private ShoppingChartService sChartService;

	@RequestMapping("/deleteMyShoppingChart/{ID}")
	public String deleteMyShoppingChart(@PathVariable("ID") int id) {
		
		sChartService.deleteById(id);
		
		return "redirect:/shopping_chart";
		
	}
	
}
