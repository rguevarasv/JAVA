/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.rguevara.pruebarest.servicios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.math.BigDecimal;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.org.rguevara.pruebarest.dao.UsuarioDAO;
import sv.org.rguevara.pruebarest.modelo.Usuario;


/**
 *
 * @author Rafael Guevara
 */
@Path("/auth/")
public class LoginServicio {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response encodeJWT(Usuario usuario){
        boolean status = UsuarioDAO.validar(usuario.getUsername(), usuario.getPassword());
        if(status){
            String key = "mi_clave";
            long tiempo = System.currentTimeMillis();
           String jwt = Jwts.builder()
                   .signWith(SignatureAlgorithm.HS256, key)
                   .setSubject("Rafael Guevara")
                   .setIssuedAt(new Date(tiempo))
                   .setExpiration(new Date(tiempo+900000))
                   .claim("email", "rafael.guevara@gmail.com")
                   .compact();
           JsonObject json = Json.createObjectBuilder()
                   .add("JWT", jwt).build();
           return Response.status(Response.Status.CREATED).entity(json).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
