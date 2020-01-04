/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private ConfigurationProvider provider;

    public ConnectionManagerImpl() {
        provider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {

        Properties props = provider.getProperties();

        Connection conn = null;
        try {
            Class.forName(props.getProperty("driverClass"));
            conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),
                    props.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
