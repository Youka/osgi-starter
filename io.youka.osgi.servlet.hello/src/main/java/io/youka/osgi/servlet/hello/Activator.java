package io.youka.osgi.servlet.hello;

import org.osgi.annotation.bundle.Header;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import javax.servlet.Servlet;
import java.util.Map;

import static org.osgi.framework.FrameworkUtil.asDictionary;

@Header(name = Constants.BUNDLE_ACTIVATOR, value = "${@class}")
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) {
        context.registerService(
            Servlet.class,
            new HelloServlet(),
            asDictionary(Map.of(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, "/hello"))
        );
    }

    @Override
    public void stop(BundleContext context) { }
}