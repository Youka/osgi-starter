package dev.youka.my.provider;

import dev.youka.my.api.MyApi;
import org.osgi.service.component.annotations.Component;

@Component
public class MyProvider implements MyApi {
    @Override
    public void printHello() {
        System.out.println("Hello!");
    }
}
