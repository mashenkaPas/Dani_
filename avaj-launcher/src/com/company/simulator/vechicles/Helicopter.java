package com.company.simulator.vechicles;

import com.company.simulator.MyPrinter;
import com.company.simulator.WeatherTower;
import com.company.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String call = "Helicopter#" + this.name + "(" + this.id + "): ";

        if (weather.equals("SUN")) {
            if (coordinates.getHeight() + 2 >= 100) {
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight());
                MyPrinter.writetoFile(call + "Summer again");
            } else if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                MyPrinter.writetoFile(call + "Summer again.");
            }
        } else if (weather.equals("RAIN")) {

            if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                MyPrinter.writetoFile(call + "rain");
            }

        } else if (weather.equals("FOG")) {
            if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                MyPrinter.writetoFile(call + "too fogy.");
            }

        } else if (weather.equals("SNOW")) {
            if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            }else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                MyPrinter.writetoFile(call + "it is winter here.");
            }
        } else
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        MyPrinter.writetoFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

}
