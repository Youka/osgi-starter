package dev.youka.my.application;

import dev.youka.my.api.MyApi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class Main {
    @Activate
    public Main(@Reference MyApi myApi) {
        myApi.printHello();
    }
}
