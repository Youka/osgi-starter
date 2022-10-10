package io.youka.osgi.web_server;

import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.service.component.annotations.Component;

@GogoCommand(scope="hello", function= {"hello"})
@Component(service=Object.class)
public class HelloWorld {
    public String hello() {
        return "Hello World";
    }
}