package io.youka.osgi.web_server;

import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.service.component.annotations.Component;

@GogoCommand(scope="hello", function="world")
@Component(service=Object.class)
public class Hello {
    public String world() {
        return "Hello World";
    }
}