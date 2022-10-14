package io.youka.osgi.web_server;

import lombok.Getter;
import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.service.component.annotations.Component;

@GogoCommand(scope="hello", function="world")
@Component(service=Object.class)
public class Hello {
    @Getter
    private final String world = "Hello World";

    public String world() {
        return this.getWorld();
    }
}