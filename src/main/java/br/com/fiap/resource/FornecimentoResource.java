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
        List<FornecimentoTO> resultado = fornecimentoBO.findAll();
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
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<FornecimentoTO> resultado = fornecimentoBO.findByUsuarioId(usuarioId);
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long idFornecimento) {
        FornecimentoTO resultado = fornecimentoBO.findById(idFornecimento);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long idFornecimento, FornecimentoTO fornecimento) {
        fornecimento.setIdFornecimento(idFornecimento);
        FornecimentoTO resultado = fornecimentoBO.update(fornecimento);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(FornecimentoTO fornecimento) {
        FornecimentoTO resultado = fornecimentoBO.save(fornecimento);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idFornecimento) {
        Response.ResponseBuilder response = null;
        if (fornecimentoBO.delete(idFornecimento)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }
}
