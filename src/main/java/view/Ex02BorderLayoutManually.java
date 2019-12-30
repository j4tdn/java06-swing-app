/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class Ex02BorderLayoutManually extends JFrame {

    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final JSplitPane splitPane = new JSplitPane();
    private final JSplitPane splitPanePnLeft = new JSplitPane();
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;

    public Ex02BorderLayoutManually(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setLocationRelativeTo(null);

        container.setLayout(borderLayout);

        initComponents();
    }

    private void initComponents() {

        splitPane.setOneTouchExpandable(true);

        pnTop = new JPanel();
        pnTop.setBackground(Color.GREEN);
        pnTop.setPreferredSize(new Dimension(0, 100));
        container.add(pnTop, BorderLayout.NORTH);

        splitPanePnLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);

        pnLeftTop = new JPanel();
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setPreferredSize(new Dimension(140, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(Color.YELLOW);
        pnLeftBottom.setPreferredSize(new Dimension(140, 0));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);

        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);

        container.add(splitPanePnLeft, BorderLayout.WEST);
        container.add(splitPane, BorderLayout.CENTER);

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);
    }

    public static void main(String[] args) {
        Ex02BorderLayoutManually eblm = new Ex02BorderLayoutManually("Border Layout");
        eblm.setVisible(true);
    }

}
