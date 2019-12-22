/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Mr.Chien
 */
public enum ColorEnum {
    BLACK(java.awt.Color.BLACK),
    GREEN(java.awt.Color.GREEN),
    BLUE(java.awt.Color.BLUE),
    PINK(java.awt.Color.PINK),
    ORANGE(java.awt.Color.ORANGE),
    RED(java.awt.Color.RED),
    YELLOW(java.awt.Color.YELLOW);
    private java.awt.Color color;
    private ColorEnum (java.awt.Color color){
        this.color=color;
    }
    public java.awt.Color getColor(){
        return color;
    }
}
