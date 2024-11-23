package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(UsuarioTO usuario) {
        UsuarioTO resultado = usuarioBO.save(usuario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.status(Response.Status.CREATED);
        } else {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateUsuario(@PathParam("id") Long idUsuario, UsuarioTO usuario) {
        usuario.setIdUsuario(idUsuario);
        UsuarioTO resultado = usuarioBO.update(usuario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarioById(@PathParam("id") Long idUsuario) {
        UsuarioTO resultado = usuarioBO.findById(idUsuario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }
}
