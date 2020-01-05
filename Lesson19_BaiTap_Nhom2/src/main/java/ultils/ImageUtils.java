/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageUtils {

    private static final String DEFAULT_ICON = "F:\\48px_like.png";

    private ImageUtils() {
    }

    public static Image load(String path) {
        if (path == null || path.isEmpty()) {
            path = DEFAULT_ICON;
        }
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }
    
    public static ImageIcon loadImageIcon(String path) {
        if (path == null || path.isEmpty()) {
            path = DEFAULT_ICON;
        }
       return new ImageIcon(path);
    }

    public static ImageIcon loadImageIcon(String path, int width, int height) {
        load(path).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(path);
    }

}
