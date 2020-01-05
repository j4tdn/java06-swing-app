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
    Red(java.awt.Color.RED),
    Green(java.awt.Color.GREEN),
    Blue(java.awt.Color.BLUE),
    Black(java.awt.Color.BLACK),
    Orange(java.awt.Color.ORANGE),
    Pink(java.awt.Color.PINK),
    Gray(java.awt.Color.GRAY);

    private final java.awt.Color color;

    private ColorEnum(java.awt.Color color) {
        this.color = color;
    }

    public java.awt.Color getColor() {
        return color;
    }
}
