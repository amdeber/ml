package com.ml.clima.dao.day;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.AbstractDao;
import com.ml.clima.model.DayWeather;

@Service
public class DayWeatherDao extends AbstractDao<DayWeather> {

	@Autowired
	private DayWeatherJpaDao repository;

	@Override
	protected JpaRepository<DayWeather, Long> getRepositorio() {
		return repository;
	}

	public DayWeather getFindByDay(Long day){
		return repository.findByDay(day);
	}
	
	
	public Integer countByDay(Long day){
		return repository.countByDay(day);
	}

	public List<DayWeather> findAll() {
		return repository.findAll();
	}
	
	public Long getMaxDay(){
		return repository.getMaxDay();
	}
	
	
	
}
