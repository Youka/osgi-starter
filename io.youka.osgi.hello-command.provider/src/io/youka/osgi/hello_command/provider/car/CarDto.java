package io.youka.osgi.hello_command.provider.car;

import lombok.Data;

@Data
public class CarDto {
    private String manufacturer;
    private int seatCount;
}