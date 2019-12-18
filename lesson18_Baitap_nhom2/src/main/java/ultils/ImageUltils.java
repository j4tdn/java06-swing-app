/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageUltils {
    private static final String DEFAULT_ICON = null;
    
    private ImageUltils () {
    }
    
    public static Image load(String path) {
        if (path == null || path.isEmpty()) {
            path = DEFAULT_ICON;
        }
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }
    
}
