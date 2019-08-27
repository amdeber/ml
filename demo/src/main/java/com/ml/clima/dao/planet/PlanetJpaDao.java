package com.ml.clima.dao.planet;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ml.clima.model.Planet;

public interface PlanetJpaDao extends JpaRepository<Planet, Long>{
	
	Planet findByName(String name);

}
