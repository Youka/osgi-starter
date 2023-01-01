package io.youka.osgi.hello_jaxrs.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.AbstractMap;

@Component(service = HelloResource.class)
@JaxrsResource
@Path("/hello")
public class HelloResource {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public AbstractMap.Entry<String,String> hello() {
        return new AbstractMap.SimpleImmutableEntry<>("Hello", "world!");
    }
}
