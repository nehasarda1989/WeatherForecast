package com.example.WeatherForcast.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeatherForcast.Service.WeatherService;

@RestController
@RequestMapping("/forecast")
public class WeatherController {
	
	@Autowired
	public WeatherService weatherService;
	
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WeatherController.class);
	
	@GetMapping("/summary/{locationName}")
	@ResponseBody
	public Object getForcastSummary(@PathVariable("locationName") String locationName)
	{ 
		logger.info("Summary controller started");
		return weatherService.getForcastSummary(locationName);
	}
	
	@GetMapping("/hourly/{locationName}")
	@ResponseBody
	//@Autowired(required = true)
	public  ResponseEntity<String> getHourlyWeather(@PathVariable("locationName") String locationName)
	{
		logger.info("Hourly controller started");
		return weatherService.getHourlyWeather(locationName);
	}
}
