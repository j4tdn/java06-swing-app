/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
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

    private final Container container = getContentPane();
    private final GridLayout gridLayout = new GridLayout();

    private final int numberOfRooms = 22;
    private final int numberOfRows = 4;

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
        gridLayout.setRows(numberOfRows);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);

        container.setLayout(gridLayout);

        setRooms();

    }

    private void initEvents() {

    }

    private void setRooms() {
        for (int i = 1; i <= numberOfRooms; i++) {
            JButton button = new JButton();
            button.setBackground(Color.CYAN);
            button.setFocusPainted(false);
            button.setText("Room: " + (100 + i));
            container.add(button);
        }
    }

}
