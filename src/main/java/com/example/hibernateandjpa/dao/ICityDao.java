package com.example.hibernateandjpa.dao;

import java.util.List;

import com.example.hibernateandjpa.entities.City;

public interface ICityDao {
	List<City> getAll();
	
	void add(City city);
	
	void update(City city);
	
	void delete(City city);
	
	City getById(int id);
	
}
