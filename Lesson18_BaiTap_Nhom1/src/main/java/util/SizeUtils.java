/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;

/**
 *
 * @author Mr.Chien
 */
public class SizeUtils {

    private SizeUtils() {

    }

    public static int getPreWidth(java.awt.Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }

    public static int getPreHeight(java.awt.Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }

    public static int getWidth(java.awt.Component comp) {
        return (int) comp.getSize().getWidth();
    }

    public static int getHeight(java.awt.Component comp) {
        return (int) comp.getSize().getHeight();
    }

    public static int getLocation(Component component) {
        return (int) component.getLocation().getY();
    }

}
