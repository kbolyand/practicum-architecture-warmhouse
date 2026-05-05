package smarthome.temperature_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TemperatureResponse {
    private float value;
    private String unit;
    private Instant timestamp;
    private String location;
    private String status;
    private String sensor_id;
    private String sensor_type;
    private String description;
}
