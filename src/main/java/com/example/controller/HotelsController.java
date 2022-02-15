package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HotelsService;

@Controller
@RequestMapping("/Ex02")
public class HotelsController {
	
	@Autowired
	private HotelsService hotelsService;
	
	
	@RequestMapping("")
	public String search() {
		return "/hotels/search";
	}
	
	@RequestMapping("/searchByLessThanPrice")
	public String searchByLessThanPrice(Integer price,Model model) {
		
		model.addAttribute("hotelList",hotelsService.searchByLessThanPrice(price));
		model.addAttribute("searchprice",price);
		return "/hotels/search";
	}
	
	

}
