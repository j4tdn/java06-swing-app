/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class Ex01 extends JFrame {

    private final int APP_WIDTH = 1000;
    private final int APP_HEIGHT = 400;
    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final FlowLayout flowLayout = new FlowLayout();

    private JPanel pnTopLeft;
    private JPanel pnTopLeftBottom;
    private JPanel pnTopRight;
    private JPanel pnTopRightBottom;
    private JPanel pnTopBottom;
    private JPanel pnEndBottom;

    private JButton btASC;
    private JButton btDEC;
    private JPanel pnButtonColors;
    private JPanel pnButtons;

    private JLabel lbColorPicker;
    private JLabel lbSize;
    private JLabel lbFontCurrent;
    private JTextArea ta;
    private int sizeTextArea = 18;
    private String colorTextArea = "Blue";

    private final common.ColorEnum[] colors = common.ColorEnum.values();

    public Ex01(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        container.setLayout(borderLayout);

        initComponents();
        initEvents();
    }

    private void initComponents() {

        pnTopLeft = new JPanel();
        pnTopLeft.setBackground(Color.WHITE);

        lbColorPicker = new JLabel();
        lbColorPicker.setOpaque(true);
        lbColorPicker.setPreferredSize(new Dimension(475, 50));
        lbColorPicker.setText("Color Picker");
        lbColorPicker.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbColorPicker.setForeground(Color.BLACK);
        lbColorPicker.setBackground(Color.CYAN);
        pnTopLeft.add(lbColorPicker);

        pnTopLeftBottom = new JPanel();
        pnTopLeftBottom.setBackground(Color.WHITE);
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(10);
        pnTopLeftBottom.setLayout(flowLayout);
        pnButtonColors = new JPanel();
        pnButtonColors.setBackground(Color.WHITE);
        pnButtonColors.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnButtonColors.setLayout(flowLayout);
        drawButtonColors();
        pnTopLeft.add(pnTopLeftBottom);
        pnTopLeft.setPreferredSize(new Dimension(475, 0));
        container.add(pnTopLeft, BorderLayout.WEST);

        pnTopRight = new JPanel();
        pnTopRight.setBackground(Color.WHITE);
        lbSize = new JLabel();
        lbSize.setOpaque(true);
        lbSize.setPreferredSize(new Dimension(475, 50));
        lbSize.setText("Size: " + sizeTextArea + "px");
        lbSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSize.setForeground(Color.BLACK);
        lbSize.setBackground(Color.YELLOW);
        pnTopRight.add(lbSize);

        pnTopRightBottom = new JPanel();
        pnTopRightBottom.setBackground(Color.WHITE);
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(20);
        pnTopRightBottom.setLayout(flowLayout);
        pnButtons = new JPanel();
        pnButtons.setBackground(Color.WHITE);
        pnButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnButtons.setLayout(flowLayout);
        drawButtons();
        pnTopRight.add(pnTopRightBottom);
        pnTopRight.setPreferredSize(new Dimension(475, 0));
        container.add(pnTopRight, BorderLayout.EAST);

        pnTopBottom = new JPanel();
        pnTopBottom.setBackground(Color.WHITE);
        lbFontCurrent = new JLabel();
        lbFontCurrent.setText("Color: red - FontSize: 18px");
        lbFontCurrent.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbFontCurrent.setPreferredSize(new Dimension(900, 20));
        pnTopBottom.add(lbFontCurrent);

        pnEndBottom = new JPanel();
        pnEndBottom.setBackground(Color.WHITE);
        ta = new JTextArea();
        ta.setText("Nội dung settings");
        ta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ta.setPreferredSize(new Dimension(950, 170));
        ta.setForeground(Color.BLUE);
        pnEndBottom.add(ta);
        pnEndBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnTopBottom.add(pnEndBottom);
        pnTopBottom.setPreferredSize(new Dimension(0, 220));
        container.add(pnTopBottom, BorderLayout.SOUTH);

        container.setBackground(Color.WHITE);

    }

    public static void main(String[] args) {
        Ex01 eblm = new Ex01("COLOR PICKER");
        eblm.setVisible(true);
    }

    private void drawButtonColors() {
        for (int i = 0; i < colors.length; i++) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setBackground(colors[i].getColor());
            button.setPreferredSize(new Dimension(40, 40));
            pnButtonColors.setPreferredSize(new Dimension(475, 50));
            pnButtonColors.add(button);
        }

        pnTopLeftBottom.add(pnButtonColors);
    }

    private void drawButtons() {
        btASC = new JButton();
        btASC.setText("Tăng");
        btASC.setFocusPainted(false);
        btASC.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btASC.setBackground(Color.cyan);
        pnButtons.add(btASC);

        btDEC = new JButton();
        btDEC.setText("Giảm");
        btDEC.setFocusPainted(false);
        btDEC.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btDEC.setBackground(Color.cyan);
        pnButtons.add(btDEC);
        pnButtons.setPreferredSize(new Dimension(475, 50));
        pnTopRightBottom.add(pnButtons);
    }

    private void initEvents() {
        btASCEvent();
        btDECEvent();
        btColorsEvent();
    }

    private void btASCEvent() {

        btASC.addMouseListener(new MouseAdapter() {
            Font btASCFont = btASC.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                sizeTextArea++;
                ta.setFont(new Font("Tahoma", Font.PLAIN, sizeTextArea));
                lbFontCurrent.setText("Color: " + colorTextArea + " - FontSize: " + sizeTextArea + "px");
                lbSize.setText("Size: " + sizeTextArea + "px");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btASCFont.getFontName(),
                        Font.BOLD, this.btASCFont.getSize());
                btASC.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btASC.setFont(btASCFont);
            }
        });

    }

    private void btDECEvent() {
        btDEC.addMouseListener(new MouseAdapter() {
            Font btDECFont = btDEC.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                sizeTextArea--;
                ta.setFont(new Font("Tahoma", Font.PLAIN, sizeTextArea));
                lbFontCurrent.setText("Color: " + colorTextArea + " - FontSize: " + sizeTextArea + "px");
                lbSize.setText("Size: " + sizeTextArea + "px");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btDECFont.getFontName(),
                        Font.BOLD, this.btDECFont.getSize());
                btDEC.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btDEC.setFont(btDECFont);
            }
        });
    }

    private void btColorsEvent() {
        Component[] components = pnButtonColors.getComponents();
        for (int i = 0; i < components.length; i++) {
            final int count = i;
            final Component cpn = components[i];
            components[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    colorTextArea = colors[count].name();
                    ta.setForeground(colors[count].getColor());
                    pnEndBottom.setBorder(BorderFactory.createLineBorder(colors[count].getColor()));
                    lbFontCurrent.setText("Color: " + colorTextArea + " - FontSize: " + sizeTextArea + "px");
                }
            });
        }
    }

}
