package com.company.simulator.vechicles;

import com.company.simulator.MyPrinter;
import com.company.simulator.WeatherTower;
import com.company.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String call = "JetPlane#" + this.name + "(" + this.id + "): ";

        if (weather.equals("SUN")) {
            if (coordinates.getHeight() + 2 >= 100) {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 2, coordinates.getHeight());
                MyPrinter.writetoFile(call + "Summer again");
            } else if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                MyPrinter.writetoFile(call + "Summer again");
            }
        } else if (weather.equals("RAIN")) {

            if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                MyPrinter.writetoFile(call + "rain.");
            }
        } else if (weather.equals("FOG")) {
            if (coordinates.getHeight() - 0 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                MyPrinter.writetoFile(call + "too fogy.");
            }
        } else if (weather.equals("SNOW")) {
            if (coordinates.getHeight() - 7 <= 0) {
                weatherTower.unregister(this);
                MyPrinter.writetoFile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } else {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                MyPrinter.writetoFile(call + "it is winter here.");
            }
        } else
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        MyPrinter.writetoFile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

}
