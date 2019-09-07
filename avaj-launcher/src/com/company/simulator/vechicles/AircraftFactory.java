package com.company.simulator.vechicles;

import com.company.simulator.vechicles.Baloon;
import com.company.simulator.vechicles.Flyable;
import com.company.simulator.vechicles.Helicopter;
import com.company.simulator.vechicles.JetPlane;
import com.company.weather.Coordinates;

import java.awt.geom.FlatteningPathIterator;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int latitude, int longitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Baloon"))
            return new Baloon(name, coordinates);
        else if (type.equals("JetPlane") ) {
            return new JetPlane(name, coordinates);
        } else if (type.equals("Helicopter") ) {
            return new Helicopter(name, coordinates);
        } else
            {
                System.out.println("Unknow type, please fix me ");
            }
        return  null;
    }


}
