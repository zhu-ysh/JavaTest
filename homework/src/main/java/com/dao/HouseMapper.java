package com.dao;

import java.util.ArrayList;

import com.entity.House;

public interface HouseMapper {
	ArrayList<House> select(House house);
}
