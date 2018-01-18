package com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HouseMapper;
import com.entity.House;
import com.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;
	
	@Override
	public ArrayList<House> select(House house) {
		return houseMapper.select(house);
	}

}
