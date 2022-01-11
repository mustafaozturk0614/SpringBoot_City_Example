package com.example.hibernateandjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernateandjpa.entities.City;

@Repository
public class HibernateCityDao implements ICityDao {
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional // otamatik transaction işlemi
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}
	
	@Override
	@Transactional
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}
	
	@Override
	@Transactional
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(city);
		
	}
	
	@Override
	@Transactional
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDeleteCity = session.get(City.class, city.getId());
		session.delete(cityToDeleteCity);
	}
	
	@Override
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		
		return city;
	}
	
}
