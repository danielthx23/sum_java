package br.com.fiap.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection conexao;
    private String url;
    private String user;
    private String pass;
    private String driver;

    public ConnectionFactory(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }

    public static ConnectionFactory getInstance() {
        if (instance != null) {
            return instance;
        }

        Properties prop = new Properties();
        try (FileInputStream file = new FileInputStream("./src/main/resources/application.properties")) {
            prop.load(file);
        } catch (IOException e) {
            System.out.println("Erro ao carregar as propriedades: " + e.getMessage());
            System.exit(1);
        }

        String url = prop.getProperty("datasource.url");
        String user = prop.getProperty("datasource.username");
        String pass = prop.getProperty("datasource.password");
        String driver = prop.getProperty("datasource.driver-class-name");

        url = substituirVariaveisAmbiente(url);
        user = substituirVariaveisAmbiente(user);
        pass = substituirVariaveisAmbiente(pass);
        driver = substituirVariaveisAmbiente(driver);

        if (url == null || user == null || pass == null || driver == null) {
            System.out.println("Erro: Propriedades necessárias para a conexão com o banco de dados ausentes.");
            System.exit(1);
        }

        instance = new ConnectionFactory(url, user, pass, driver);
        return instance;
    }

    private static String substituirVariaveisAmbiente(String propriedade) {
        if (propriedade == null) return null;
        propriedade = propriedade.replace("${ORACLEHOST}", System.getenv("ORACLEHOST"));
        propriedade = propriedade.replace("${ORACLEPORT}", System.getenv("ORACLEPORT"));
        propriedade = propriedade.replace("${ORACLESID}", System.getenv("ORACLESID"));
        propriedade = propriedade.replace("${ORACLEUSERNAME}", System.getenv("ORACLEUSERNAME"));
        propriedade = propriedade.replace("${ORACLEPASSWORD}", System.getenv("ORACLEPASSWORD"));
        return propriedade;
    }

    public Connection getConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                return this.conexao;
            }

            if (this.getDriver() == null || this.getDriver().isEmpty()) {
                throw new ClassNotFoundException("Classe do driver nula ou em branco");
            }
            if (this.getUrl() == null || this.getUrl().isEmpty()) {
                throw new SQLException("URL de conexão nula ou em branco");
            }
            if (this.getUser() == null || this.getUser().isEmpty()) {
                throw new SQLException("Usuário nulo ou em branco");
            }

            Class.forName(this.getDriver());
            this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro (ClassNotFoundException): " + e.getMessage());
            System.exit(1);
        }
        return conexao;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDriver() {
        return driver;
    }
}
