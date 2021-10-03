package avaj;

public class Simulator {
    private int simCount = 10;

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        WeatherTower weatherTower = new WeatherTower();

        AircraftFactory.newAircraft("Baloon",  "B1",  2, 3, 10).registerTower(weatherTower);
        AircraftFactory.newAircraft("Baloon",  "B2",  1, 8, 10).registerTower(weatherTower);
        AircraftFactory.newAircraft("JetPlane",  "J1", 23, 44, 10).registerTower(weatherTower);
        AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 10).registerTower(weatherTower);

        for (int i = 0; i < simulator.simCount; i++) {
            weatherTower.changeWeather();
        }

        Logger.getLogger().close();
    }
}
