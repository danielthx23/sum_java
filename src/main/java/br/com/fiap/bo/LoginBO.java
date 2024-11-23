package br.com.fiap.bo;

import br.com.fiap.dao.LoginDAO;
import br.com.fiap.to.UsuarioLoginTO;

public class LoginBO {
    public UsuarioLoginTO login(String cpf, String cnpj, String senha) {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.login(cpf, cnpj, senha);
    }
}
