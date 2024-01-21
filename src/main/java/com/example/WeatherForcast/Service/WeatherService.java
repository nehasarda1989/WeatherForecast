package com.example.WeatherForcast.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.WeatherForcast.exception.WeatherAPIException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {

	@Autowired
	public RestTemplate restTemplate;

	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WeatherService.class);

	public ResponseEntity<String> getForcastSummary(String locationName) {

		String apiUrl = "${baseUri}" + locationName + "/summary/";

		org.springframework.http.HttpHeaders headers1 = new org.springframework.http.HttpHeaders();

		headers1.set("X-RapidAPI-Key", "${X-RapidAPI-Key}");
		headers1.set("X-RapidAPI-Host", "${X-RapidAPI-Host}");

		HttpEntity<String> requestEntity = new HttpEntity<>(headers1);
		logger.info("locationName provided" +locationName);

		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity,
					String.class);
			
			return responseEntity;
		} catch (Exception e) {
			logger.error("Exception while calling Weather API ", e.getMessage());
			throw new WeatherAPIException(e, "Exception while calling Weather API");
		}


	}

	public ResponseEntity<String> getHourlyWeather(String locationName) {

		String apiUrl = "${baseUri}" + locationName + "/hourly/";

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();

		headers.set("X-RapidAPI-Key", "${X-RapidAPI-Key}");
		headers.set("X-RapidAPI-Host", "${X-RapidAPI-Host}");

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		
		logger.info("locationName provided" +locationName);

		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity,
					String.class);
			
			return responseEntity;
		} catch (Exception e) {
			logger.error("Exception while calling Weather API ", e.getMessage());
			throw new WeatherAPIException(e, "Exception while calling Weather API");
		}

	}

}
