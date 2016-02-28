package com.JoshuaFermin.WeatherProject.network;

/**
 * Created by afermin on 2/28/16.
 */
public interface WeatherService {

    String getWeatherJson(double lon, double lat);

}
