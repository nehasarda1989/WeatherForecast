package com.example.WeatherForcast.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	private RestTemplate restTemplate;

	@Value("${baseUri}")
	private String baseUri;

	@Value("${X-RapidAPI-Key}")
	private String X_RapidAPI_Key;

	@Value("${X-RapidAPI-Host}")
	private String X_RapidAPI_Host;

	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WeatherService.class);

	public ResponseEntity<String> getForcastSummary(String locationName) {

		String apiUrl = baseUri + locationName + "/summary/";

		return getAPIReponse(locationName, apiUrl);
	}

	public ResponseEntity<String> getHourlyWeather(String locationName) {

		String apiUrl = baseUri + locationName + "/hourly/";

		return getAPIReponse(locationName, apiUrl);

	}

	private ResponseEntity<String> getAPIReponse(String locationName, String apiUrl) {
		logger.info("URL - {}", apiUrl);
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set("X-RapidAPI-Key", X_RapidAPI_Key);
		headers.set("X-RapidAPI-Host", X_RapidAPI_Host);
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		logger.info("locationName provided" + locationName);
		
		try {
			return restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity,String.class);
		} catch (Exception e) {
			logger.error("Exception while calling Weather API ", e.getMessage());
			throw new WeatherAPIException(e, "Exception while calling Weather API");
		}
	}

}
