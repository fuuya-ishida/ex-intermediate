package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ClothesService;

@Controller
@RequestMapping("/Ex03")
public class ClothesController {
	
	@RequestMapping("")
	public String clothesSearch() {
		return "/clothes/search";
	}
	
	
	@Autowired
	private ClothesService clothesService;
	
	@RequestMapping("/searchClothes")
	public String searchByColorAndGender(Integer gender,String color,Model model){
		
		System.out.println();
		
		model.addAttribute("clotheList",clothesService.searchByColorAndGender(gender, color));
		
		System.out.println(clothesService.searchByColorAndGender(gender, color).size());
		return "clothes/search";

	}
	
}
