package io.youka.osgi.hello_command.provider.car;

import lombok.Value;

@Value
public class Car {
    String manufacturer;
    int numberOfSeats;
}