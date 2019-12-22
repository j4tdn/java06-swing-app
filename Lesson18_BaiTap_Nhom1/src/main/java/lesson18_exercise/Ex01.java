/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUntils;

/**
 *
 * @author LENOVO
 */
public class Ex01 extends JFrame {

    private static final String TRUNCATE_APP_TITLE = "Ex01_Truncate";
    private static final int TRUNCATE_APP_WIDTH = 500;
    private static final int TRUNCATE_APP_HEIGHT = 320;
    private static final String TRUNCATE_APP_ICON = "F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\like.png";

    private final Container conn = getContentPane();
    private JLabel jlTitle;
    private JLabel jlInput;
    private JTextField jtInput;
    private JLabel jlOutput;
    private JTextField jtOutput;
    private JButton jbButton;

    public Ex01() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex02 ex07 = new Ex02();
        ex07.setVisible(true);
    }

    private void initComponents() {
        setTitle(TRUNCATE_APP_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(TRUNCATE_APP_WIDTH, TRUNCATE_APP_HEIGHT);
        setIconImage(ImageUtils.load(TRUNCATE_APP_ICON));

        final int VERITICAL_PADDING = 30;
        final int HORIZONTAl_PADDING = 30;
        final int INITTIAL_HEADER_Y_PADDING = 50;
        final int INITTIAL_HEADER_X_PADDING = 130;

        conn.setLayout(null);
        conn.setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);

        jlTitle = new JLabel("TRUNCATE - NUMBER");
        jlTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        jlTitle.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                SizeUntils.getPreWidth(jlTitle), SizeUntils.getPreHeight(jlTitle));
        jlTitle.setForeground(Color.RED);

        jlInput = new JLabel("Nhập dãy số: ");
        jlInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jlInput.setBounds(INITTIAL_HEADER_X_PADDING / 2,
                INITTIAL_HEADER_Y_PADDING + SizeUntils.getPreHeight(jlTitle) + VERITICAL_PADDING,
                SizeUntils.getPreWidth(jlInput), SizeUntils.getPreHeight(jlInput));

        jtInput = new JTextField();
        jtInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jtInput.setBounds(jlInput.getX() + SizeUntils.getPreWidth(jlInput) + HORIZONTAl_PADDING,
                jlInput.getY(),
                230, SizeUntils.getPreHeight(jlInput));

        jlOutput = new JLabel("Kết quả: ");
        jlOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jlOutput.setBounds(INITTIAL_HEADER_X_PADDING / 2 + SizeUntils.getPreWidth(jlInput) - SizeUntils.getPreWidth(jlOutput),
                jlInput.getY() + SizeUntils.getPreHeight(jlInput) + VERITICAL_PADDING,
                SizeUntils.getPreWidth(jlOutput),
                SizeUntils.getPreHeight(jlOutput));

        jtOutput = new JTextField();
        jtOutput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jtOutput.setBounds(jlInput.getX() + SizeUntils.getPreWidth(jlInput) + HORIZONTAl_PADDING,
                jlOutput.getY(),
                jtInput.getWidth() / 2, SizeUntils.getPreHeight(jlOutput));
        jtOutput.setEditable(false);

        jbButton = new JButton("Thực hiện");
        jbButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jbButton.setBounds(jtOutput.getX() + SizeUntils.getWidth(jtOutput) + HORIZONTAl_PADDING / 2, jtOutput.getY(),
                SizeUntils.getWidth(jtOutput),
                SizeUntils.getPreHeight(jtOutput));
        jbButton.setFocusPainted(false);

        conn.add(jlTitle);
        conn.add(jlInput);
        conn.add(jtInput);
        conn.add(jlOutput);
        conn.add(jtOutput);
        conn.add(jbButton);
    }

    private void initEvents() {
        jbButton.addMouseListener(new MouseAdapter() {
            Font font = jbButton.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                String input = jtInput.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(conn, "Nhập chuỗi đi baaaa!");
                } else {
                    List<String> reult = Pattern
                            .compile("[^\\d]+").splitAsStream(input)
                            .filter(t -> !t.isEmpty()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet().stream().
                            filter(t -> t.getValue() == 1).map(t -> t.getKey()).collect(Collectors.toList());
                    jtOutput.setText(String.join(",", reult));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbButton.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbButton.setFont(font);
            }

        });
    }

}
