package io.youka.osgi.hello_jaxrs.provider;

import io.youka.osgi.hello_jaxrs.provider.dto.Pair;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Component(service = HelloResource.class)
@JaxrsResource
@Path("/hello")
public class HelloResource {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("USER")
    public Pair<String,String> hello(@Context SecurityContext securityContext) {
        return new Pair<>("Hello", securityContext.getUserPrincipal().getName());
    }
}
