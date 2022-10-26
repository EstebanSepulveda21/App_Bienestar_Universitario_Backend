package unibague.sistemas.bienestar_universitario.person.application.usecase;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        if(url.contains("/api/v1/person/auth")){
            return;
        }
        String token = requestContext.getHeaderString("Authorization");
        if(token == null){
            JsonObject json = Json.createObjectBuilder()
                    .add("message","The credentials are necessary")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
            return;
        }
        if(!token.equals("AHGC-12BD-1328-75HF-HD64")){
            JsonObject json = Json.createObjectBuilder()
                    .add("message","The wrong credentials")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
            return;
        }
    }
}
