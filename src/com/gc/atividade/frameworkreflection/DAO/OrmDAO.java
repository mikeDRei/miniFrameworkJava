package com.gc.atividade.frameworkreflection.DAO;

import com.gc.atividade.frameworkreflection.ConnectionFactory;
import com.gc.atividade.frameworkreflection.ValidatorJavaTypeSqlType.Validator;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrmDAO {

    Connection con = new ConnectionFactory().getConexaoMySQL();

    public OrmDAO() {
        ConnectionFactory.getConexaoMySQL();

    }

    public <T> void createTable(Class<T> classGenericType) {
        try {

            System.out.println(ConnectionFactory.statusConection());

            Validator validator = new Validator();
            Field FieldList[] = classGenericType.getDeclaredFields();

            String tableCreate = "CREATE TABLE IF NOT EXISTS " + classGenericType.getSimpleName() + "(";
            tableCreate += "" + "\n" + FieldList[1 - 1].getName() + " "
                    + validator.validatorConversor(FieldList[1 - 1].getType()
                            .toString().replaceAll("class java.lang.", "")) + " AUTO_INCREMENT,";

            for (int index = 2; index <= FieldList.length; index++) {

                tableCreate += "" + "\n" + FieldList[index - 1].getName()
                        + " " + validator.validatorConversor(FieldList[index - 1]
                                .getType().toString().replaceAll("class java.lang.", "")) + ",";

            }
            tableCreate += "" + "\n" + "PRIMARY KEY(" + FieldList[1 - 1].getName() + ")";
            tableCreate += "\n )";
            PreparedStatement stmt = con.prepareStatement(tableCreate);
            stmt.execute();
            stmt.close();

            System.out.println(tableCreate);
            System.out.println("\n A tabela: " + classGenericType.getSimpleName()
                    + " foi criada com Sucesso! \n");

        } catch (SQLException e) {

            System.out.println("A tabela: " + classGenericType.getSimpleName()
                    + " não foi criada \n" + e);

        }
    }

    public <T> void save(Class<T> classGenericType, String lista) throws IllegalArgumentException, IllegalAccessException {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();

            String saveSql = "INSERT INTO " + classGenericType.getSimpleName() + "(";
            for (int index = 1; index <= FieldList.length; index++) {
                String parameterSql = FieldList[index - 1].getName();

                saveSql += "`" + parameterSql + "`,";
            }
            saveSql = saveSql.substring(0, saveSql.length() - 1);
            saveSql += ")";
            saveSql += "VALUES(";

            saveSql += lista + ")";
            PreparedStatement stmt = con.prepareStatement(saveSql);
            stmt.execute();
            stmt.close();

            System.out.println(saveSql);
            System.out.println("\n Salvo com sucesso! \n ");
        } catch (SQLException e) {
            System.out.println("Não foi possivel salvar: " + e);
        }
    }

    public <T> void delete(Class<T> classGenericType, Integer id) throws IllegalArgumentException, IllegalAccessException, SQLException {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            Validator validator = new Validator();
            String deleteSql = "DELETE FROM `" + classGenericType.getSimpleName() + "` WHERE "
                    + validator.validatorConversor(FieldList[1 - 1].getName()) + " = " + id;

            System.out.println(deleteSql);

            PreparedStatement stmt = con.prepareStatement(deleteSql);
            stmt.execute();
            stmt.close();
            System.out.println("\n Excluido com sucesso \n");
        } catch (SQLException e) {
            System.out.println("Não foi possivel Excluir: " + e);
        }

    }

    public <T> void findListAll(Class<T> classGenericType) {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            String findListSql = "SELECT * FROM `" + classGenericType.getSimpleName() + "`";
            System.out.println(findListSql);
            PreparedStatement stmt = con.prepareStatement(findListSql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n Resultado da listagem: \n");
            while (rs.next()) {
                for (int index = 1; index <= FieldList.length; index++) {

                    FieldList[1 - 1].getName();
                    System.out.print(FieldList[index - 1].getName() + ":");

                    System.out.print(rs.getString(index) + " ");

                }
                System.out.println("\n");
            }

            System.out.println("\n Listado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao listar: " + e);
        }
    }

    public <T> void findById(Class<T> classGenericType, Integer id) {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            String findListSql = "SELECT * FROM `" + classGenericType.getSimpleName() + "` WHERE ";
            findListSql += FieldList[1 - 1].getName() + " = " + id;
            System.out.println(findListSql);
            PreparedStatement stmt = con.prepareStatement(findListSql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n Resultado da listagem: \n");
            while (rs.next()) {
                for (int index = 1; index <= FieldList.length; index++) {

                    FieldList[1 - 1].getName();
                    System.out.print(FieldList[index - 1].getName() + ":");

                    System.out.print(rs.getString(index) + " ");

                }
                System.out.println("\n");
            }

            System.out.println("\n Listado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao listar: " + e);
        }
        System.out.println("\n");
    }

    public <T> void Update(Class<T> classGenericType, String atribute, Integer id, String value) {
        try {
            System.out.println(ConnectionFactory.statusConection());
            Field FieldList[] = classGenericType.getDeclaredFields();
            String UpdateSql = "UPDATE `" + classGenericType.getSimpleName() + "` SET `"
                    + atribute + "` = '" + value + "' WHERE `" + classGenericType.getSimpleName() + "`.`" + FieldList[1 - 1].getName() + "` = " + id;
            System.out.println(UpdateSql);
            PreparedStatement stmt = con.prepareStatement(UpdateSql);
            stmt.execute();
            stmt.close();
            System.out.println("\n Update efetuado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possivel efetuar o update: " + e);
        }
    }
}
