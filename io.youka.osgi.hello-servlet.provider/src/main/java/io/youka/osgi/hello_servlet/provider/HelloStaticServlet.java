package io.youka.osgi.hello_servlet.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@HttpWhiteboardResource(pattern = "/hello-static/*", prefix = "/www")
@Component(service = HelloStaticServlet.class)
public class HelloStaticServlet {
}
