package com.ml.clima.dao.planet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.day.AbstractDao;
import com.ml.clima.model.Planet;

@Service
public class PlanetDao extends AbstractDao<Planet> {

	@Autowired
	private PlanetJpaDao repositorio;

	@Override
	protected JpaRepository<Planet, Long> getRepositorio() {
		return repositorio;
	}

	public Planet getFindByName(String name){
		return repositorio.findByName(name);
	}
	
}
