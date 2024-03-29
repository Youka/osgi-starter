package io.youka.osgi.hello_servlet.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@HttpWhiteboardResource(pattern = "/hello-static/*", prefix = "/www")
@Component(service = Object.class)  // Service type doesn't matter but this component needs to be registered
public class HelloStaticServlet {
}
