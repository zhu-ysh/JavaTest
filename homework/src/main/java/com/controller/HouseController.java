package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.House;
import com.service.HouseService;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseServiceImpl;
	
	@RequestMapping("select")
	public @ResponseBody List<House> select(House house) {
		System.out.println(house);
		ArrayList<House> houses = houseServiceImpl.select(house);
		for (House house2 : houses) {
			System.out.println(house2);
		}
		return houses;
	}
}
