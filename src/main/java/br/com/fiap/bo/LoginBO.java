package br.com.fiap.bo;

import br.com.fiap.dao.LoginDAO;
import br.com.fiap.to.UsuarioTO;

public class LoginBO {
    public UsuarioTO login(String cpf, String cnpj, String senha) {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.login(cpf, cnpj, senha);
    }
}
