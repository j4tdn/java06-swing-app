/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import java.awt.Component;

/**
 *
 * @author USER
 */
public class SizeUtil {

    private SizeUtil() {
    }
    
    
    public static int getPreWidth(Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }
    public static int getPreHeight(Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }
    public static int getWidth(Component comp) {
        return (int) comp.getSize().getWidth();
    }
    
}
