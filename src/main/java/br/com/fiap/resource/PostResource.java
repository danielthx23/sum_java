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
        PostTO savedPost = postBO.save(post);
        if (savedPost != null) {
            return Response.status(Response.Status.CREATED).entity(savedPost).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar Post").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updatePost(@PathParam("id") Long idPost, PostTO post) {
        post.setIdPost(idPost);
        PostTO updatedPost = postBO.update(post);
        if (updatedPost != null) {
            return Response.ok(updatedPost).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Post não encontrado").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePost(@PathParam("id") Long idPost) {
        boolean isDeleted = postBO.delete(idPost);
        if (isDeleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Post não encontrado").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPosts() {
        List<PostTO> posts = postBO.findAll();
        return Response.ok(posts).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPostsByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<PostTO> posts = postBO.findByUsuarioId(usuarioId);
        return Response.ok(posts).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPostById(@PathParam("id") Long idPost) {
        PostTO post = postBO.findById(idPost);
        if (post != null) {
            return Response.ok(post).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Post não encontrado").build();
        }
    }
}