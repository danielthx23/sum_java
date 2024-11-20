package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;

public class UsuarioBO {

    public UsuarioTO findById(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findById(id);
    }

    public UsuarioTO save(@Valid UsuarioTO usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.save(usuario);
    }

    public UsuarioTO update(@Valid UsuarioTO usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.update(usuario);
    }

}