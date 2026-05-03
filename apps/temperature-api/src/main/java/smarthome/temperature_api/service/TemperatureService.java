package smarthome.temperature_api.service;

import org.springframework.stereotype.Service;
import smarthome.temperature_api.dto.TemperatureResponse;

import java.time.Instant;
import java.util.Random;

@Service
public class TemperatureService {
    private static final float MIN = -30.0f;
    private static final float MAX = 50.0f;
    private Random random = new Random();

    public TemperatureResponse getTemperature(String sensorId, String location) {
        String responseLocation = location;
        String responseSensorId = sensorId;
        if (location == null) {
            switch (sensorId) {
                case "1":
                    responseLocation = "Living Room";
                    break;
                case "2":
                    responseLocation = "Bedroom";
                    break;
                case "3":
                    responseLocation = "Kitchen";
                    break;
                default:
                    responseLocation = "Unknown";
            }
        }

        if (sensorId == null) {
            switch (location) {
                case "Living Room":
                    responseSensorId = "1";
                    break;
                case "Bedroom":
                    responseSensorId = "2";
                    break;
                case "Kitchen":
                    responseSensorId = "3";
                    break;
                default:
                    responseSensorId = "0";
            }
        }
        return new TemperatureResponse(getRandomValue(), "C", Instant.now(), responseLocation, "OK", responseSensorId, "Temperature", "no description");
    }

    private float getRandomValue() {
        return MIN + random.nextFloat() * (MAX - MIN);
    }
}
