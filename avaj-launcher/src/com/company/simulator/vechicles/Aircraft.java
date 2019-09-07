
package com.company.simulator.vechicles;

import com.company.weather.Coordinates;

import java.util.UUID;

public class Aircraft {
    protected  long id = 1;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = name;
        this.coordinates = coordinates;
    }
}
