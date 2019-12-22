/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author phanv
 */
public enum EnumImagePath {
    IMAGEPATH_1("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\1.jpg"),
    IMAGEPATH_2("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\2.jpg"),
    IMAGEPATH_3("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\3.jpg"),
    IMAGEPATH_4("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\4.jpg"),
    IMAGEPATH_5("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\5.jpg"),
    IMAGEPATH_6("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\6.jpg"),
    IMAGEPATH_7("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\7.jpg"),
    IMAGEPATH_8("D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\8.jpg");
    private String path;

    private EnumImagePath(String path) {
        this.path=path;
    }
    public String getPath(){
        return this.path;
    }
    
    

}
