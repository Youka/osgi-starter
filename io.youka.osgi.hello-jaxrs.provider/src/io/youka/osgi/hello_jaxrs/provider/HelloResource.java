package io.youka.osgi.hello_jaxrs.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component(service = HelloResource.class)
@JaxrsResource
@Path("/hello")
public class HelloResource {
    @GET
    @Path("/")
    public String hello() {
        return "Hello world!";
    }
}
