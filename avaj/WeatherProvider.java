package avaj;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "FOG", "SNOW", "RAIN"};

    private WeatherProvider() {}

    static public WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        int index = (new Random().nextInt(4) + coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;

        return weather[index];
    }
}
