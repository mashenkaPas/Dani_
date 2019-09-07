package com.company.simulator.vechicles;

import com.company.simulator.MyPrinter;
import com.company.simulator.WeatherTower;
import com.company.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private MyPrinter myPrinter;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String call = "Baloon#" + this.name + "(" + this.id + "): ";
        if (weather.equals("SUN")) {
            if (coordinates.getHeight() + 4 >= 100) {
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight());
                MyPrinter.writetoFile(call + "Summer again");
            } else if ((coordinates.getHeight() - 0) <= 0) {
                MyPrinter.writetoFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                weatherTower.unregister(this);
            } else {
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                MyPrinter.writetoFile(call + "Summer again");
            }
        } else if (weather.equals("RAIN")) {
            if ((coordinates.getHeight() - 5) <= 0) {
                MyPrinter.writetoFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                weatherTower.unregister(this);
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                MyPrinter.writetoFile(call + "rain");
            }
        } else if (weather.equals("FOG")) {
            if ((coordinates.getHeight() - 3) <= 0) {
                MyPrinter.writetoFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                weatherTower.unregister(this);
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                MyPrinter.writetoFile(call + "too fogy");
            }

        } else if (weather.equals("SNOW")) {
            if ((coordinates.getHeight() - 15) <= 0) {
                MyPrinter.writetoFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                weatherTower.unregister(this);
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                MyPrinter.writetoFile(call + "It's snowing. We're gonna crash.");
            }
        } else
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        MyPrinter.writetoFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

}

