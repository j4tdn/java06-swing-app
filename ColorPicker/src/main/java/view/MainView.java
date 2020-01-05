/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.ColorEnum;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{
    private final String ICON_APP = "";
    private final int APP_WIDTH = 550;
    private final int APP_HEIGHT = 400;
    private final int DEFAULT_SIZE = 16;
    private int fontSize = DEFAULT_SIZE;
    private final ColorEnum[] colorEnums = ColorEnum.values();
    private ColorEnum curColor = colorEnums[0];
    
    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final FlowLayout flPicker = new FlowLayout(0, 10, 0);
    private final FlowLayout flColor = new FlowLayout(10, 10, 3);
    private final FlowLayout flSize = new FlowLayout(10, 10, 3);
    
    private JPanel pnPicker;
    private JPanel pnColorPicker;
    private JPanel pnSizePicker;
    private JPanel pnContent;
    private JLabel lbColor;
    private JPanel pnColor;
    private List<JComponent> pnColors;
    private JLabel lbSize;
    private JPanel pnSize;
    private List<JComponent> lbSizes;
    private JLabel lbInfor;
    private JTextArea taContent;

    public MainView(String title) {
        super(title);
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        MainView mainView = new MainView("Color Picker");
        mainView.setVisible(true);
    }

    private void initComponents() {
        setSize(APP_WIDTH, APP_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load(ICON_APP));
        
        initTopComponents();
        initCenterComponents();
        
        container.add(pnPicker, BorderLayout.NORTH);
        container.add(pnContent, BorderLayout.CENTER);
    }

    private void initTopComponents() {
        // initColorPicker;
        lbColor = new JLabel();
        lbColor.setText("COLOR:");
        lbColor.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbColor.setPreferredSize(new Dimension(0, 40));
        lbColor.setBackground(Color.RED);
        lbColor.setOpaque(true);
        lbColor.setBackground(Color.LIGHT_GRAY);
        
        pnColors = new ArrayList<>();
        pnColor = new JPanel();
        pnColor.setLayout(flColor);
        pnColor.setPreferredSize(new Dimension(250, 40));
        for(ColorEnum color : colorEnums){
            pnColor.add(createColorPanel(color));
        }
        
        
        pnColorPicker = new JPanel();
        pnColorPicker.setPreferredSize(new Dimension(250, 80));
        pnColorPicker.setLayout(new BorderLayout());
        pnColorPicker.add(lbColor, BorderLayout.NORTH);
        pnColorPicker.add(pnColor, BorderLayout.CENTER);
        pnColorPicker.setBorder(BorderFactory.createEtchedBorder());
        
        // initSizePicker;
        lbSize = new JLabel();
        lbSize.setText("SIZES:");
        lbSize.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbSize.setPreferredSize(new Dimension(0, 40));
        lbSize.setOpaque(true);
        lbSize.setBackground(Color.LIGHT_GRAY);
        
        lbSizes = new ArrayList<>();
        JLabel lbIncreSize = new JLabel();
        lbIncreSize.setText("TĂNG");
        lbIncreSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbIncreSize.setPreferredSize(new Dimension(40, 30));
        lbIncreSize.setOpaque(true);
        lbIncreSize.setBackground(Color.pink);
        lbSizes.add(lbIncreSize);
        
        JLabel lbDecreSize = new JLabel();
        lbDecreSize.setText("GIẢM");
        lbDecreSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbDecreSize.setPreferredSize(new Dimension(40, 30));
        lbDecreSize.setOpaque(true);
        lbDecreSize.setBackground(Color.ORANGE);
        lbSizes.add(lbDecreSize);
        
        pnSize = new JPanel();
        pnSize.setLayout(flSize);
        pnSize.setPreferredSize(new Dimension(250, 40));
        pnSize.add(lbIncreSize);
        pnSize.add(lbDecreSize);
        
        pnSizePicker = new JPanel();
        pnSizePicker.setLayout(new BorderLayout());
        pnSizePicker.setPreferredSize(new Dimension(250, 80));
        pnSizePicker.add(lbSize, BorderLayout.NORTH);
        pnSizePicker.add(pnSize, BorderLayout.CENTER);
        pnSizePicker.setBorder(BorderFactory.createEtchedBorder());
        
        pnPicker = new JPanel();
        pnPicker.setLayout(flPicker);
        pnPicker.setPreferredSize(new Dimension(APP_WIDTH, 80));
        pnPicker.add(pnColorPicker);
        pnPicker.add(pnSizePicker);
    }

    private void initCenterComponents() {
        lbInfor = new JLabel();
        lbInfor.setText("Color: " + curColor.name() + ", Size: " + DEFAULT_SIZE);
        lbInfor.setPreferredSize(new Dimension(APP_WIDTH, 40));
        lbInfor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        taContent = new JTextArea();
        taContent.setText("Nội dung text");
        taContent.setPreferredSize(new Dimension(APP_WIDTH, 400 - 120));
        taContent.setFont(new Font("Tahoma", Font.PLAIN, DEFAULT_SIZE));
        taContent.setForeground(curColor.getColor());
        
        pnContent = new JPanel();
        pnContent.setLayout(borderLayout);
        pnContent.add(lbInfor, BorderLayout.NORTH);
        pnContent.add(taContent, BorderLayout.CENTER);
        
        container.add(pnPicker, BorderLayout.NORTH);
        container.add(pnContent, BorderLayout.CENTER);
    }

    private JPanel createColorPanel(ColorEnum colorEnum) {
        JPanel pnColor = new JPanel();
        pnColor.setFont(new Font("Tahoma", Font.PLAIN, 10));
        pnColor.setPreferredSize(new Dimension(30, 30));
        pnColor.setBackground(colorEnum.getColor());
        pnColors.add(pnColor);
        return pnColor;
    }

    private void initEvents() {
        initPnColorsEvents();
        initLbSizesEvents();
    }

    private void initPnColorsEvents() {
        for(int i = 0; i < pnColors.size(); i++){
            JPanel pnColor = (JPanel) pnColors.get(i);
            pnColor.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    curColor = getColorName(pnColor.getBackground());
                    discardBorder(pnColors);
                    pnColor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    taContent.setForeground(pnColor.getBackground());
                    lbInfor.setText("Color: " + curColor.name()
                            + ", Size: " + fontSize);
                    revalidate();
                }
                
            });
        }
    }

    private void discardBorder(List<JComponent> components){
        for (JComponent component : components){
            component.setBorder(null);
        }
    }
    
    private void initLbSizesEvents() {
        for(JComponent lbSize : lbSizes){
            lbSize.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    discardBorder(lbSizes);
                    lbSize.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    
                    JLabel lbTemp = (JLabel) lbSize;
                    String text = lbTemp.getText();
                    
                    if(text.equals("GIẢM")){
                        fontSize--;
                    } else {
                        fontSize++;
                    }
                    
                    lbInfor.setText("Color: " + curColor.name()
                            + ", Size: " + fontSize);
                    taContent.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
                    revalidate();
                }
                
            });
        }
    }
    
    private ColorEnum getColorName(Color color){
        String rbg = color.toString();
        rbg = rbg.substring(rbg.indexOf("["));
        for(ColorEnum colorEnum : colorEnums){
            String tmpRbg = colorEnum.toString();
            tmpRbg = tmpRbg.substring(tmpRbg.indexOf("["));
            
            if(tmpRbg.equals(rbg)){
                return colorEnum;
            }
        }
        
        return this.curColor;
    }
}
