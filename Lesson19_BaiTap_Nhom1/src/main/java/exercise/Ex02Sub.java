/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author SMILE ^^
 */
public class Ex02Sub extends JFrame {

    private static final String APP_TITLE = "HOTEL MANAGER";
    private static final int APP_WIDTH = 700;
    private static final int APP_HEIGHT = 400;
    private static final String APP_ICON = "E:\\java06-swing-app\\Lesson19_BaiTap_Nhom1\\src\\main\\java\\images\\icon_app.png";

    public Ex02Sub(String title) {
        super(title);
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex02Sub ex02sub = new Ex02Sub(APP_TITLE);
        ex02sub.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(APP_ICON));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initEvents() {

    }

}
