package com.ml.clima.dao.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.AbstractDao;
import com.ml.clima.model.Url;

@Service
public class UrlDao extends AbstractDao<Url> {

	@Autowired
	private UrlJpaDao repository;

	@Override
	protected JpaRepository<Url, Long> getRepositorio() {
		return repository;
	}

	public Url getFindByLongUrl(String longUrl){
		return repository.findByLongUrl(longUrl);
	}
	
	
	public Url getFindByShortUrl(String shortUrl){
		return repository.findByShortUrl(shortUrl);
	}
	
	public Long deleteByShortUrl(String shortUrl) {
		return repository.deleteByShortUrl(shortUrl);
	}
	
}
