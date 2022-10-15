package io.youka.osgi.servlet.hello;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@HttpWhiteboardResource(pattern = "/hello/*", prefix = "/")
@Component(service = HelloStaticServlet.class)
public class HelloStaticServlet {
}
