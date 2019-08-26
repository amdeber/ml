package com.ml.clima.dao.day;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ml.clima.model.DayWeather;

public interface DayWeatherJpaDao extends JpaRepository<DayWeather, Long>{
	
	DayWeather findByDay(Long day);
	
	Integer countByDay(Long day);
	
	@Query("SELECT coalesce(max(dw.day), 0) FROM DayWeather dw")
	Long getMaxDay();

}
