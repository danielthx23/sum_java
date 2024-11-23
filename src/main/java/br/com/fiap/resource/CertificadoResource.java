package br.com.fiap.resource;

import br.com.fiap.bo.CertificadoBO;
import br.com.fiap.to.CertificadoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/certificado")
public class CertificadoResource {

    private CertificadoBO certificadoBO = new CertificadoBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCertificado(CertificadoTO certificado) {
        CertificadoTO resultado = certificadoBO.save(certificado);
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
    public Response deleteCertificado(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (certificadoBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<CertificadoTO> resultado = certificadoBO.getByUsuarioId(usuarioId);
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
