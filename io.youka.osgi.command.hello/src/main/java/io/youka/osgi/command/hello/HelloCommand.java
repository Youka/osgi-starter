package io.youka.osgi.command.hello;

import lombok.Data;
import lombok.Value;
import org.apache.commons.io.IOUtils;
import org.apache.felix.service.command.annotations.GogoCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@GogoCommand(scope="hello", function={"world", "car"})
@Component(service=Object.class)
public class HelloCommand {
    public String world() throws IOException {
        return IOUtils.resourceToString("/hello_world.txt", StandardCharsets.UTF_8, this.getClass().getClassLoader());
    }

    public String car() {
        return CarMapper.INSTANCE.carToCarDto(new Car("George", 42)).toString();
    }
}

@Value
class Car {
    String make;
    int numberOfSeats;
}

@Data
class CarDto {
    private String make;
    private int seatCount;
}

@Mapper
interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}