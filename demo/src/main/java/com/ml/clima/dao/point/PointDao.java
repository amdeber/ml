package com.ml.clima.dao.point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.AbstractDao;
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
