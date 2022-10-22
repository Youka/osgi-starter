package io.youka.osgi.my_dummy_service.consumer;

import io.youka.osgi.dummy_service.api.DummyService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true)
public class MyDummyServiceConsumer {
    @Activate
    public MyDummyServiceConsumer(
        ComponentContext context,
        @Reference(target = "(!(service.dummy.active=false))") List<DummyService> dummyServices
    ) {
        System.out.println("Activated component " + this.getClass().getName());
        System.out.println("Found dummy service messages: " + dummyServices.stream().map(DummyService::getMessage).toList());
    }

    @Deactivate
    private void deactivate(ComponentContext context) {
        System.out.println("Deactivated component " + this.getClass().getName());
    }

    @Modified
    private void modified(ComponentContext context) {
        System.out.println("Modified component " + this.getClass().getName());
    }
}
