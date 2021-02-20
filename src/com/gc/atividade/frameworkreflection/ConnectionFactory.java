package com.gc.atividade.frameworkreflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static String status = "Não conectou...";

    public ConnectionFactory() {

    }

    public static Properties loadPropertiesFile() throws Exception {
        Properties prop = new Properties();
        File f = new File("jdbc.properties");
        InputStream in = new FileInputStream(f.getAbsolutePath());
        prop.load(in);
        in.close();
        return prop;
    }

    public static java.sql.Connection getConexaoMySQL() throws Exception {

        Connection connection = null;

        try {
            Properties prop = loadPropertiesFile();
            String driverName = prop.getProperty("MYSQLJDBC.driver");
            Class.forName(driverName);
            String serverName = prop.getProperty("MYSQLJDBC.ServerName");
            String mydatabase = prop.getProperty("MYSQLJDBC.DB");
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = prop.getProperty("MYSQLJDBC.username");
            String password = prop.getProperty("MYSQLJDBC.password");

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    public static String statusConection() {

        return status;

    }

    public static boolean FecharConexao() throws Exception {

        try {

            ConnectionFactory.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    public static java.sql.Connection ReiniciarConexao() throws Exception {

        FecharConexao();

        return ConnectionFactory.getConexaoMySQL();

    }

}
