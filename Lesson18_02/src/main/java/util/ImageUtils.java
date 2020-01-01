/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageUtils {
    public static Image getImage(String path){
        if(path == null || path.isEmpty() ){
            return null;
        }else{
            return new ImageIcon(path).getImage();
        }   
    }
    
    public static Image getImage(String pathDir,String name){
        Image image = null;
        if(pathDir == null || pathDir.isEmpty() ||name == null || name.isEmpty()){
            return null;
        }else{
            try {
                image = Files.walk(Paths.get(pathDir)).filter(t->t.getFileName().toString().equals(name)).map(t->new ImageIcon(t.toString()).getImage()).findAny().orElse(null);   
        } catch (IOException ex) {
            Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return image;
    }
    
    public static List<Image> getImages(String directory){
        List<Image> images = null;
        try {
            images = Files.walk(Paths.get(directory)).filter(t->t.toString().endsWith(".jpg")).map(t-> new ImageIcon(t.toString()).getImage()).collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
}

