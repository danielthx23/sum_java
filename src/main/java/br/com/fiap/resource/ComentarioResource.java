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
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComentario(ComentarioTO comentario) {
        ComentarioTO savedComentario = comentarioBO.save(comentario);
        return Response.status(Response.Status.CREATED).entity(savedComentario).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateComentario(@PathParam("id") Long idComentario, ComentarioTO comentario) {
        comentario.setIdComentario(idComentario);
        ComentarioTO updatedComentario = comentarioBO.update(comentario);
        return Response.ok(updatedComentario).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComentario(@PathParam("id") Long idComentario) {
        boolean isDeleted = comentarioBO.delete(idComentario);
        if (isDeleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<ComentarioTO> comentarios = comentarioBO.findByUsuarioId(usuarioId);
        return Response.ok(comentarios).build();
    }

    @GET
    @Path("/post/{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPostId(@PathParam("postId") Long postId) {
        List<ComentarioTO> comentarios = comentarioBO.findByPostId(postId);
        return Response.ok(comentarios).build();
    }
}