package io.youka.osgi.hello_jaxrs.provider.security;

import lombok.Value;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsExtension;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Component
@JaxrsExtension
@PreMatching
public class IdentityFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext request) {
        Optional.ofNullable(request.getUriInfo().getQueryParameters().get("role"))
            .map(DummySecurityContext::new)
            .ifPresent(request::setSecurityContext);
    }

    @Value
    private static class DummySecurityContext implements SecurityContext {
        List<String> roles;

        @Override
        public boolean isUserInRole(String role) {
            return roles.contains(role);
        }
        @Override
        public Principal getUserPrincipal() {
            return null;
        }
        @Override
        public boolean isSecure() {
            return true;
        }
        @Override
        public String getAuthenticationScheme() {
            return SecurityContext.DIGEST_AUTH;
        }
    }
}
