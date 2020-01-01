/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Player;
import entities.Team;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import util.FileUtils;
import util.ImageUtils;

/**
 *
 * @author Admin
 */
public class ThreadHandler extends Thread{
    //list người đã chơi
    private List<Player> played = new ArrayList<>();
    private FightState fightState = null;
    private volatile double timeCount = 0;
    private final String directoryAvatar = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\Lesson19\\src\\main\\java\\image";
    private Team team1 = new Team();
    private Team team2 = new Team();
    private Team team3 = new Team();
    private Random rd = new Random();
    
    
    public ThreadHandler(FightState fightState) {
        this.fightState = fightState;
        team1 = setinfo(directoryAvatar+"\\team1\\");
        team2 = setinfo(directoryAvatar+"\\team2\\");
        team3 = setinfo(directoryAvatar+"\\team3\\");
        
    }

    @Override
    public void run() {
        Player rdPlayerT1 = null;
        Player rdPlayerT2 = null;
        Player rdPlayerT3 = null;
        while(true){
            
            rdPlayerT1 = randomFighter(team1);
            rdPlayerT2 = randomFighter(team2);
            rdPlayerT3 = randomFighter(team3);
            setFighter(rdPlayerT1,rdPlayerT2,rdPlayerT3);
            setSleep(timeCount);
            fightState.getBtStart().setVisible(false);
            timeCount+=0.005;
            if(timeCount>0.15){
                synchronized(this){
            try {
                
                System.out.println(FileUtils.writeFile(directoryAvatar+"\\result.txt", rdPlayerT1.getName()+" vs "+ rdPlayerT2.getName()
                        +" vs "+rdPlayerT3.getName()));;
                played.add(rdPlayerT1);
                played.add(rdPlayerT2);
                played.add(rdPlayerT3);
                fightState.getBtStart().setVisible(true);
                
                timeCount = (played.size()!=12) ?  0 : (0.15-0.005); 
                wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            }
        }
        
        
    }
    private Player randomFighter(Team team){
        List<Player> Players = team.getMemnbers();
        Player rdPlayer = Players.stream()
                .filter(t->!played.contains(t))
                .collect(Collectors.toList())
                .get(rd.nextInt(Players.size()-played.size()/3));
        return rdPlayer;
    }
    
    private void setFighter(Player player1,Player player2, Player player3){
        
        fightState.getjLabel1().setIcon(new ImageIcon(player1.getAvatar()));
           
        fightState.getjLabel2().setIcon(new ImageIcon(player2.getAvatar()));
        
        fightState.getjLabel3().setIcon(new ImageIcon(player3.getAvatar()));
        
    }
    public Team setinfo(String directory){
       
        Team team = new Team();
        Image image = ImageUtils.getImage(directory,"avatar.jpg").getScaledInstance(104,96, Image.SCALE_SMOOTH);;
        team.setAvartar(image);
        List<Image> images = ImageUtils.getImages(directory+"player");
        images.forEach(t->team.getMemnbers().add(new Player("player"+images.indexOf(t), t.getScaledInstance(104,96, Image.SCALE_SMOOTH))));
        return team;
        
    }
    public void setAvatarTeam(){
    
        fightState.getjLabel1().setIcon(new ImageIcon(team1.getAvartar()));
        
        fightState.getjLabel2().setIcon(new ImageIcon(team2.getAvartar()));
        
        fightState.getjLabel3().setIcon(new ImageIcon(team3.getAvartar()));
    }
    public void setSleep(double second){
        try {
            Thread.sleep((long)(second*1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
