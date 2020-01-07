/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import utils.ColorEnum;
import utils.ImageUtils;

/**
 *
 * @author SMILE ^^
 */
public class Ex01 extends JFrame {

    private static final String APP_TITLE = "COLOR PICKER";
    private static final int APP_WIDTH = 850;
    private static final int APP_HEIGHT = 300;
    private static final String APP_ICON = "E:\\java06-swing-app\\Lesson19_BaiTap_Nhom1\\src\\main\\java\\images\\icon_app.png";

    private final Container container = getContentPane();
    private final ColorEnum[] colors = ColorEnum.values();

    private final BorderLayout borderLayout = new BorderLayout();
    private final FlowLayout flowLayout = new FlowLayout();
    private final GridLayout gridLayout = new GridLayout(2, 1);

    private JPanel pnBottom;

    private JSplitPane spTop;

    private JPanel pnColor;

    private JPanel pnColorTop;
    private JPanel pnColorBottom;

    private JPanel pnSize;

    private JPanel pnSizeTop;
    private JPanel pnSizeBottom;

    private JLabel lbColor;
    private JLabel lbSize;

    private JButton btAsc;
    private JButton btDesc;

    private JLabel lbChoice;
    private TextArea taContent;

    private Border defaultBorder;
    private final Border highlightBorder = BorderFactory.createLineBorder(Color.WHITE, 5);

    private final Font defaultFont = new Font("Tahoma", Font.BOLD, 24);
    private final Color defaultColorButton = Color.RED;
    private int sizeFont = 12;
    private Color colorButton;
    private String colorButtonName;
    private final Font initialFont = new Font("Tahoma", Font.BOLD, sizeFont);
    private final String defaultChoice = "Color: RED - FontSize: 12px";
    private final String defaultContent = "Nội dung settings";

    public Ex01(String title) {
        super(title);
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01(APP_TITLE);
        ex01.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(APP_ICON));
        setLocationRelativeTo(null);
        setResizable(false);

        container.setLayout(borderLayout);

        flowLayout.setHgap(10);

        lbColor = new JLabel("Color Picker");
        lbColor.setFont(defaultFont);

        pnColorTop = new JPanel(flowLayout);
        pnColorTop.setBackground(new java.awt.Color(204, 204, 255));
        pnColorTop.setPreferredSize(new Dimension(400, 20));
        pnColorTop.add(lbColor);

        pnColorBottom = new JPanel(flowLayout);
        pnColorBottom.setPreferredSize(new Dimension(0, 20));

        for (int i = 0; i < colors.length; i++) {
            JButton bt = new JButton();
            bt.setPreferredSize(new Dimension(50, 35));
            if (i == 0) {
                bt.setBorder(highlightBorder);
            }
            bt.setBackground(colors[i].getColor());
            pnColorBottom.add(bt);
        }

        pnColor = new JPanel(gridLayout);
        pnColor.setPreferredSize(new Dimension(500, 120));

        pnColor.add(pnColorTop);
        pnColor.add(pnColorBottom);

        lbSize = new JLabel();
        setLbSize();

        pnSizeTop = new JPanel(flowLayout);
        pnSizeTop.setBackground(new java.awt.Color(204, 204, 255));
        pnSizeTop.setPreferredSize(new Dimension(0, 20));
        pnSizeTop.add(lbSize);

        btAsc = new JButton("Tăng");
        btAsc.setPreferredSize(new Dimension(70, 35));
        btAsc.setFocusPainted(false);
        btAsc.setBackground(new java.awt.Color(204, 255, 204));

        btDesc = new JButton("Giảm");
        btDesc.setPreferredSize(new Dimension(70, 35));
        btDesc.setFocusPainted(false);
        btDesc.setBackground(new java.awt.Color(204, 255, 204));

        defaultBorder = btAsc.getBorder();

        pnSizeBottom = new JPanel(flowLayout);
        pnSizeBottom.setPreferredSize(new Dimension(0, 20));

        pnSizeBottom.add(btDesc);
        pnSizeBottom.add(btAsc);

        pnSize = new JPanel(gridLayout);
        pnSize.setPreferredSize(new Dimension(0, 120));

        pnSize.add(pnSizeTop);
        pnSize.add(pnSizeBottom);

        spTop = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnColor, pnSize);

        lbChoice = new JLabel();

        taContent = new TextArea();

        initChoice_TextArea();

        pnBottom = new JPanel(gridLayout);
        pnBottom.add(lbChoice);
        pnBottom.add(taContent);
        pnBottom.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.yellow));
        pnBottom.setBackground(new java.awt.Color(255, 255, 255));

        container.add(spTop, BorderLayout.NORTH);
        container.add(pnBottom, BorderLayout.CENTER);

    }

    private void initEvents() {
        pnColorButtonEvents();
        pnSizeButtonEvents();
    }

    private void pnColorButtonEvents() {
        Component[] components = pnColorBottom.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        disableHighlightButtons(components);
                        button.setBorder(highlightBorder);
                        colorButton = button.getBackground();
                        for (ColorEnum color : colors) {
                            if (colorButton.toString().equals(color.getColor().toString())) {
                                colorButtonName = color.name();
                            }
                        }
                        setResult();
                    }
                });
            }
        }
    }

    private void disableHighlightButtons(Component... components) {
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.setBorder(defaultBorder);
            }
        }
    }

    private void pnSizeButtonEvents() {

        disableHighlightButtons(btAsc, btDesc);
        btAsc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sizeFont++;
                setPressedSizeButton(btAsc);
            }
        });
        btDesc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sizeFont--;
                setPressedSizeButton(btDesc);
            }
        });

    }

    private void setPressedSizeButton(JButton button) {
        disableHighlightButtons(btAsc, btDesc);
        button.setBorder(highlightBorder);
        setResult();
    }

    private void setLbSize() {
        lbSize.setFont(defaultFont);
        lbSize.setText("Size: " + sizeFont + "px");
    }

    private void initChoice_TextArea() {
        lbChoice.setFont(defaultFont);
        lbChoice.setText(defaultChoice);
        taContent.setForeground(defaultColorButton);
        taContent.setFont(initialFont);
        taContent.setText(defaultContent);
    }

    private void setResult() {
        lbSize.setFont(defaultFont);
        lbSize.setText("Size: " + sizeFont + "px");
        lbChoice.setText("Color: " + colorButtonName + " - FontSize: " + sizeFont + "px");
        taContent.setForeground(colorButton);
        taContent.setFont(new Font("Tahoma", Font.BOLD, sizeFont));
    }
}
