/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author qphan
 */
public enum ColorEnum {
    RED(java.awt.Color.RED),
    GREEN(java.awt.Color.GREEN),
    BLUE(java.awt.Color.BLUE),
    BLACK(java.awt.Color.BLACK),
    WHITE(java.awt.Color.WHITE);
    
    private final java.awt.Color color;
    
    private ColorEnum(java.awt.Color color) {
        this.color = color;
    }
    
    public java.awt.Color getColor() {
        return color;
    }
}
