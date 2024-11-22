package br.com.fiap.dao;

import br.com.fiap.to.FornecedorTO;
import br.com.fiap.to.FornecimentoTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecimentoDAO extends Repository {

    public List<FornecimentoTO> findAll() {
        List<FornecimentoTO> fornecimentos = new ArrayList<>();
        String sql = "SELECT f.ID_FORNECIMENTO, f.TIPO_CONTRATO, f.PRECO_KWH, f.DATA_VENCIMENTO, " +
                "f.TIPO_ENERGIA, f.PROCESSO_OBTENCAO, f.FORNECIMENTO_IMAGEM," +
                "fn.ID_FORNECEDOR, fn.LICENCIATURA, fn.CAPACIDADE, fn.STATUS, fn.DATA_OPERACAO, " +
                "fn.ENERGIA_PRIMARIA, fn.REGIAO, " +
                "u.ID_USUARIO, u.NOME_USUARIO, u.RAZAO_SOCIAL, u.CNPJ, u.CPF, u.TIPO_CONTA, " +
                "u.IMAGEM_FOTO, u.NUMERO_SENHA, u.VALOR_TOKEN, u.DATA_CADASTRO " +
                "FROM SUM_FORNECIMENTO f " +
                "JOIN SUM_FORNECEDOR fn ON f.ID_FORNECEDOR = fn.ID_FORNECEDOR " +
                "JOIN SUM_USUARIO u ON fn.ID_USUARIO = u.ID_USUARIO";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FornecimentoTO fornecimento = new FornecimentoTO();
                fornecimento.setIdFornecimento(rs.getLong("ID_FORNECIMENTO"));
                fornecimento.setTipoContrato(rs.getString("TIPO_CONTRATO"));
                fornecimento.setPrecoKwh(rs.getDouble("PRECO_KWH"));
                fornecimento.setDataVencimento(rs.getTimestamp("DATA_VENCIMENTO"));
                fornecimento.setTipoEnergia(rs.getString("TIPO_ENERGIA"));
                fornecimento.setProcessoObtencao(rs.getString("PROCESSO_OBTENCAO"));
                fornecimento.setFornecimentoImagem(rs.getString("FORNECIMENTO_IMAGEM"));

                FornecedorTO fornecedor = new FornecedorTO();
                fornecedor.setIdFornecedor(rs.getLong("ID_FORNECEDOR"));
                fornecedor.setLicenciatura(rs.getString("LICENCIATURA"));
                fornecedor.setCapacidade(rs.getFloat("CAPACIDADE"));
                fornecedor.setStatus(rs.getString("STATUS"));
                fornecedor.setDataOperacao(rs.getTimestamp("DATA_OPERACAO"));
                fornecedor.setEnergiaPrimaria(rs.getString("ENERGIA_PRIMARIA"));
                fornecedor.setRegiao(rs.getString("REGIAO"));
                fornecimento.setFornecedor(fornecedor);

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
                fornecedor.setUsuario(usuario);

                fornecimentos.add(fornecimento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecimentos: " + e.getMessage());
        }
        return fornecimentos;
    }

    public List<FornecimentoTO> findByUsuarioId(Long usuarioId) {
        List<FornecimentoTO> fornecimentos = new ArrayList<>();
        String sql = "SELECT f.ID_FORNECIMENTO, f.TIPO_CONTRATO, f.PRECO_KWH, f.DATA_VENCIMENTO, " +
                "f.TIPO_ENERGIA, f.PROCESSO_OBTENCAO, f.FORNECIMENTO_IMAGEM," +
                "fn.ID_FORNECEDOR, fn.LICENCIATURA, fn.CAPACIDADE, fn.STATUS, fn.DATA_OPERACAO, fn.ENERGIA_PRIMARIA, fn.REGIAO, " +
                "u.ID_USUARIO, u.NOME_USUARIO, u.RAZAO_SOCIAL, u.CNPJ, u.CPF, u.TIPO_CONTA, " +
                "u.IMAGEM_FOTO, u.NUMERO_SENHA, u.VALOR_TOKEN, u.DATA_CADASTRO " +
                "FROM SUM_FORNECIMENTO f " +
                "JOIN SUM_FORNECEDOR fn ON f.ID_FORNECEDOR = fn.ID_FORNECEDOR " +
                "JOIN SUM_USUARIO u ON fn.ID_USUARIO = u.ID_USUARIO " +
                "WHERE u.ID_USUARIO = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FornecimentoTO fornecimento = new FornecimentoTO();
                fornecimento.setIdFornecimento(rs.getLong("ID_FORNECIMENTO"));
                fornecimento.setTipoContrato(rs.getString("TIPO_CONTRATO"));
                fornecimento.setPrecoKwh(rs.getDouble("PRECO_KWH"));
                fornecimento.setDataVencimento(rs.getTimestamp("DATA_VENCIMENTO"));
                fornecimento.setTipoEnergia(rs.getString("TIPO_ENERGIA"));
                fornecimento.setProcessoObtencao(rs.getString("PROCESSO_OBTENCAO"));
                fornecimento.setFornecimentoImagem(rs.getString("FORNECIMENTO_IMAGEM"));

                FornecedorTO fornecedor = new FornecedorTO();
                fornecedor.setIdFornecedor(rs.getLong("ID_FORNECEDOR"));
                fornecedor.setLicenciatura(rs.getString("LICENCIATURA"));
                fornecedor.setCapacidade(rs.getFloat("CAPACIDADE"));
                fornecedor.setStatus(rs.getString("STATUS"));
                fornecedor.setDataOperacao(rs.getTimestamp("DATA_OPERACAO"));
                fornecedor.setEnergiaPrimaria(rs.getString("ENERGIA_PRIMARIA"));
                fornecedor.setRegiao(rs.getString("REGIAO"));
                fornecimento.setFornecedor(fornecedor);

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
                fornecedor.setUsuario(usuario);

                fornecimentos.add(fornecimento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecimentos por ID de usuário: " + e.getMessage());
        }
        return fornecimentos;
    }

    public FornecimentoTO findById(Long idFornecimento) {
        FornecimentoTO fornecimento = null;  // Start with null, since no record found means no object.
        String sql = "SELECT f.ID_FORNECIMENTO, f.TIPO_CONTRATO, f.PRECO_KWH, f.DATA_VENCIMENTO, " +
                "f.TIPO_ENERGIA, f.PROCESSO_OBTENCAO, f.FORNECIMENTO_IMAGEM," +
                "fn.ID_FORNECEDOR, fn.LICENCIATURA, fn.CAPACIDADE, fn.STATUS, fn.DATA_OPERACAO, " +
                "fn.ENERGIA_PRIMARIA, fn.REGIAO, " +
                "u.ID_USUARIO, u.NOME_USUARIO, u.RAZAO_SOCIAL, u.CNPJ, u.CPF, u.TIPO_CONTA, " +
                "u.IMAGEM_FOTO, u.NUMERO_SENHA, u.VALOR_TOKEN, u.DATA_CADASTRO " +
                "FROM SUM_FORNECIMENTO f " +
                "JOIN SUM_FORNECEDOR fn ON f.ID_FORNECEDOR = fn.ID_FORNECEDOR " +
                "JOIN SUM_USUARIO u ON fn.ID_USUARIO = u.ID_USUARIO " +
                "WHERE f.ID_FORNECIMENTO = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idFornecimento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fornecimento = new FornecimentoTO();

                fornecimento.setIdFornecimento(rs.getLong("ID_FORNECIMENTO"));
                fornecimento.setTipoContrato(rs.getString("TIPO_CONTRATO"));
                fornecimento.setPrecoKwh(rs.getDouble("PRECO_KWH"));
                fornecimento.setDataVencimento(rs.getTimestamp("DATA_VENCIMENTO"));
                fornecimento.setTipoEnergia(rs.getString("TIPO_ENERGIA"));
                fornecimento.setProcessoObtencao(rs.getString("PROCESSO_OBTENCAO"));
                fornecimento.setFornecimentoImagem(rs.getString("FORNECIMENTO_IMAGEM"));

                FornecedorTO fornecedor = new FornecedorTO();
                fornecedor.setIdFornecedor(rs.getLong("ID_FORNECEDOR"));
                fornecedor.setLicenciatura(rs.getString("LICENCIATURA"));
                fornecedor.setCapacidade(rs.getFloat("CAPACIDADE"));
                fornecedor.setStatus(rs.getString("STATUS"));
                fornecedor.setDataOperacao(rs.getTimestamp("DATA_OPERACAO"));
                fornecedor.setEnergiaPrimaria(rs.getString("ENERGIA_PRIMARIA"));
                fornecedor.setRegiao(rs.getString("REGIAO"));
                fornecimento.setFornecedor(fornecedor);

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
                fornecedor.setUsuario(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecimento por ID: " + e.getMessage());
        }

        return fornecimento;
    }


    public FornecimentoTO update(FornecimentoTO fornecimento) {
        String sql = "UPDATE SUM_FORNECIMENTO SET TIPO_CONTRATO = ?, PRECO_KWH = ?, DATA_VENCIMENTO = ?, " +
                "TIPO_ENERGIA = ?, PROCESSO_OBTENCAO = ?, FORNECIMENTO_IMAGEM = ? WHERE ID_FORNECIMENTO = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, fornecimento.getTipoContrato());
            ps.setDouble(2, fornecimento.getPrecoKwh());
            ps.setTimestamp(3, fornecimento.getDataVencimento());
            ps.setString(4, fornecimento.getTipoEnergia());
            ps.setString(5, fornecimento.getProcessoObtencao());
            ps.setString(6, fornecimento.getFornecimentoImagem());
            ps.setLong(7, fornecimento.getIdFornecimento());
            ps.executeUpdate();

            return fornecimento;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar fornecimento: " + e.getMessage());
            return null;
        }
    }

    public FornecimentoTO save(FornecimentoTO fornecimento) {
        String sql = "INSERT INTO SUM_FORNECIMENTO (TIPO_CONTRATO, PRECO_KWH, DATA_VENCIMENTO, TIPO_ENERGIA, PROCESSO_OBTENCAO, ID_FORNECEDOR, FORNECIMENTO_IMAGEM) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, fornecimento.getTipoContrato());
            ps.setDouble(2, fornecimento.getPrecoKwh());
            ps.setTimestamp(3, fornecimento.getDataVencimento());
            ps.setString(4, fornecimento.getTipoEnergia());
            ps.setString(5, fornecimento.getProcessoObtencao());
            ps.setLong(6, fornecimento.getFornecedor().getIdFornecedor());
            ps.setString(7, fornecimento.getFornecimentoImagem());

            ps.executeUpdate();
            return fornecimento;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar fornecimento: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(Long idFornecimento) {
        String sql = "DELETE FROM SUM_FORNECIMENTO WHERE ID_FORNECIMENTO = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idFornecimento);
            if (ps.executeUpdate() > 0 ) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar fornecimento: " + e.getMessage());
            return false;
        }
    }
}