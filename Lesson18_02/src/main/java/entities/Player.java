/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Image;
import javax.swing.Icon;

/**
 *
 * @author Admin
 */
public class Player {
    private String name;
    private Image avatar;

  

    public Player() {
    }
    
    public Player(String name, Image avatar) {
        this.name = name;
        this.avatar = avatar;
    }
      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }
}
