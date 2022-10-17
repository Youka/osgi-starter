package io.youka.osgi.hello_command.provider;

import org.osgi.annotation.bundle.Header;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

@Header(name = Constants.BUNDLE_ACTIVATOR, value = "${@class}")
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Started bundle " + context.getBundle().getBundleId());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Stopped bundle " + context.getBundle().getBundleId());
    }
}
