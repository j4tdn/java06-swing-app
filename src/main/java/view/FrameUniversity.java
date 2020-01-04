/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.imageio.plugins.common.ImageUtil;
import common.CardKey;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import utils.ImageUtils;
import view.sub.PnEmployee;
import view.sub.PnHomepage;
import view.sub.PnStudent;

/**
 *
 * @author qphan
 */
public class FrameUniversity extends JFrame {

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
    private PnStudent pnStudent;

    private JButton btHomePage;
    private JButton btEmployee;
    private JButton btStudent;

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(Color.RED, 5);
    private final Border pnLeftEmptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    public FrameUniversity(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load(getClass().getResource("/images/student.png").getPath()));
        container.setLayout(borderLayout);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        splitPane.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);

        initPnTopComponents();
        initPnLeftComponents();
        initPnCenterComponents();
    }

    private void initPnTopComponents() {
        pnTop = new JPanel();
        pnTop.setBackground(Color.GREEN);
        pnTop.setPreferredSize(new Dimension(0, 100));
        container.add(pnTop, BorderLayout.NORTH);
    }

    private void initPnLeftComponents() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        pnLeftTop.setBorder(pnLeftEmptyBorder);
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        final Font pnLeftButtonsFont = new Font("Tahoma", Font.BOLD, 18);

        btHomePage = new JButton();
        btHomePage.setFocusPainted(false);
        btHomePage.setFont(pnLeftButtonsFont);
        btHomePage.setText(CardKey.HOMEPAGE.name());
        btHomePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btHomePage.setBorder(pnLeftButtonHighLightBorder);
        pnLeftTop.add(btHomePage);

        btEmployee = new JButton();
        btEmployee.setFocusPainted(false);
        btEmployee.setFont(pnLeftButtonsFont);
        btEmployee.setText(CardKey.EMPLOYEE.name());
        btEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnLeftTop.add(btEmployee);

        btStudent = new JButton();
        btStudent.setFocusPainted(false);
        btStudent.setFont(pnLeftButtonsFont);
        btStudent.setText(CardKey.STUDENT.name());
        btStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnLeftTop.add(btStudent);

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(Color.YELLOW);
        pnLeftBottom.setPreferredSize(new Dimension(220, 0));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnCenterComponents() {
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(cardLayout);

        pnHomepage = new PnHomepage();
        pnEmployee = new PnEmployee();
        pnStudent = new PnStudent();

        pnCenter.add(pnHomepage, btHomePage.getText());
        pnCenter.add(pnEmployee, btEmployee.getText());
        pnCenter.add(pnStudent, btStudent.getText());

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);

        container.add(splitPane, BorderLayout.CENTER);

        // redundant code
        // container.add(splitPanePnLeft, BorderLayout.WEST);
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
                        button.setBorder(pnLeftButtonHighLightBorder);
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
        FrameUniversity eblm = new FrameUniversity("Da Nang University UI/UX");
        eblm.setVisible(true);
    }
}
