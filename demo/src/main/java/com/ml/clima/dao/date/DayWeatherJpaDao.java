package com.ml.clima.dao.date;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ml.clima.model.DayWeather;

public interface DayWeatherJpaDao extends JpaRepository<DayWeather, Long>{
	
	DayWeather findByDay(Long day);
	
	Integer countByDay(Long day);

}
