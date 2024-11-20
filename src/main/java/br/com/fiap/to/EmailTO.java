package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class EmailTO {

    private long idEmail;

    @NotNull
    private String email;

    @NotNull
    private UsuarioTO usuario;

    public EmailTO() {
    }

    public EmailTO(long idEmail, String email, UsuarioTO usuario) {
        this.idEmail = idEmail;
        this.email = email;
        this.usuario = usuario;
    }

    public long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(long idEmail) {
        this.idEmail = idEmail;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotNull UsuarioTO usuario) {
        this.usuario = usuario;
    }
}
