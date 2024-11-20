package br.com.fiap.dao;

import br.com.fiap.to.CertificadoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificadoDAO extends Repository {
    public CertificadoTO save(CertificadoTO certificado) {
        String sql = "INSERT INTO SUM_CERTIFICADO (NOME_CERTIFICADO, DESCRICAO, METODO_OBTER, TIPO_CERTIFICADO, ID_CONSUMIDOR) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, certificado.getNomeCertificado());
            ps.setString(2, certificado.getDescricao());
            ps.setString(3, certificado.getMetodoObter());
            ps.setString(4, certificado.getTipoCertificado());
            ps.setLong(5, certificado.getConsumidor().getConsumidorId());
            ps.executeUpdate();
            return certificado;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar Certificado: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(Long idCertificado) {
        String sql = "DELETE FROM SUM_CERTIFICADO WHERE ID_CERTIFICADO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCertificado);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Certificado: " + e.getMessage());
            return false;
        }
    }

    public List<CertificadoTO> findByUsuarioId(Long usuarioId) {
        List<CertificadoTO> certificados = new ArrayList<>();
        String sql = "SELECT c.* FROM SUM_CERTIFICADO c " +
                "JOIN SUM_CONSUMIDOR co ON c.ID_CONSUMIDOR = co.ID_CONSUMIDOR " +
                "WHERE co.ID_USUARIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CertificadoTO certificado = new CertificadoTO();
                certificado.setIdCertificado(rs.getLong("ID_CERTIFICADO"));
                certificado.setNomeCertificado(rs.getString("NOME_CERTIFICADO"));
                certificado.setDescricao(rs.getString("DESCRICAO"));
                certificado.setMetodoObter(rs.getString("METODO_OBTER"));
                certificados.add(certificado);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Certificados por ID_USUARIO: " + e.getMessage());
        }
        return certificados;
    }
}
