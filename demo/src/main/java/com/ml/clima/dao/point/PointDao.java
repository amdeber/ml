package com.ml.clima.dao.point;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.date.AbstractDao;
import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Point;

@Service
public class PointDao extends AbstractDao<Point> {

	@Autowired
	private PointJpaDao repositorio;

	@Override
	protected JpaRepository<Point, Long> getRepositorio() {
		return repositorio;
	}

	public Integer countFindAll() {
		return repositorio.findAll().size();
	}
	
}
