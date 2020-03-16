package com.ml.clima.interceptors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ml.clima.utils.UrlUtils;


@Service
public class RequestURLValidationInterceptor implements HandlerInterceptor {

	
	private static final String URL_NULL = "The url cannot be null!";
	
	private static final String URL_NOT_VALID = "The url is not valid!";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (CorsUtils.isPreFlightRequest(request)) {
			return true;
		}
		HttpServletResponse httpResponse = response;
		
		//String body = getRequestBody(request);
		//urlParamsIsNullAndValid(body.toString());
		
		// ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
		String body = getUrlFromInputStream(request);

		
		boolean isValid = true;
		if (body == null || body.toString().isEmpty()) {
			httpResponse.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, URL_NULL);
			isValid = false;
		}
			

		if (UrlUtils.getInstance().isUrlValid(body.toString())) {
			httpResponse.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, URL_NOT_VALID);
			isValid = false;
		}
		
		return isValid;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	private String getUrlFromInputStream(HttpServletRequest request) {
		StringBuilder stringBuilder = new StringBuilder();
	     BufferedReader bufferedReader = null;
	     try {
	         InputStream inputStream = request.getInputStream();
	         if (inputStream != null) {
	             bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	             char[] charBuffer = new char[128];
	             int bytesRead = -1;
	             while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                 stringBuilder.append(charBuffer, 0, bytesRead);
	             }
	         } else {
	             stringBuilder.append("");
	         }
	     } catch (IOException ex) {
	         return null;
	     } finally {
	         if (bufferedReader != null) {
	             try {
	                 bufferedReader.close();
	             } catch (IOException ex) {
	                return null;
	             }
	         }
	     }
	     //Store request pody content in 'body' variable 
	    return stringBuilder.toString();
		
	}
	 
}
