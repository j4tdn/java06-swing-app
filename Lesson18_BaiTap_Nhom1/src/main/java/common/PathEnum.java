/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author LENOVO
 */
public enum PathEnum {
    IMAGE1("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\like.png"),
    IMAGE2("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\ghe.jpg"),
    IMAGE3("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\doidoi.jpg"),
    IMAGE4("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\48px_love.png"),
    IMAGE5("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\48px_like.png"),
    IMAGE6("F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\64px_flower.png");

    private final String path;
    private PathEnum(String path){
        this.path=path;
    }
    public String getPath(){
        return path;
    }
}
