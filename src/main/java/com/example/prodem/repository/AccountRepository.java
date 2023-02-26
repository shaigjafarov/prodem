package com.example.prodem.repository;

import com.example.prodem.model.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountRepository {


    public Account getAccountById(long id) {
        Account account = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/mydb";
            Connection connection = DriverManager.getConnection(url, "postgres", "postgre123");
            String sql = "SELECT * FROM myschema.accounts where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id1 = rs.getInt("id");
                String name1 = rs.getString("name");
                BigDecimal balance = rs.getBigDecimal("balance");
                account = new Account(id1, name1, balance);
            }


            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return account;


    }

    public Account saveAccount(Account newAccount) {

        int id=0;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/mydb";
            Connection connection = DriverManager.getConnection(url, "postgres", "postgre123");
            String sql = "insert into myschema.accounts values(nextval('myschema.accounts_id_seq'), ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newAccount.getName());
            preparedStatement.setBigDecimal(2, newAccount.getBalance());
           preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            // Get the ID of the newly inserted row
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return getAccountById(id);




    }
}
