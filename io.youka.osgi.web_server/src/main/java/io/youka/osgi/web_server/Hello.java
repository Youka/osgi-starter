package io.youka.osgi.web_server;

import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@GogoCommand(scope="hello", function="world")
@Component(service=Object.class)
public class Hello {
    @Getter
    private final String world;

    public Hello() throws IOException {
        this.world = IOUtils.resourceToString("/hello_world.txt", StandardCharsets.UTF_8, this.getClass().getClassLoader());
    }

    public String world() {
        return this.getWorld();
    }
}