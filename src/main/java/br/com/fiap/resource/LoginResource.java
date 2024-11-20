package br.com.fiap.resource;

import br.com.fiap.bo.LoginBO;
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
    public Response login(LoginRequest loginRequest) {
        UsuarioTO usuario = loginBO.login(loginRequest.getCpf(), loginRequest.getCnpj(), loginRequest.getNumeroSenha());
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais Inválidas!").build();
        }
    }

    public static class LoginRequest {
        private String cpf;
        private String cnpj;
        private String numeroSenha;

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getNumeroSenha() {
            return numeroSenha;
        }

        public void setNumeroSenha(String numeroSenha) {
            this.numeroSenha = numeroSenha;
        }
    }
}