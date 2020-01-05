/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Dao {

    private Connection connection;
    private final ConnectionManager connectionManager;
    private Statement statement;
    private ResultSet resultSet;

    public Dao() {
        connectionManager = new ConnectionManager();
    }

    public List<Admin> getAll() {
        connection = ConnectionManager.getConnection();
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT * FROM admin";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                Admin admin = new Admin(resultSet.getString("username"), resultSet.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admins;
    }

}
