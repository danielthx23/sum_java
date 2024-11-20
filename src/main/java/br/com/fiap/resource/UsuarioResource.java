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
        UsuarioTO savedUsuario = usuarioBO.save(usuario);
        if (savedUsuario != null) {
            return Response.status(Response.Status.CREATED).entity(savedUsuario).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Usuário não encontrado").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateUsuario(@PathParam("id") Long idUsuario, UsuarioTO usuario) {
        usuario.setIdUsuario(idUsuario);
        UsuarioTO updatedUsuario = usuarioBO.update(usuario);
        if (updatedUsuario != null) {
            return Response.ok(updatedUsuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarioById(@PathParam("id") Long idUsuario) {
        UsuarioTO usuario = usuarioBO.findById(idUsuario);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
    }
}