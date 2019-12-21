package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{

    private final static int APP_WIDTH = 400;
    private final static int APP_HEIGHT = 600;
    private final static String APP_TITLE = "Random Picture";
    private final static String APP_IMAGE = "E:\\workspace\\swing\\random_picture\\src\\main\\java\\images\\48px_like.png";
    private final static String DEFAULT_IMAGE_PATH = "E:\\workspace\\swing\\random_picture\\src\\main\\java\\images\\1.jpg";
    private final static int INITIAL_PADDING_X = 100;
    private final static int INITIAL_PADDING_Y = 30;
    
    
    private final JLabel lbImage = new JLabel();
    private final JButton btStop = new JButton();
    
    private final Container conn = getContentPane();
    private Timer time;
    public MainView() {
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        MainView main = new MainView();
        main.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(APP_TITLE);
        setIconImage(ImageUtils.loadImage(APP_IMAGE));
        setResizable(false);
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        
        conn.setBackground(Color.GRAY);
        conn.setLayout(null);
        
        setLbImageView(getImagePaths());
        setBtStopView();
        
        conn.add(lbImage);
        conn.add(btStop);
    }

    private void setLbImageView(List<String> imagePaths) {
        int labelWidth = 200;
        int labelHeight = 400;
        
        lbImage.setSize(labelWidth, labelHeight);
        
        time = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                BufferedImage image = getRandomImage(imagePaths);
                ImageIcon imageicon = new ImageIcon(image.getScaledInstance(labelWidth, labelHeight,Image.SCALE_SMOOTH));
                lbImage.setIcon(imageicon);
                lbImage.setBounds(INITIAL_PADDING_X, 
                    INITIAL_PADDING_Y, 
                    labelWidth, 
                    labelHeight);
            }
        });
        
        time.start();
    }

    private void setBtStopView() {
        String text = "STOP";
        
        btStop.setText(text);
        btStop.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 25));
        btStop.setBounds(INITIAL_PADDING_X + (getWidth(lbImage) - getPreWidth(btStop)) / 2, 
                INITIAL_PADDING_Y + getHeight(lbImage) + 20, 
                getPreWidth(btStop), 
                getPreHeight(btStop));
    }
    
    private int getPreWidth(Component component){
        return (int) component.getPreferredSize().getWidth();
    }
    
    private int getPreHeight(Component component){
        return (int) component.getPreferredSize().getHeight();
    }
    
    private int getWidth(Component component){
        return (int) component.getWidth();
    }
    
    private int getHeight(Component component){
        return (int) component.getHeight();
    }

    private List<String> getImagePaths() {
        String pathDirectory = "E:\\workspace\\swing\\random_picture\\src\\main\\java\\images\\";
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add(pathDirectory + "1.jpg");
        imagePaths.add(pathDirectory + "2.jpg");
        imagePaths.add(pathDirectory + "3.jpg");
        imagePaths.add(pathDirectory + "4.jpg");
        imagePaths.add(pathDirectory + "5.jpg");
        imagePaths.add(pathDirectory + "6.jpg");
        imagePaths.add(pathDirectory + "7.jpg");
        imagePaths.add(pathDirectory + "8.jpg");
        
        return imagePaths;
    }

    private BufferedImage getRandomImage(List<String> imagePaths) {
        Random rd = new Random();
        String path = imagePaths.get(rd.nextInt(imagePaths.size()));
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            try {
                image = ImageIO.read(new File(DEFAULT_IMAGE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return image;
    }

    private void initEvents() {
        setBtStopEvents();
    }

    private void setBtStopEvents() {
        btStop.setFocusPainted(false);
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(time.isRunning()){
                    btStop.setText("GO");
                    time.stop();
                } else{
                    btStop.setText("STOP");
                    time.start();
                }
            }
        });
    }
}
