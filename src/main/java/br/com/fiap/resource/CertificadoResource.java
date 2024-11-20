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
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCertificado(CertificadoTO certificado) {
        CertificadoTO savedCertificado = certificadoBO.save(certificado);
        return Response.status(Response.Status.CREATED).entity(savedCertificado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCertificado(@PathParam("id") Long id) {
        boolean isDeleted = certificadoBO.delete(id);
        if (isDeleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/usuario/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        List<CertificadoTO> certificados = certificadoBO.getByUsuarioId(usuarioId);
        return Response.ok(certificados).build();
    }
}
