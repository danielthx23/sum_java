package br.com.fiap.dao;

import br.com.fiap.to.EnderecoTO;
import br.com.fiap.to.TelefoneTO;
import br.com.fiap.to.EmailTO;
import br.com.fiap.to.FornecedorTO;
import br.com.fiap.to.ConsumidorTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository {
        public UsuarioTO findById(Long id) {
            UsuarioTO usuario = null;
            String sqlUsuario = "SELECT * FROM SUM_USUARIO WHERE ID_USUARIO = ?";
            String sqlEnderecos = "SELECT * FROM SUM_ENDERECO WHERE ID_USUARIO = ?";
            String sqlTelefones = "SELECT * FROM SUM_TELEFONE WHERE ID_USUARIO = ?";
            String sqlEmails = "SELECT * FROM SUM_EMAIL WHERE ID_USUARIO = ?";
            String sqlConsumidor = "SELECT * FROM SUM_CONSUMIDOR WHERE ID_USUARIO = ?";
            String sqlFornecedor = "SELECT * FROM SUM_FORNECEDOR WHERE ID_USUARIO = ?";

            try (PreparedStatement psUsuario = getConnection().prepareStatement(sqlUsuario);
                 PreparedStatement psEnderecos = getConnection().prepareStatement(sqlEnderecos);
                 PreparedStatement psTelefones = getConnection().prepareStatement(sqlTelefones);
                 PreparedStatement psEmails = getConnection().prepareStatement(sqlEmails);
                 PreparedStatement psConsumidor = getConnection().prepareStatement(sqlConsumidor);
                 PreparedStatement psFornecedor = getConnection().prepareStatement(sqlFornecedor)) {

                psUsuario.setLong(1, id);
                ResultSet rsUsuario = psUsuario.executeQuery();
                if (rsUsuario.next()) {
                    usuario = new UsuarioTO();
                    usuario.setIdUsuario(rsUsuario.getLong("ID_USUARIO"));
                    usuario.setNomeUsuario(rsUsuario.getString("NOME_USUARIO"));
                    usuario.setRazaoSocial(rsUsuario.getString("RAZAO_SOCIAL"));
                    usuario.setCnpj(rsUsuario.getString("CNPJ"));
                    usuario.setCpf(rsUsuario.getString("CPF"));
                    usuario.setTipoConta(rsUsuario.getString("TIPO_CONTA"));
                    usuario.setImagemFoto(rsUsuario.getString("IMAGEM_FOTO"));
                    usuario.setNumeroSenha(rsUsuario.getString("NUMERO_SENHA"));
                    usuario.setValorToken(rsUsuario.getString("VALOR_TOKEN"));
                    usuario.setDataCadastro(rsUsuario.getTimestamp("DATA_CADASTRO"));

                    psEnderecos.setLong(1, id);
                    ResultSet rsEnderecos = psEnderecos.executeQuery();
                    ArrayList<EnderecoTO> enderecos = new ArrayList<>();
                    while (rsEnderecos.next()) {
                        EnderecoTO endereco = new EnderecoTO();
                        endereco.setIdEndereco(rsEnderecos.getLong("ID_ENDERECO"));
                        endereco.setNomeRua(rsEnderecos.getString("NOME_RUA"));
                        endereco.setNomeCidade(rsEnderecos.getString("NOME_CIDADE"));
                        endereco.setNumeroEndereco(rsEnderecos.getInt("NUMERO_ENDERECO"));  
                        endereco.setNomeBairro(rsEnderecos.getString("NOME_BAIRRO"));
                        endereco.setNomeEstado(rsEnderecos.getString("NOME_ESTADO"));    
                        endereco.setNumeroCep(rsEnderecos.getString("NUMERO_CEP"));
                        endereco.setComplemento(rsEnderecos.getString("COMPLEMENTO"));
                        enderecos.add(endereco);
                    }
                    usuario.setEnderecos(enderecos);

                    psTelefones.setLong(1, id);
                    ResultSet rsTelefones = psTelefones.executeQuery();
                    ArrayList<TelefoneTO> telefones = new ArrayList<>();
                    while (rsTelefones.next()) {
                        TelefoneTO telefone = new TelefoneTO();
                        telefone.setIdTelefone(rsTelefones.getLong("ID_TELEFONE"));
                        telefone.setNumeroTelefone(rsTelefones.getString("NUMERO_TELEFONE"));
                        telefone.setDDD(rsTelefones.getString("DDD"));
                        telefone.setDDI(rsTelefones.getString("DDI"));
                        telefone.setLembrete(rsTelefones.getString("LEMBRETE"));
                        telefones.add(telefone);
                    }
                    usuario.setTelefones(telefones);

                    psEmails.setLong(1, id);
                    ResultSet rsEmails = psEmails.executeQuery();
                    ArrayList<EmailTO> emails = new ArrayList<>();
                    while (rsEmails.next()) {
                        EmailTO email = new EmailTO();
                        email.setIdEmail(rsEmails.getLong("ID_EMAIL"));
                        email.setEmail(rsEmails.getString("EMAIL"));
                        emails.add(email);
                    }
                    usuario.setEmails(emails);

                    if ("CONSUMIDOR".equalsIgnoreCase(usuario.getTipoConta())) {
                        psConsumidor.setLong(1, id);
                        ResultSet rsConsumidor = psConsumidor.executeQuery();
                        if (rsConsumidor.next()) {
                            ConsumidorTO consumidor = new ConsumidorTO();
                            consumidor.setConsumidorId(rsConsumidor.getLong("ID_CONSUMIDOR"));
                            consumidor.setTarifa(rsConsumidor.getFloat("TARIFA"));
                            consumidor.setNumeroMedidor(rsConsumidor.getString("NUMERO_MEDIDOR"));
                            consumidor.setConsumoEnergetico(rsConsumidor.getFloat("CONSUMO_ENERGETICO"));
                            consumidor.setTipoConsumo(rsConsumidor.getString("TIPO_CONSUMO"));
                            consumidor.setClasseConsumo(rsConsumidor.getString("CLASSE_CONSUMO"));
                            consumidor.setConsumoMes(rsConsumidor.getFloat("CONSUMO_MES"));
                            consumidor.setUltimaLeitura(rsConsumidor.getTimestamp("ULTIMA_LEITURA"));
                            usuario.setConsumidor(consumidor);
                        }
                    } else if ("FORNECEDOR".equalsIgnoreCase(usuario.getTipoConta())) {
                        psFornecedor.setLong(1, id);
                        ResultSet rsFornecedor = psFornecedor.executeQuery();
                        if (rsFornecedor.next()) {
                            FornecedorTO fornecedor = new FornecedorTO();
                            fornecedor.setIdFornecedor(rsFornecedor.getLong("ID_FORNECEDOR"));
                            fornecedor.setLicenciatura(rsFornecedor.getString("LICENCIATURA"));
                            fornecedor.setCapacidade(rsFornecedor.getFloat("CAPACIDADE"));
                            fornecedor.setStatus(rsFornecedor.getString("STATUS"));
                            fornecedor.setDataOperacao(rsFornecedor.getTimestamp("DATA_OPERACAO"));
                            fornecedor.setEnergiaPrimaria(rsFornecedor.getString("ENERGIA_PRIMARIA"));
                            fornecedor.setRegiao(rsFornecedor.getString("REGIAO"));
                            usuario.setFornecedor(fornecedor);
                        }
                    }
                }

            } catch (SQLException e) {
                System.out.println("Erro ao buscar o usuário: " + e.getMessage());
            }

            return usuario;
        }

    public UsuarioTO save(UsuarioTO usuario) {
        String sqlUsuario = "INSERT INTO SUM_USUARIO (NOME_USUARIO, RAZAO_SOCIAL, CNPJ, CPF, TIPO_CONTA, IMAGEM_FOTO, NUMERO_SENHA, VALOR_TOKEN, DATA_CADASTRO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        String sqlEndereco = "INSERT INTO SUM_ENDERECO (NOME_RUA, NOME_CIDADE, NUMERO_ENDERECO, NOME_BAIRRO, NOME_ESTADO, NUMERO_CEP, COMPLEMENTO, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlTelefone = "INSERT INTO SUM_TELEFONE (NUMERO_TELEFONE, DDD, DDI, LEMBRETE, ID_USUARIO) VALUES (?, ?, ?, ?, ?)";
        String sqlEmail = "INSERT INTO SUM_EMAIL (EMAIL, ID_USUARIO) VALUES (?, ?)";
        String sqlConsumidor = "INSERT INTO SUM_CONSUMIDOR (TARIFA, NUMERO_MEDIDOR, CONSUMO_ENERGETICO, TIPO_CONSUMO, CLASSE_CONSUMO, CONSUMO_MES, ULTIMA_LEITURA, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlFornecedor = "INSERT INTO SUM_FORNECEDOR (LICENCIATURA, CAPACIDADE, STATUS, DATA_OPERACAO, ENERGIA_PRIMARIA, REGIAO, ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psUsuario = getConnection().prepareStatement(sqlUsuario);
             PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
             PreparedStatement psTelefone = getConnection().prepareStatement(sqlTelefone);
             PreparedStatement psEmail = getConnection().prepareStatement(sqlEmail);
             PreparedStatement psConsumidor = getConnection().prepareStatement(sqlConsumidor);
             PreparedStatement psFornecedor = getConnection().prepareStatement(sqlFornecedor)) {

            psUsuario.setString(1, usuario.getNomeUsuario());
            psUsuario.setString(2, usuario.getRazaoSocial());
            psUsuario.setString(3, usuario.getCnpj());
            psUsuario.setString(4, usuario.getCpf());
            psUsuario.setString(5, usuario.getTipoConta());
            psUsuario.setString(6, usuario.getImagemFoto());
            psUsuario.setString(7, usuario.getNumeroSenha());
            psUsuario.setString(8, usuario.getValorToken());
            int affectedRows = psUsuario.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("O preenchimento de usuário falhou.");
            }

            String sqlUltimoId = "SELECT ID_USUARIO FROM SUM_USUARIO ORDER BY ID_USUARIO DESC";
            Long usuarioId;
            try (PreparedStatement psLastId = getConnection().prepareStatement(sqlUltimoId);
                 ResultSet rsUltimoId = psLastId.executeQuery()) {
                if (rsUltimoId.next()) {
                    usuario.setIdUsuario(rsUltimoId.getLong("ID_USUARIO"));
                } else {
                    throw new SQLException("Não foi possivel recuperar o ultimo ID de Usuário");
                }
            }

            if (usuario.getEnderecos() != null) {
                for (EnderecoTO endereco : usuario.getEnderecos()) {
                    psEndereco.setString(1, endereco.getNomeRua());
                    psEndereco.setString(2, endereco.getNomeCidade());
                    psEndereco.setInt(3, endereco.getNumeroEndereco());
                    psEndereco.setString(4, endereco.getNomeBairro());
                    psEndereco.setString(5, endereco.getNomeEstado());
                    psEndereco.setString(6, endereco.getNumeroCep());
                    psEndereco.setString(7, endereco.getComplemento());
                    psEndereco.setLong(8, usuario.getIdUsuario());
                    psEndereco.executeUpdate();
                }
            }

            if (usuario.getTelefones() != null) {
                for (TelefoneTO telefone : usuario.getTelefones()) {
                    psTelefone.setString(1, telefone.getNumeroTelefone());
                    psTelefone.setString(2, telefone.getDDD());
                    psTelefone.setString(3, telefone.getDDI());
                    psTelefone.setString(4, telefone.getLembrete());
                    psTelefone.setLong(5, usuario.getIdUsuario());
                    psTelefone.executeUpdate();
                }
            }

            if (usuario.getEmails() != null) {
                for (EmailTO email : usuario.getEmails()) {
                    psEmail.setString(1, email.getEmail());
                    psEmail.setLong(2, usuario.getIdUsuario());
                    psEmail.executeUpdate();
                }
            }

            if ("CONSUMIDOR".equalsIgnoreCase(usuario.getTipoConta()) && usuario.getConsumidor() != null) {
                ConsumidorTO consumidor = usuario.getConsumidor();
                psConsumidor.setFloat(1, consumidor.getTarifa());
                psConsumidor.setString(2, consumidor.getNumeroMedidor());
                psConsumidor.setFloat(3, consumidor.getConsumoEnergetico());
                psConsumidor.setString(4, consumidor.getTipoConsumo());
                psConsumidor.setString(5, consumidor.getClasseConsumo());
                psConsumidor.setFloat(6, consumidor.getConsumoMes());
                psConsumidor.setTimestamp(7, consumidor.getUltimaLeitura());
                psConsumidor.setLong(8, usuario.getIdUsuario());
                psConsumidor.executeUpdate();
            } else if ("FORNECEDOR".equalsIgnoreCase(usuario.getTipoConta()) && usuario.getFornecedor() != null) {
                FornecedorTO fornecedor = usuario.getFornecedor();
                psFornecedor.setString(1, fornecedor.getLicenciatura());
                psFornecedor.setFloat(2, fornecedor.getCapacidade());
                psFornecedor.setString(3, fornecedor.getStatus());
                psFornecedor.setTimestamp(4, fornecedor.getDataOperacao());
                psFornecedor.setString(5, fornecedor.getEnergiaPrimaria());
                psFornecedor.setString(6, fornecedor.getRegiao());
                psFornecedor.setLong(7, usuario.getIdUsuario());
                psFornecedor.executeUpdate();
            }

            return usuario;
        } catch (SQLException e) {
            System.out.println("Error ao salvar usuário: " + e.getMessage());
            return null;
        }
    }

    public UsuarioTO update(UsuarioTO usuario) {
        String sqlUsuario = "UPDATE SUM_USUARIO SET NOME_USUARIO = ?, RAZAO_SOCIAL = ?, CNPJ = ?, CPF = ?, TIPO_CONTA = ?, IMAGEM_FOTO = ?, NUMERO_SENHA = ?, VALOR_TOKEN = ? " +
                "WHERE ID_USUARIO = ?";
        String sqlEndereco = "UPDATE SUM_ENDERECO SET NOME_RUA = ?, NOME_CIDADE = ?, NUMERO_ENDERECO = ?, NOME_BAIRRO = ?, NOME_ESTADO = ?, NUMERO_CEP = ?, COMPLEMENTO = ? " +
                "WHERE ID_USUARIO = ? AND ID_ENDERECO = ?";
        String sqlTelefone = "UPDATE SUM_TELEFONE SET NUMERO_TELEFONE = ?, DDD = ?, DDI = ?, LEMBRETE = ? WHERE ID_USUARIO = ? AND ID_TELEFONE = ?";
        String sqlEmail = "UPDATE SUM_EMAIL SET EMAIL = ? WHERE ID_USUARIO = ? AND ID_EMAIL = ?";
        String sqlConsumidor = "UPDATE SUM_CONSUMIDOR SET TARIFA = ?, NUMERO_MEDIDOR = ?, CONSUMO_ENERGETICO = ?, TIPO_CONSUMO = ?, CLASSE_CONSUMO = ?, CONSUMO_MES = ?, ULTIMA_LEITURA = ? " +
                "WHERE ID_USUARIO = ?";
        String sqlFornecedor = "UPDATE SUM_FORNECEDOR SET LICENCIATURA = ?, CAPACIDADE = ?, STATUS = ?, DATA_OPERACAO = ?, ENERGIA_PRIMARIA = ?, REGIAO = ? " +
                "WHERE ID_USUARIO = ?";

        try (PreparedStatement psUsuario = getConnection().prepareStatement(sqlUsuario);
             PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
             PreparedStatement psTelefone = getConnection().prepareStatement(sqlTelefone);
             PreparedStatement psEmail = getConnection().prepareStatement(sqlEmail);
             PreparedStatement psConsumidor = getConnection().prepareStatement(sqlConsumidor);
             PreparedStatement psFornecedor = getConnection().prepareStatement(sqlFornecedor)) {

            // Update user details
            psUsuario.setString(1, usuario.getNomeUsuario());
            psUsuario.setString(2, usuario.getRazaoSocial());
            psUsuario.setString(3, usuario.getCnpj());
            psUsuario.setString(4, usuario.getCpf());
            psUsuario.setString(5, usuario.getTipoConta());
            psUsuario.setString(6, usuario.getImagemFoto());
            psUsuario.setString(7, usuario.getNumeroSenha());
            psUsuario.setString(8, usuario.getValorToken());
            psUsuario.setLong(9, usuario.getIdUsuario());
            psUsuario.executeUpdate();
            
            if (usuario.getEnderecos() != null) {
                for (EnderecoTO endereco : usuario.getEnderecos()) {
                    psEndereco.setString(1, endereco.getNomeRua());
                    psEndereco.setString(2, endereco.getNomeCidade());
                    psEndereco.setInt(3, endereco.getNumeroEndereco());
                    psEndereco.setString(4, endereco.getNomeBairro());
                    psEndereco.setString(5, endereco.getNomeEstado());
                    psEndereco.setString(6, endereco.getNumeroCep());
                    psEndereco.setString(7, endereco.getComplemento());
                    psEndereco.setLong(8, usuario.getIdUsuario());
                    psEndereco.setLong(9, endereco.getIdEndereco());
                    psEndereco.executeUpdate();
                }
            }
            
            if (usuario.getTelefones() != null) {
                for (TelefoneTO telefone : usuario.getTelefones()) {
                    psTelefone.setString(1, telefone.getNumeroTelefone());
                    psTelefone.setString(2, telefone.getDDD());
                    psTelefone.setString(3, telefone.getDDI());
                    psTelefone.setString(4, telefone.getLembrete());
                    psTelefone.setLong(5, usuario.getIdUsuario());
                    psTelefone.setLong(6, telefone.getIdTelefone());
                    psTelefone.executeUpdate();
                }
            }
            
            if (usuario.getEmails() != null) {
                for (EmailTO email : usuario.getEmails()) {
                    psEmail.setString(1, email.getEmail());
                    psEmail.setLong(2, usuario.getIdUsuario());
                    psEmail.setLong(3, email.getIdEmail());
                    psEmail.executeUpdate();
                }
            }
            
            if ("CONSUMIDOR".equalsIgnoreCase(usuario.getTipoConta()) && usuario.getConsumidor() != null) {
                ConsumidorTO consumidor = usuario.getConsumidor();
                psConsumidor.setFloat(1, consumidor.getTarifa());
                psConsumidor.setString(2, consumidor.getNumeroMedidor());
                psConsumidor.setFloat(3, consumidor.getConsumoEnergetico());
                psConsumidor.setString(4, consumidor.getTipoConsumo());
                psConsumidor.setString(5, consumidor.getClasseConsumo());
                psConsumidor.setFloat(6, consumidor.getConsumoMes());
                psConsumidor.setTimestamp(7, consumidor.getUltimaLeitura());
                psConsumidor.setLong(8, usuario.getIdUsuario());
                psConsumidor.executeUpdate();
            } else if ("FORNECEDOR".equalsIgnoreCase(usuario.getTipoConta()) && usuario.getFornecedor() != null) {
                FornecedorTO fornecedor = usuario.getFornecedor();
                psFornecedor.setString(1, fornecedor.getLicenciatura());
                psFornecedor.setFloat(2, fornecedor.getCapacidade());
                psFornecedor.setString(3, fornecedor.getStatus());
                psFornecedor.setTimestamp(4, fornecedor.getDataOperacao());
                psFornecedor.setString(5, fornecedor.getEnergiaPrimaria());
                psFornecedor.setString(6, fornecedor.getRegiao());
                psFornecedor.setLong(7, usuario.getIdUsuario());
                psFornecedor.executeUpdate();
            }

            return usuario;
        } catch (SQLException e) {
            System.out.println("Error ao atualizar usuário: " + e.getMessage());
            return null;
        }
    }

}
