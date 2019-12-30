/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import view.sub.PnEmployee;
import view.sub.PnHomepage;

/**
 *
 * @author qphan
 */
public class Ex04CardLayoutManually extends JFrame {

    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0, 5, 5);
    private final CardLayout cardLayout = new CardLayout();
    private final JSplitPane splitPane = new JSplitPane();
    private final JSplitPane splitPanePnLeft = new JSplitPane();
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private PnHomepage pnHomepage;
    private PnEmployee pnEmployee;
    private JButton btHomePage;
    private JButton btEmployee;

    private Border defaultBorder;
    private Border hightlightBorder;

    public Ex04CardLayoutManually(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setLocationRelativeTo(null);

        container.setLayout(borderLayout);

        initComponents();
        initEvents();
    }

    private void initComponents() {

        splitPane.setOneTouchExpandable(true);

        pnTop = new JPanel();
        pnTop.setBackground(Color.GREEN);
        pnTop.setPreferredSize(new Dimension(0, 100));
        container.add(pnTop, BorderLayout.NORTH);

        splitPanePnLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);

        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton();

        defaultBorder = btHomePage.getBorder();
        hightlightBorder = BorderFactory.createLineBorder(Color.RED, 5);

        btHomePage.setBorder(hightlightBorder);
        btHomePage.setFocusPainted(false);
        btHomePage.setFont(new Font("Tahoma", Font.BOLD, 18));
        btHomePage.setText("Home page");
        pnLeftTop.add(btHomePage);

        btEmployee = new JButton();
        btEmployee.setFocusPainted(false);
        btEmployee.setFont(new Font("Tahoma", Font.BOLD, 18));
        btEmployee.setText("Employee");
        pnLeftTop.add(btEmployee);

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(Color.YELLOW);
        pnLeftBottom.setPreferredSize(new Dimension(220, 0));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);

        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(cardLayout);

        pnHomepage = new PnHomepage();
        pnEmployee = new PnEmployee();

        pnCenter.add(pnHomepage, btHomePage.getText());
        pnCenter.add(pnEmployee, btEmployee.getText());

        container.add(splitPanePnLeft, BorderLayout.WEST);
        container.add(splitPane, BorderLayout.CENTER);

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);
    }

    private void initEvents() {
        pnLeftTopButtonsEvents();
    }

    private void pnLeftTopButtonsEvents() {
        final Component[] components = pnLeftTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        String key = button.getText();
                        cardLayout.show(pnCenter, key);

                        disableHighLightButtons(components);
                        button.setBorder(hightlightBorder);
                    }
                });
            }
        }
    }

    private void disableHighLightButtons(Component... components) {
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.setBorder(defaultBorder);
            }
        }
    }

    public static void main(String[] args) {
        Ex04CardLayoutManually eblm = new Ex04CardLayoutManually("Border Layout");
        eblm.setVisible(true);
    }

}
