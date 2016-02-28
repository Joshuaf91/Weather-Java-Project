package com.JoshuaFermin.WeatherProject;

import com.JoshuaFermin.WeatherProject.network.APIWeatherService;
import com.JoshuaFermin.WeatherProject.network.WeatherService;

public class Main {

    public static void main(String[] args) {
        WeatherService weatherService = new APIWeatherService();
        String json = weatherService.getWeatherJson(40.742054,-73.769417);
        WeatherParser weatherParser = new WeatherParser();
        Weather weather = weatherParser.parseWeather(json);
        System.out.println(weather.getCurrently().getTemperature() + " degrees Fahrenheit");
    }
}
