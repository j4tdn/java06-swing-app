/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Admin
 */
public class PlayerUtils {

    private String namePlayer;
    private String imagePlayer;
    private Boolean isPlayed;
    private int team;

    public PlayerUtils() {
    }

    public PlayerUtils(String namePlayer, String img, int team) {
        this.namePlayer = namePlayer;
        this.imagePlayer = img;
        this.team = team;
        isPlayed = false;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getImagePlayer() {
        return imagePlayer;
    }

    public void setImagePlayer(String imagePlayer) {
        this.imagePlayer = imagePlayer;
    }

    public Boolean getIsPlayed() {
        return isPlayed;
    }

    public void setIsPlayed(Boolean isPlayed) {
        this.isPlayed = isPlayed;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Name: " + namePlayer;
    }

}
