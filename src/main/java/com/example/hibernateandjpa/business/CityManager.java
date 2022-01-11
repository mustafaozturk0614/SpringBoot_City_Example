package com.example.hibernateandjpa.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateandjpa.dao.ICityDao;
import com.example.hibernateandjpa.entities.City;

@Service
public class CityManager implements ICityService {
	private ICityDao citydao;
	
	@Autowired
	public CityManager(ICityDao citydao) {
		
		this.citydao = citydao;
	}
	
	@Override
	@Transactional
	public List<City> getAll() {
		
		return this.citydao.getAll();
	}
	
	@Override
	@Transactional
	public void add(City city) {
		this.citydao.add(city);
		
	}
	
	@Override
	@Transactional
	public void update(City city) {
		this.citydao.update(city);
		
	}
	
	@Override
	@Transactional
	public void delete(City city) {
		this.citydao.delete(city);
	}
	
	@Override
	@Transactional
	public City getById(int id) {
		
		return this.citydao.getById(id);
	}
	
}
