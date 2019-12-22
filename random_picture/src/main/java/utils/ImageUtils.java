/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author huyvi
 */
public class ImageUtils {
    
    private static final String DEFAULT_PATH = "D:\\Java\\truncate_app\\src\\main\\java\\images\\48px_love.png";

    public ImageUtils() {
    }
    
    public static Image loadImage(String path){
        return loadImageIcon(path).getImage();
    }
    
    public static ImageIcon loadImageIcon(String path){
        if(path == null || path.isEmpty()){
            path = DEFAULT_PATH;
        }
        
        return new ImageIcon(path);
    }
}
