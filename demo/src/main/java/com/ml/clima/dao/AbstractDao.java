package com.ml.clima.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractDao<T> {

	protected abstract JpaRepository<T, Long> getRepositorio();

	public T create(T entity) {
		this.beforeSave(entity);
		entity = getRepositorio().save(entity);
		this.afterSave(entity);
		return entity;
	}

	public T update(T entity) {
		this.beforeUpdate(entity);
		entity = getRepositorio().save(entity);
		this.afterUpdate(entity);
		return entity;
	}
	
	
	public T createFlush(T entity) {
		this.beforeSave(entity);
		entity = getRepositorio().save(entity);
		getRepositorio().flush();
		this.afterSave(entity);
		return entity;
	}
	
	public T updateFlush(T entity) {
		this.beforeUpdate(entity);
		entity = getRepositorio().save(entity);
		getRepositorio().flush();
		this.afterUpdate(entity);
		return entity;
	}


	protected void beforeSave(T entity) {

	}

	protected void afterSave(T entity) {

	}

	protected void beforeUpdate(T entity) {

	}

	protected void afterUpdate(T entity) {

	}

	protected void beforeDelete(T entity) {

	}

	protected void afterDelete(T entity) {

	}
}
