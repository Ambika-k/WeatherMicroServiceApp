package com.spring.restapi.models;

public class Weather {
	private String weatherDescription;
	private double lon;
	private String name;
	private double lat;
	private double temp;
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(String weatherDescription, double lon, String name, double lat, double temp) {
		super();
		this.weatherDescription = weatherDescription;
		this.lon = lon;
		this.name = name;
		this.lat = lat;
		this.temp = temp;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "\nCity=" + name + "\nweatherDescription=" + weatherDescription + "\nLongitude=" + lon  + "\nLatitue=" + lat
				+ "\nTemperature=" + temp + " Celsius";
	}
	

}
