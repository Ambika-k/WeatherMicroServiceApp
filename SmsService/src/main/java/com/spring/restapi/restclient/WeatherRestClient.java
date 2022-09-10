package com.spring.restapi.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.restapi.models.Weather;

@FeignClient("WEATHERSERVICE")
public interface WeatherRestClient {
	@GetMapping("/getweather")
	public Weather getWeatherMessage();

}
