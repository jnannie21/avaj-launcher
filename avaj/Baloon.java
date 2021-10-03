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
            longitude += 2;
            height += 4;
            if (height > 100) {
                height = 100;
            }
            Logger.getLogger().log(getInfo() + " This is sunny, lets take a selfie.");
        } else if (weather == "FOG") {
            height -= 3;
            Logger.getLogger().log(getInfo() + " Cant see any problem.");
        } else if (weather == "SNOW") {
            height += 15;
            Logger.getLogger().log(getInfo() + " Jingle bells, jingle bells, jingle all the way.");
        } else if (weather == "RAIN") {
            height -= 5;
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
//            Logger.getLogger().log(getInfo() + " landing.");
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
        return "Baloon#" + this.name + "(" + this.id + ")";
    }
}
