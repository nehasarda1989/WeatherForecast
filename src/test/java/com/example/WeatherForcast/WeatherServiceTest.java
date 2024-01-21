package com.example.WeatherForcast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.WeatherForcast.Service.WeatherService;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

	@Mock
	public WeatherService weatherService;
	
	@Test
    void testHourlylyWeather1() {
		
		ResponseEntity<String> response = new ResponseEntity<>("Summary", HttpStatus.OK);
		
        String locationName = "Delhi";
        Mockito.when(weatherService.getHourlyWeather(locationName)).thenReturn(response);
        
        ResponseEntity<String> actualResponse = weatherService.getHourlyWeather(locationName);
        
        assertEquals(response.getBody(), actualResponse.getBody());
        
}
	@Test
    void  testForcastSummary() {
		
		ResponseEntity<String> response = new ResponseEntity<>("Hourly summary", HttpStatus.OK);
		
        String locationName = "Delhi";
        Mockito.when(weatherService.getForcastSummary(locationName)).thenReturn(response);
        
        ResponseEntity<String> actualResponse = weatherService.getForcastSummary(locationName);
        
        assertEquals(response.getBody(), actualResponse.getBody());
        
}
}
