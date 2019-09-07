package com.company.simulator;

import com.company.simulator.vechicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
  private List<Flyable> flyable;

public  Tower(){
    this.flyable = new ArrayList<>();
}
    public void register(Flyable flyable_air) {
        flyable.add(flyable_air);
    }

    public void unregister(Flyable flyable_air) {
        flyable.remove(flyable_air);
    }

    protected void conditionChanged() {
        for (int i = 0; i < flyable.size(); i++)
            flyable.get(i).updateConditions();
          }
}