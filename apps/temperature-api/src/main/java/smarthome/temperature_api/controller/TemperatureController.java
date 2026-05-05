package smarthome.temperature_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import smarthome.temperature_api.dto.TemperatureResponse;
import smarthome.temperature_api.service.TemperatureService;

@RestController
@AllArgsConstructor
public class TemperatureController {
    private TemperatureService temperatureService;


    @GetMapping("/temperature/{sensorId}")
    public TemperatureResponse getTemperatureBySensorId(@PathVariable String sensorId) {
        return temperatureService.getTemperature(sensorId, null);
    }

    @GetMapping("/temperature")
    public TemperatureResponse getTemperatureByLocation(@RequestParam(name = "location", required = false) String location) {
        return temperatureService.getTemperature(null, location);
    }
}
