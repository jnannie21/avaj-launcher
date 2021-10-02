package avaj;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        if (weather == "SUN") {
            this.coordinates = new Coordinates(longitude + 10, latitude, height+ 2);
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(longitude + 1, latitude, height);
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(longitude, latitude, height + 12);
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(longitude + 5, latitude, height);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
