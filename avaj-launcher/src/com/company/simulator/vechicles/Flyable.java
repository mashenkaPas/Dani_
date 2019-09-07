package com.company.simulator.vechicles;

import com.company.simulator.WeatherTower;

public interface Flyable {
public void updateConditions();

public void registerTower( WeatherTower weatherTower);

}
