package com.example.WeatherForcast.exception;


public class WeatherAPIException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public WeatherAPIException(Exception e)
	{
		super(e);
	}
	
	public WeatherAPIException(Exception e, String message)
	{
		super(message,e);
	}
	
	
}
