/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SMILE ^^
 */
public class ConfigurationProviderImpl implements ConfigurationProvider {

    private final String CONFIG_FILE = "C:\\Users\\HP\\Desktop\\java06-swing-app\\Lesson19_BaiTap_Nhom1\\src\\main\\java\\connection\\config.properties";

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        File file = new File(CONFIG_FILE);
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            props.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return props;
    }

}
