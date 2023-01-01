package io.youka.osgi.hello_jaxrs.provider.security;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsExtension;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Component
@JaxrsExtension
public class AuthorizationFilter implements ContainerRequestFilter {
    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext request) {
        // Method to inspect
        Optional<Method> resourceMethod = Optional.ofNullable(this.resourceInfo)
            .map(ResourceInfo::getResourceMethod);

        // Permit all?
        boolean permitAll = resourceMethod
            .map(method -> method.getAnnotation(PermitAll.class))
            .isPresent();
        if (permitAll) {
            return;
        }

        // Authorization required
        SecurityContext securityContext = request.getSecurityContext();
        if (securityContext == null) {
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }

        // Allowed role?
        boolean hasRole = resourceMethod
            .map(method -> method.getAnnotation(RolesAllowed.class))
            .map(RolesAllowed::value)
            .map(Arrays::stream)
            .map(roles -> roles.anyMatch(securityContext::isUserInRole))
            .orElse(false);
        if (hasRole) {
            return;
        }

        // Access forbidden
        request.abortWith(Response.status(Response.Status.FORBIDDEN).build());
    }
}
