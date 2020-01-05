package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author huyvi
 */
public class ImageUtils {
    
    private static final String TITLE_DEFAULT_IMAGE = "E:\\workspace\\swing\\Lesson18\\src\\main\\java\\images\\64px_flower.png";

    private ImageUtils() {
    }
    
    public static Image load(String path){
        if(path == null || path.isEmpty()){
            path = TITLE_DEFAULT_IMAGE;
        }
        
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    };
    
    public static ImageIcon loadImageIcon(String path, int width, int height){
        Image image = load(path).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    };
    
    public static ImageIcon loadImageIcon(String path){
        Image image = load(path);
        return new ImageIcon(image);
    };
}
