/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.rguevara.pruebarest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.org.rguevara.pruebarest.modelo.Producto;

/**
 *
 * @author Rafael Guevara
 */
@Path("/productos")
public class ProductosServicio {   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Producto producto){
        return Response.ok(producto).build();
    }
}
