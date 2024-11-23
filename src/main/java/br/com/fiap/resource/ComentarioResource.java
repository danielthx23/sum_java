package br.com.fiap.resource;

import br.com.fiap.bo.ComentarioBO;
import br.com.fiap.to.ComentarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/comentario")
public class ComentarioResource {

    private ComentarioBO comentarioBO = new ComentarioBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComentario(ComentarioTO comentario) {
        ComentarioTO resultado = comentarioBO.save(comentario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateComentario(@PathParam("id") Long idComentario, ComentarioTO comentario) {
        comentario.setIdComentario(idComentario);
        ComentarioTO resultado = comentarioBO.update(comentario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComentario(@PathParam("id") Long idComentario) {
        Response.ResponseBuilder response = null;
        if (comentarioBO.delete(idComentario)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<ComentarioTO> resultado = comentarioBO.findByUsuarioId(usuarioId);
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/post/{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPostId(@PathParam("postId") Long postId) {
        List<ComentarioTO> resultado = comentarioBO.findByPostId(postId);
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{comentarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("comentarioId") Long comentarioId) {
        ComentarioTO resultado = comentarioBO.findById(comentarioId);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
