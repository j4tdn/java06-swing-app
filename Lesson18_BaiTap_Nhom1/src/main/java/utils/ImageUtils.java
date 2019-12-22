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
 * @author SMILE ^^
 */
public class ImageUtils {

    private static final String TITLE_DEFAULT_IMAGE = "D:\\Java\\images\\64px_flower.png";

    private ImageUtils() {
    }

    public static Image load(String path) {
        if (path == null || path.isEmpty()) {
            path = TITLE_DEFAULT_IMAGE;
        }
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }

}
