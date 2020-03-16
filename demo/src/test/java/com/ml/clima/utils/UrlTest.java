package com.ml.clima.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

public class UrlTest {
	
	
	@Test
	public void wihtout_domain() {
		String url = "https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		String result = UrlUtils.getInstance().urlWithoutDomain(url);
		assertEquals("/seguranca-casa/#menu=categories", result);
	}
	
	@Test
	@Ignore
	public void get_url_short() {
		String url = "https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		String result = UrlUtils.getInstance().transformLongToShorUrl(url);
		assertEquals("https://me.li/363a6462", result);
	}
	
	@Test
	public void url_valid() {
		String url = "https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		assertTrue(UrlUtils.getInstance().isUrlValid(url));
	}
	
	@Test
	public void url_valid_2() {
		String url = "https://eletronicos.mercadolivre.com.br";
		assertTrue(UrlUtils.getInstance().isUrlValid(url));
	}
	
	@Test
	public void url_no_valid() {
		String url = "/eletronicos.mercadolivre.com.br//https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		assertFalse(UrlUtils.getInstance().isUrlValid(url));
	}
	
	@Test
	public void url_no_valid_2() {
		String url = "https:////";
		assertFalse(UrlUtils.getInstance().isUrlValid(url));
	}
	
	@Test
	public void url_no_valid_3() {
		String url = "";
		assertFalse(UrlUtils.getInstance().isUrlValid(url));
	}
	
	@Test
	public void url_no_valid_4() {
		String url = null;
		assertFalse(UrlUtils.getInstance().isUrlValid(url));
	}

	
	
	
}
