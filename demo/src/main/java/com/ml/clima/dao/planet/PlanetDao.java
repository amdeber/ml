package com.ml.clima.dao.planet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.day.AbstractDao;
import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Planet;

@Service
public class PlanetDao extends AbstractDao<Planet> {

	@Autowired
	private PlanetJpaDao repository;

	@Override
	protected JpaRepository<Planet, Long> getRepositorio() {
		return repository;
	}

	public Planet getFindByName(String name){
		return repository.findByName(name);
	}
	
	public List<Planet> findAll() {
		return repository.findAll();
	}
	
}
