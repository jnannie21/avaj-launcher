package avaj;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        if (weather == "SUN") {
            this.coordinates = new Coordinates(longitude + 2, latitude, height+ 4);
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(longitude, latitude, height - 3);
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(longitude, latitude, height + 15);
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(longitude, latitude, height - 5);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
