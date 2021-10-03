package avaj;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        if (weather == "SUN") {
            latitude += 10;
            height += 2;
            Logger.getLogger().log(getInfo() + " This is sunny, lets take a selfie.");
        } else if (weather == "FOG") {
            latitude++;
            Logger.getLogger().log(getInfo() + " Cant see any problem.");
        } else if (weather == "SNOW") {
            height -= 7;
            Logger.getLogger().log(getInfo() + " Jingle bells, jingle bells, jingle all the way.");
        } else if (weather == "RAIN") {
            latitude += 5;
            Logger.getLogger().log(getInfo() + " There is no need in washing when its raining.");
        }
        if (height < 0) {
            height = 0;
        } else if (height > 100) {
            height = 100;
        }
        coordinates = new Coordinates(longitude, latitude, height);
        if (height == 0) {
            this.weatherTower.unregister(this);
            Logger.getLogger().log(getInfo() + " landing. coordinates: " +
                    "longitude " + coordinates.getLongitude() + ", latitude " + coordinates.getLatitude() + ", height " + coordinates.getHeight());
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public String getInfo() {
        return "JetPlane#" + this.name + "(" + this.id + ")";
    }

}
