/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;

/**
 *
 * @author SMILE ^^
 */
public enum ColorEnum {

    RED(Color.RED),
    ORANGE(Color.ORANGE),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    BLACK(Color.BLACK);

    private final Color color;

    private ColorEnum(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
