package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends Repository {

    public UsuarioTO login(String cpf, String cnpj, String senha) {
        UsuarioTO usuario = null;
        String sql = "SELECT ID_USUARIO, NOME_USUARIO, RAZAO_SOCIAL, CNPJ, CPF, TIPO_CONTA, " +
                "IMAGEM_FOTO, NUMERO_SENHA, VALOR_TOKEN, DATA_CADASTRO " +
                "FROM SUM_USUARIO " +
                "WHERE (CPF = ? OR CNPJ = ?) AND NUMERO_SENHA = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.setString(2, cnpj);
            ps.setString(3, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioTO();
                usuario.setIdUsuario(rs.getLong("ID_USUARIO"));
                usuario.setNomeUsuario(rs.getString("NOME_USUARIO"));
                usuario.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                usuario.setCnpj(rs.getString("CNPJ"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setTipoConta(rs.getString("TIPO_CONTA"));
                usuario.setImagemFoto(rs.getString("IMAGEM_FOTO"));
                usuario.setNumeroSenha(rs.getString("NUMERO_SENHA"));
                usuario.setValorToken(rs.getString("VALOR_TOKEN"));
                usuario.setDataCadastro(rs.getTimestamp("DATA_CADASTRO"));

                String newToken = (cnpj != null && !cnpj.isEmpty()) ? cnpj + "." + senha : cpf + "." + senha;
                usuario.setValorToken(newToken);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
        }
        return usuario;
    }
}