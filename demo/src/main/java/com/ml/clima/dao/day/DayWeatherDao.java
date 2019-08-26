package com.ml.clima.dao.day;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.model.DayWeather;

@Service
public class DayWeatherDao extends AbstractDao<DayWeather> {

	@Autowired
	private DayWeatherJpaDao repositorio;

	@Override
	protected JpaRepository<DayWeather, Long> getRepositorio() {
		return repositorio;
	}

	public DayWeather getFindByDay(Long day){
		return repositorio.findByDay(day);
	}
	
	
	public Integer countByDay(Long day){
		return repositorio.countByDay(day);
	}

	public List<DayWeather> findAll() {
		return repositorio.findAll();
	}
	
}
