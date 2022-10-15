package io.youka.osgi.hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import javax.servlet.Servlet;
import java.util.Hashtable;

public class Activator implements BundleActivator {
    private ServiceRegistration<Servlet> registration;

    public void start(BundleContext context) {
        var props = new Hashtable<String, String>();
        props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, "/hello");
        this.registration = context.registerService(Servlet.class, new HelloServlet(), props);
    }

    public void stop(BundleContext context) {
        this.registration.unregister();
    }
}