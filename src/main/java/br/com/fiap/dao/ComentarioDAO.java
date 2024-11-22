package br.com.fiap.dao;

import br.com.fiap.to.ComentarioTO;
import br.com.fiap.to.PostTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends Repository {

        public ComentarioTO save(ComentarioTO comentario) {
            String sql = "INSERT INTO SUM_COMENTARIO (TITULO, TEXTO, IMAGEM, ID_USUARIO, ID_POST) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setString(1, comentario.getTitulo());
                ps.setString(2, comentario.getTexto());
                ps.setString(3, comentario.getImagem());
                ps.setLong(4, comentario.getUsuario().getIdUsuario());
                ps.setLong(5, comentario.getPost().getIdPost());
                ps.executeUpdate();
                return comentario;
            } catch (SQLException e) {
                System.out.println("Erro ao salvar Comentario: " + e.getMessage());
                return null;
            }
        }

        public ComentarioTO update(ComentarioTO comentario) {
            String sql = "UPDATE SUM_COMENTARIO SET TITULO = ?, TEXTO = ?, IMAGEM = ?, ID_USUARIO = ?, ID_POST = ? " +
                    "WHERE ID_COMENTARIO = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setString(1, comentario.getTitulo());
                ps.setString(2, comentario.getTexto());
                ps.setString(3, comentario.getImagem());
                ps.setLong(4, comentario.getUsuario().getIdUsuario());
                ps.setLong(5, comentario.getPost().getIdPost());
                ps.setLong(6, comentario.getIdComentario());
                ps.executeUpdate();
                return comentario;
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar Comentario: " + e.getMessage());
                return null;
            }
        }

        public boolean delete(Long idComentario) {
            String sql = "DELETE FROM SUM_COMENTARIO WHERE ID_COMENTARIO = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setLong(1, idComentario);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println("Erro ao deletar Comentario: " + e.getMessage());
                return false;
            }
        }

        public List<ComentarioTO> findByUsuarioId(Long usuarioId) {
            List<ComentarioTO> comentarios = new ArrayList<>();
            String sql = "SELECT c.*, u.* FROM SUM_COMENTARIO c JOIN SUM_USUARIO u ON c.ID_USUARIO = u.ID_USUARIO WHERE c.ID_USUARIO = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setLong(1, usuarioId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ComentarioTO comentario = new ComentarioTO();
                    comentario.setIdComentario(rs.getLong("ID_COMENTARIO"));
                    comentario.setTitulo(rs.getString("TITULO"));
                    comentario.setTexto(rs.getString("TEXTO"));
                    comentario.setImagem(rs.getString("IMAGEM"));

                    PostTO post = new PostTO();
                    post.setIdPost(rs.getLong("ID_POST"));

                    comentario.setPost(post);

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

                    comentario.setUsuario(usuario);
                    comentarios.add(comentario);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao buscar Comentarios por ID_USUARIO: " + e.getMessage());
            }
            return comentarios;
        }

        public List<ComentarioTO> findByPostId(Long postId) {
            List<ComentarioTO> comentarios = new ArrayList<>();
            String sql = "SELECT c.*, u.* FROM SUM_COMENTARIO c JOIN SUM_USUARIO u ON c.ID_USUARIO = u.ID_USUARIO WHERE c.ID_POST = ?";
            try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
                ps.setLong(1, postId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ComentarioTO comentario = new ComentarioTO();
                    comentario.setIdComentario(rs.getLong("ID_COMENTARIO"));
                    comentario.setTitulo(rs.getString("TITULO"));
                    comentario.setTexto(rs.getString("TEXTO"));
                    comentario.setImagem(rs.getString("IMAGEM"));

                    PostTO post = new PostTO();
                    post.setIdPost(rs.getLong("ID_POST"));

                    comentario.setPost(post);

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

                    comentario.setUsuario(usuario);
                    comentarios.add(comentario);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao buscar Comentarios por ID_POST: " + e.getMessage());
            }
            return comentarios;
        }

    public ComentarioTO findById(Long idComentario) {
        ComentarioTO comentario = null;
        String sql = "SELECT c.*, u.* FROM SUM_COMENTARIO c JOIN SUM_USUARIO u ON c.ID_USUARIO = u.ID_USUARIO WHERE c.ID_COMENTARIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idComentario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comentario = new ComentarioTO();
                comentario.setIdComentario(rs.getLong("ID_COMENTARIO"));
                comentario.setTitulo(rs.getString("TITULO"));
                comentario.setTexto(rs.getString("TEXTO"));
                comentario.setImagem(rs.getString("IMAGEM"));

                PostTO post = new PostTO();
                post.setIdPost(rs.getLong("ID_POST"));

                comentario.setPost(post);

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

                comentario.setUsuario(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Comentario por ID_COMENTARIO: " + e.getMessage());
        }
        return comentario;
    }

};
