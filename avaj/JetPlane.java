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
            if (height > 100) {
                height = 100;
            }
            Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " This is hot.");
        } else if (weather == "FOG") {
            latitude++;
            Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " Cant see any problem.");
        } else if (weather == "SNOW") {
            height -= 7;
            if (height <= 0) {
                this.weatherTower.unregister(this);
                Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " landing.");
                Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " landing coordinates: " +
                        "longitude " + coordinates.getLongitude() + ", latitude " + coordinates.getLatitude() + ", height " + coordinates.getHeight());
            } else {
                Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " OMG! Winter is coming!");
            }
        } else if (weather == "RAIN") {
            latitude += 5;
            Logger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ")" + " Damn you rain! You messed up my baloon.");
        }
        coordinates = new Coordinates(longitude, latitude, height);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
