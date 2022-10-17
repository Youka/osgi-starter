package io.youka.osgi.hello_command.provider;

import io.youka.osgi.hello_command.provider.car.Car;
import io.youka.osgi.hello_command.provider.car.CarMapper;
import org.apache.commons.io.IOUtils;
import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@GogoCommand(scope="hello", function={"world", "car"})
@Component(service=Object.class)    // Expose globally and gets detected by component properties from @GogoCommand
public class HelloCommand {
    public String world() throws IOException {
        return IOUtils.resourceToString("/hello_world.txt", StandardCharsets.UTF_8, this.getClass().getClassLoader());
    }

    public String car() {
        return CarMapper.INSTANCE.carToCarDto(new Car("VW", 5)).toString();
    }

    @Activate
    void activate(ComponentContext context) {
        System.out.println("Activated component " + this.getClass().getName());
    }
    @Deactivate
    void deactivate(ComponentContext context) {
        System.out.println("Deactivated component " + this.getClass().getName());
    }
    @Modified
    void modified(ComponentContext context) {
        System.out.println("Modified component " + this.getClass().getName());
    }
}