package io.youka.osgi.my_dummy_service.provider;

import io.youka.osgi.dummy_service.api.DummyService;
import org.osgi.service.component.annotations.Component;

@Component(property = "service.dummy.active=false")
public class MyDummyService2 implements DummyService {
    @Override
    public String getMessage() {
        return "My dummy service 2";
    }
}