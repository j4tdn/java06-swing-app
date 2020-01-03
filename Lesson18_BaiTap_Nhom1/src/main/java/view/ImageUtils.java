/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author qphan
 */
public class ImageUtils {
    
    private static final String TITLE_DEFAULT_IMAGE = "D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\64px_flower.png";

    private ImageUtils() {
    }
    
    public static Image load(String path) {
        if (path == null || path.isEmpty()) {
            path = TITLE_DEFAULT_IMAGE;
        }
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }
     public static ImageIcon load(String path,int width,int height){
        Image image = load(path).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon();
        imgIcon.setImage(image);
        return imgIcon;
    }
    
}
