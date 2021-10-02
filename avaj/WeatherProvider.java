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
//        int latitude = coordinates.getLatitude();
//        int longitude = coordinates.getLongitude();
//        int height = coordinates.getHeight();
//
//        if (latitude > 0 && longitude > 0) {
//            if (height > 50) {
//                return weather[1];
//            } else {
//                return weather[0];
//            }
//        } else if (latitude > 0 && longitude < 0) {
//            if (height > 50) {
//                return weather[2];
//            } else {
//                return weather[1];
//            }
//        } else if (latitude < 0 && longitude < 0) {
//            if (height > 50) {
//                return weather[3];
//            } else {
//                return weather[2];
//            }
//        } else {
//            if (height > 50) {
//                return weather[0];
//            } else {
//                return weather[3];
//            }
//        }
    }
}
