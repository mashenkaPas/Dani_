package com.company.simulator;

import com.company.simulator.Tower;
import com.company.weather.Coordinates;
import com.company.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }

    private void changeWeather() {
        super.conditionChanged();
    }
}
