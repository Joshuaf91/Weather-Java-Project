package com.JoshuaFermin.WeatherProject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Joshua on 2/28/2016.
 */

public class WeatherParser {
    public Weather parseWeather(String json){
        JSONParser jsonParser = new JSONParser();
        Weather weather = new Weather();
        Currently currently = new Currently();
        try {
            JSONObject weatherJson = (JSONObject) jsonParser.parse(json);
            JSONObject currentlyJson = (JSONObject) weatherJson.get("currently");
            currently.setTime((long) currentlyJson.get("time"));
            currently.setSummary((String) currentlyJson.get("summary"));
            currently.setNearestStormDistance((long) currentlyJson.get("nearestStormDistance"));
            currently.setNearestStormBearing ((long) currentlyJson.get("nearestStormBearing"));
            currently.setPrecipIntensity ((long) currentlyJson.get("precipIntensity"));
            currently.setPrecipProbability ((long) currentlyJson.get("precipProbability"));
            currently.setTemperature((Double) currentlyJson.get("temperature"));
            currently.setApparentTemperature((Double) currentlyJson.get("apparentTemperature"));
            currently.setDewPoint((Double) currentlyJson.get("dewPoint"));
            currently.setHumidity((Double) currentlyJson.get("humidity"));
            currently.setWindSpeed((Double) currentlyJson.get("windSpeed"));
            currently.setWindBearing((long) currentlyJson.get("windBearing"));
            currently.setVisibility((double) currentlyJson.get("visibility"));
            weather.setCurrently(currently);
        } catch (ParseException e) {
            e.printStackTrace();
            weather = null;
        }
        return weather;
    }
}
