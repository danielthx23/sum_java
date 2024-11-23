package br.com.fiap.resource;

import br.com.fiap.bo.PostBO;
import br.com.fiap.to.PostTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/post")
public class PostResource {

    private PostBO postBO = new PostBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPost(PostTO post) {
        PostTO resultado = postBO.save(post);
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
    public Response updatePost(@PathParam("id") Long idPost, PostTO post) {
        post.setIdPost(idPost);
        PostTO resultado = postBO.update(post);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePost(@PathParam("id") Long idPost) {
        Response.ResponseBuilder response = null;
        if (postBO.delete(idPost)) {
            response = Response.status(Response.Status.NO_CONTENT);
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        return response.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPosts() {
        List<PostTO> resultado = postBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok();
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPostsByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<PostTO> resultado = postBO.findByUsuarioId(usuarioId);
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
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
    public Response findPostById(@PathParam("id") Long idPost) {
        PostTO resultado = postBO.findById(idPost);
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
