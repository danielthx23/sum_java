package br.com.fiap.dao;

import br.com.fiap.to.PostTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends Repository {

    public PostTO save(PostTO post) {
        String sql = "INSERT INTO SUM_POST (TITULO, DESCRICAO, IMAGEM, DATA_CADASTRO, ID_USUARIO) " +
                "VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescricao());
            ps.setString(3, (post.validarUrl(post.getImagem()) ? post.getImagem() : "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM7QASNJmlXOAi1wjMYD0ES3vRAOx2cERm8EUeH8CJWvB1uV7dZEpN4YNWbO1V-d30yOw"));
            ps.setLong(4, post.getUsuario().getIdUsuario());
            ps.executeUpdate();
            return post;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar Post: " + e.getMessage());
            return null;
        }
    }

    public PostTO update(PostTO post) {
        String sql = "UPDATE SUM_POST SET TITULO = ?, DESCRICAO = ?, IMAGEM = ?, ID_USUARIO = ? " +
                "WHERE ID_POST = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescricao());
            ps.setString(3, post.getImagem());
            ps.setLong(4, post.getUsuario().getIdUsuario());
            ps.setLong(5, post.getIdPost());
            ps.executeUpdate();
            return post;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Post: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(Long idPost) {
        String sql = "DELETE FROM SUM_POST WHERE ID_POST = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPost);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Post: " + e.getMessage());
            return false;
        }
    }

    public List<PostTO> findAll() {
        List<PostTO> posts = new ArrayList<>();
        String sql = "SELECT p.*, u.* FROM SUM_POST p JOIN SUM_USUARIO u ON p.ID_USUARIO = u.ID_USUARIO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PostTO post = new PostTO();
                post.setIdPost(rs.getLong("ID_POST"));
                post.setTitulo(rs.getString("TITULO"));
                post.setDescricao(rs.getString("DESCRICAO"));
                post.setImagem(rs.getString("IMAGEM"));
                post.setDataCadastro(rs.getTimestamp("DATA_CADASTRO"));

                // Create and set the UsuarioTO object with all user data
                UsuarioTO usuario = new UsuarioTO();
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

                post.setUsuario(usuario);
                posts.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Posts: " + e.getMessage ());
        }
        return posts;
    }

    public List<PostTO> findByUsuarioId(Long usuarioId) {
        List<PostTO> posts = new ArrayList<>();
        String sql = "SELECT p.*, u.* FROM SUM_POST p JOIN SUM_USUARIO u ON p.ID_USUARIO = u.ID_USUARIO WHERE p.ID_USUARIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostTO post = new PostTO();
                post.setIdPost(rs.getLong("ID_POST"));
                post.setTitulo(rs.getString("TITULO"));
                post.setDescricao(rs.getString("DESCRICAO"));
                post.setImagem(rs.getString("IMAGEM"));
                post.setDataCadastro(rs.getTimestamp("DATA_CADASTRO"));

                UsuarioTO usuario = new UsuarioTO();
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

                post.setUsuario(usuario);
                posts.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Posts por ID_USUARIO: " + e.getMessage());
        }
        return posts;
    }

    public PostTO findById(Long idPost) {
        PostTO post = null;
        String sql = "SELECT p.*, u.* FROM SUM_POST p JOIN SUM_USUARIO u ON p.ID_USUARIO = u.ID_USUARIO WHERE p.ID_POST = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPost);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post = new PostTO();
                post.setIdPost(rs.getLong("ID_POST"));
                post.setTitulo(rs.getString("TITULO"));
                post.setDescricao(rs.getString("DESCRICAO"));
                post.setImagem(rs.getString("IMAGEM"));
                post.setDataCadastro(rs.getTimestamp("DATA_CADASTRO"));

                UsuarioTO usuario = new UsuarioTO();
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

                post.setUsuario(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Post por ID: " + e.getMessage());
        }
        return post;
    }

}