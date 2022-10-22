package io.youka.osgi.my_dummy_service.provider;

import io.youka.osgi.dummy_service.api.DummyService;
import org.osgi.service.component.annotations.Component;

@Component
public class MyDummyService1 implements DummyService {
    @Override
    public String getMessage() {
        return "My dummy service 1";
    }
}