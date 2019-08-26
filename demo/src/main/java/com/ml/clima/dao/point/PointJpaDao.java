package com.ml.clima.dao.point;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Planet;
import com.ml.clima.model.Point;

public interface PointJpaDao extends JpaRepository<Point, Long>{
	
	//Planet findByName(String name);

}
