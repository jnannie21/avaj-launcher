package avaj;

import java.util.ArrayList;

public class Simulator {
    private int simCount = 10;

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        WeatherTower weatherTower = new WeatherTower();
        ArrayList<Flyable> flyables = new ArrayList<>();

        AircraftFactory.newAircraft("Baloon",  "B1",  2, 3, 20).registerTower(weatherTower);
        AircraftFactory.newAircraft("Baloon",  "B2",  1, 8, 66).registerTower(weatherTower);
        AircraftFactory.newAircraft("JetPlane",  "J1", 23, 44, 32).registerTower(weatherTower);
        AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20).registerTower(weatherTower);

        for (int i = 0; i < simulator.simCount; i++) {
            Logger.getLogger().log("Simulation " + i);
            weatherTower.changeWeather();
        }

        Logger.getLogger().close();
    }
}
