/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.security.auth.login.Configuration;

/**
 *
 * @author Admin
 */
public class ConfigurationProviderImpl implements ConfigurationProvider{

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
		File file = new File("config.properties");
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			props.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
    }
    
}
