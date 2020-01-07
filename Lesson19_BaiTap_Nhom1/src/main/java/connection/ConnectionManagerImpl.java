/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SMILE ^^
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private final ConfigurationProvider provider;

    public ConnectionManagerImpl() {
        provider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {
        Properties props = provider.getProperties();
        Connection connection = null;
        try {
            Class.forName(props.getProperty("driverClass"));
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("pass"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
