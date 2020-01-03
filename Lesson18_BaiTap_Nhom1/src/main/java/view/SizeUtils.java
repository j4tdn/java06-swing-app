/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;

/**
 *
 * @author phanv
 */
public class SizeUtils {
    public static int getPreWidth(Component comp) {
        return comp.getPreferredSize().width;
    }

    public static int getPreHeight(Component comp) {
        return comp.getPreferredSize().height;
    }

    public static int getWidth(Component comp) {
        return comp.getSize().width;
    }
    public static int getHeight(Component comp) {
        return comp.getSize().height;
    }
}
