package com.haseebazeem.climapm;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here

    public String mTemperature;
    public String mCity;
    public int mCondition;
    public String mIconName;
    public String condition;

    // TODO: Create a WeatherDataModel from a JSON:
    public static WeatherDataModel fromJson(JSONObject object) {
        try {
            WeatherDataModel weatherDataModel = new WeatherDataModel();

            weatherDataModel.mCity = object.getString("name");
            weatherDataModel.mCondition = object.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherDataModel.condition = object.getJSONArray("weather").getJSONObject(0).getString("description");
            weatherDataModel.mIconName = updateWeatherIcon(weatherDataModel.mCondition);

            Double temp = object.getJSONObject("main").getDouble("temp") - 273.15;
            int rounedValue = (int) Math.round(temp);

            weatherDataModel.mTemperature = Integer.toString(rounedValue);

            return weatherDataModel;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("clima", "fromJson: error catch");
            return null;
        }

    }

    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getmTemperature() {
        return mTemperature + "°";
    }

    public String getmCity() {
        return mCity;
    }

    public String getmIconName() {
        return mIconName;
    }
}
