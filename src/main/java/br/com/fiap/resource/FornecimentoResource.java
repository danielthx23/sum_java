package br.com.fiap.resource;

import br.com.fiap.bo.FornecimentoBO;
import br.com.fiap.to.FornecimentoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/fornecimento")
public class FornecimentoResource {

    private FornecimentoBO fornecimentoBO = new FornecimentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<FornecimentoTO> fornecimentos = fornecimentoBO.findAll();
        return Response.ok(fornecimentos).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<FornecimentoTO> fornecimentos = fornecimentoBO.findByUsuarioId(usuarioId);
        return Response.ok(fornecimentos).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long idFornecimento) {
        FornecimentoTO fornecimento = fornecimentoBO.findById(idFornecimento);
        if (fornecimento != null) {
            return Response.ok(fornecimento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Fornecimento não encontrado").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long idFornecimento, FornecimentoTO fornecimento) {
        fornecimento.setIdFornecimento(idFornecimento);
        FornecimentoTO updatedFornecimento = fornecimentoBO.update(fornecimento);
        return Response.ok(updatedFornecimento).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(FornecimentoTO fornecimento) {
        FornecimentoTO savedFornecimento = fornecimentoBO.save(fornecimento);
        return Response.ok(savedFornecimento).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idFornecimento) {
        boolean isDeleted = fornecimentoBO.delete(idFornecimento);
        if (isDeleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}