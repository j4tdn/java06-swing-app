/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;

/**
 *
 * @author huyvi
 */
public enum ColorEnum {
    BLACK (Color.BLACK),
    RED (Color.RED),
    BLUE (Color.BLUE),
    YELLOW (Color.YELLOW),
    GREEN (Color.GREEN);
    
    private Color color;
    
    private ColorEnum(Color color) { 
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }

    @Override
    public String toString() {
        return color.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
