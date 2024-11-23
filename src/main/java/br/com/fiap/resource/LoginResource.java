package br.com.fiap.resource;

import br.com.fiap.bo.LoginBO;
import br.com.fiap.to.UsuarioLoginTO;
import br.com.fiap.to.UsuarioTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    private LoginBO loginBO = new LoginBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UsuarioLoginTO loginRequest) {
        UsuarioLoginTO resultado = loginBO.login(loginRequest.getCpf(), loginRequest.getCnpj(), loginRequest.getNumeroSenha());
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais Inválidas!");
        }
        response.entity(resultado);
        return response.build();
    }
}
