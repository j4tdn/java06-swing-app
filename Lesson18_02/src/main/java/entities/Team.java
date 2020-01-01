/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Team {
    private List<Player> memnbers ;
    private Image avartar;
    
    public Team() {
        memnbers = new ArrayList<>();
        avartar = null;
    }

    public Team(List<Player> memnbers,Image avatar) {
        this.memnbers = memnbers;
        this.avartar = avatar;
        
    }

    public Image getAvartar() {
        return avartar;
    }

    public void setAvartar(Image avartar) {
        this.avartar = avartar;
    }
    
    public List<Player> getMemnbers() {
        return memnbers;
    }

    public void setMemnber(List<Player> memnbers) {
        this.memnbers = memnbers;
    }
    
}
