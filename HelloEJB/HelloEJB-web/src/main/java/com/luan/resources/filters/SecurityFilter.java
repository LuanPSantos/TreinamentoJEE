package com.luan.resources.filters;

import com.luan.helloejb.lib.models.Message;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_URL_PREFIX = "secured";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
            String headerString = requestContext.getHeaderString(AUTHORIZATION_HEADER_KEY);

            if (headerString != null) {
                String authToken = headerString.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                String decodedString = Base64.decodeAsString(authToken);
                StringTokenizer stringTokenizer = new StringTokenizer(decodedString, ":");
                String userName = stringTokenizer.nextToken();
                String password = stringTokenizer.nextToken();

                if ("admin".equals(userName) && "admin".equals(password)) {
                    return;
                }
            }

            Response unauthorizatedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(new Message("Usuário não autorizado"))
                    .build();

            requestContext.abortWith(unauthorizatedStatus);
        }
    }
}
