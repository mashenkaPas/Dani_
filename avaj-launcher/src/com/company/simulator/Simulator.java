package com.company.simulator;

import com.company.simulator.vechicles.AircraftFactory;
import com.company.simulator.vechicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

//avaj-launcher/src/com/company/simulator
public class Simulator {
    private static WeatherTower weatherTower;

    public static void main(String[] args) throws InterruptedException {
        try {
            weatherTower = new WeatherTower();
            String fileName = args[0];
            List<String> list = new ArrayList<>();
            List<Flyable> fly = new ArrayList<>();

            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
                list = br.lines().collect(Collectors.toList());
                if (list.size() <= 1) {
                    System.out.println("Something wrong, please fix it!");
                    System.exit(1);
                }
            } catch (FileNotFoundException f) {
                System.out.println("Something wrong, please fix the file!! " + args[0]);
            } catch (IOException e) {
                System.out.println("Problem to read a file");
                e.printStackTrace();
            }
            try {

                int a = Integer.parseInt(list.get(0));
                if (a <= 0)
                    System.out.println("Something wrong, please fix it!! ");
                for (int i = 1; i < list.size(); i++) {
                    String line = list.get(i);
                    String type = line.split(" ")[0];
                    String name = line.split(" ")[1];
                    int log = Integer.parseInt(line.split(" ")[2]);
                    int lat = Integer.parseInt(line.split(" ")[3]);
                    int h = Integer.parseInt(line.split(" ")[4]);

                    AircraftFactory air = new AircraftFactory();
                    Flyable first = air.newAircraft(type, name, log, lat, h);
                    if (first == null) {
                        System.out.println("Something wrong, please fix it!!");
                        System.exit(1);
                    }
                    first.registerTower(weatherTower);
                }
                for (int i = 0; i <= a; i++) {
                    weatherTower.conditionChanged();
                }
            } catch (ArrayIndexOutOfBoundsException d) {
                System.out.println("Something wrong, please fix it!");
                System.exit(1);
            }
        } catch (ArrayIndexOutOfBoundsException hj) {
            System.out.println("Please change the number inside");
        }
    }
}
