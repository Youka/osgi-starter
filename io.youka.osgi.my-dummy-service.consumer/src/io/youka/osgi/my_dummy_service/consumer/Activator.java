package io.youka.osgi.my_dummy_service.consumer;

import org.osgi.annotation.bundle.Header;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

@Header(name = Constants.BUNDLE_ACTIVATOR, value = "${@class}")
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) {
        System.out.println("Started bundle " + context.getBundle().getBundleId());
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Stopped bundle " + context.getBundle().getBundleId());
    }
}
