package com.JoshuaFermin.WeatherProject.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by afermin on 2/28/16.
 */
public class APIWeatherService implements WeatherService {

    @Override
    public String getWeatherJson(double lon, double lat) {
        String longLat = lon + "," + lat ;
        String jsonResponse = null;
        URL url;
        HttpURLConnection connection = null;

        try {
            url = new URL(APIConstants.ENDPOINT);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            jsonResponse = response.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            jsonResponse = null;
        } catch (IOException e) {
            e.printStackTrace();
            jsonResponse = null;
        }

        return jsonResponse;
    }
}
