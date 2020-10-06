/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.rguevara.pruebarest.servicios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Rafael Guevara
 */
@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Claims claims = null;
        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        if (url.contains("/api/auth")) {
            return;
        }

        String token = requestContext.getHeaderString("Authorization");
        if (token == null) {
            JsonObject json = Json.createObjectBuilder()
                    .add("mensaje", "Credenciales son necesarias")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json).build());
            return;
        }
        try {
            claims = decodeJWT(token);
        } catch (Exception e) {
            JsonObject json = Json.createObjectBuilder()
                    .add("mensaje", e.getMessage())
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json).build());
        }
        //System.out.println("Info " + claims.getSubject());
        if (claims == null) {
            JsonObject json = Json.createObjectBuilder()
                    .add("mensaje", "Ha ocurrido un error con el token")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json).build());
        }else if (!claims.getSubject().equals("Rafael Guevara")) {
            JsonObject json = Json.createObjectBuilder()
                    .add("mensaje", "Credenciales incorrectas")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(json).build());
        }

    }

    public Claims decodeJWT(String jwt) {
        String key = "mi_clave";
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

}
