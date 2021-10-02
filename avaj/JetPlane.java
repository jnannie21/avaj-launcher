package avaj;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        if (weather == "SUN") {
            this.coordinates = new Coordinates(longitude, latitude + 10, height+ 2);
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(longitude, latitude + 1, height);
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(longitude, latitude, height - 7);
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(longitude, latitude + 5, height);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
