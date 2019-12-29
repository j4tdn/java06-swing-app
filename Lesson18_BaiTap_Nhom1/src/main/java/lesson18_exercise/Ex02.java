/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUntils;

/**
 *
 * @author SMILE ^^
 */
public class Ex02 extends JFrame {

    private static final String APP_TITLE = "String App";
    private static final String APP_ICON = "D:\\Java\\images\\48px_love.png";
    private static final int APP_WIDTH = 540;
    private static final int APP_HEIGHT = 450;

    private static final int VERITICAL_PADDING = 40;
    private static final int HORIZONTAL_PADDING = 80;
    private static final int INITTIAL_HEADER_X_PADDING = 40;
    private static final int INITTIAL_HEADER_Y_PADDING = 30;
    private static final int BUTTON_WIDTH = 80;

    private final Container con = getContentPane();

    private JLabel lbInput;
    private JTextField tfInput;
    private JLabel lbRun;
    private JComboBox jcbMethod;
    private JLabel lbResult;
    private JTextArea taResult;

    private JButton btRun;
    private JButton btReset;
    private JButton btExit;

    public Ex02() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.setVisible(true);

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(APP_TITLE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(ImageUtils.load(APP_ICON));

        con.setLayout(null);
        con.setBackground(Color.CYAN);

        lbInput = new JLabel("Nhập chuỗi: ");
        lbInput.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                SizeUntils.getPreWidth(lbInput), SizeUntils.getPreHeight(lbInput));

        con.add(lbInput);

        tfInput = new JTextField(35);
        tfInput.setBounds(INITTIAL_HEADER_X_PADDING + SizeUntils.getWidth(lbInput),
                lbInput.getY(), SizeUntils.getPreWidth(tfInput),
                SizeUntils.getPreHeight(tfInput));

        con.add(tfInput);

        lbRun = new JLabel("Thực hiện: ");
        lbRun.setBounds(lbInput.getX(),
                lbInput.getY() + VERITICAL_PADDING + SizeUntils.getHeight(lbInput),
                SizeUntils.getWidth(lbInput), SizeUntils.getPreHeight(lbRun));

        con.add(lbRun);

        String[] methods = {"Đếm từ", "Đếm từ trùng lặp", "Đếm sang tiếng việt không dấu"};
        jcbMethod = new JComboBox(methods);
        jcbMethod.setBounds(tfInput.getX(), lbRun.getY(),
                SizeUntils.getPreWidth(jcbMethod), SizeUntils.getPreHeight(jcbMethod));

        con.add(jcbMethod);

        lbResult = new JLabel("Kết quả: ");
        lbResult.setBounds(lbInput.getX(),
                lbRun.getY() + VERITICAL_PADDING + SizeUntils.getHeight(lbRun),
                SizeUntils.getWidth(lbInput), SizeUntils.getPreHeight(lbResult));

        con.add(lbResult);

        taResult = new JTextArea(10, 35);
        taResult.setBounds(tfInput.getX(), lbResult.getY(),
                SizeUntils.getPreWidth(taResult), SizeUntils.getPreHeight(taResult));
        taResult.setEditable(false);
        con.add(taResult);

        btRun = new JButton("Run");
        btRun.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btRun.setBounds(INITTIAL_HEADER_X_PADDING * 2,
                SizeUntils.getHeight(taResult) + taResult.getY() + VERITICAL_PADDING,
                BUTTON_WIDTH, SizeUntils.getPreHeight(btRun));
        btRun.setFocusPainted(false);

        con.add(btRun);

        btReset = new JButton("Reset");
        btReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btReset.setBounds(btRun.getX() + SizeUntils.getWidth(btRun) + HORIZONTAL_PADDING,
                btRun.getY(), BUTTON_WIDTH, SizeUntils.getPreHeight(btReset));
        btReset.setFocusPainted(false);

        con.add(btReset);

        btExit = new JButton("Exit");
        btExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btExit.setBounds(btReset.getX() + SizeUntils.getWidth(btReset) + HORIZONTAL_PADDING,
                btRun.getY(), BUTTON_WIDTH, SizeUntils.getPreHeight(btExit));
        btExit.setFocusPainted(false);

        con.add(btExit);

    }

    private void initEvents() {
        tfInputEvents();
        btRunEvents();
        btResetEvents();
        btExitEvents();
    }

    private void btRunEvents() {

        Font btRunFont = btRun.getFont();
        btRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlightFont = new Font(btRunFont.getFontName(), Font.BOLD, btRunFont.getSize());
                btRun.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btRun.setFont(btRunFont);
            }

        });

    }

    private void btResetEvents() {

        Font btResetFont = btReset.getFont();
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfInput.setText("");
                taResult.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlightFont = new Font(btResetFont.getFontName(), Font.BOLD, btResetFont.getSize());
                btReset.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btReset.setFont(btResetFont);
            }

        });

    }

    private void btExitEvents() {
        Font btExitFont = btExit.getFont();
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlightFont = new Font(btExitFont.getFontName(), Font.BOLD, btExitFont.getSize());
                btExit.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btExit.setFont(btExitFont);
            }

        });
    }

    private static String convertSignedToUnsigned(String signedString) {
        String unsignedString;
        unsignedString = signedString.replaceAll("[ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠ]", "A");
        unsignedString = unsignedString.replaceAll("[ắằẳẵặăấầẩẫậâáàãảạ]", "a");

        unsignedString = unsignedString.replaceAll("Đ", "D");
        unsignedString = unsignedString.replaceAll("đ", "d");

        unsignedString = unsignedString.replaceAll("[ẾỀỂỄỆÊÉÈẺẼẸ]", "E");
        unsignedString = unsignedString.replaceAll("[ếềểễệêéèẻẽẹ]", "e");

        unsignedString = unsignedString.replaceAll("[ÍÌỈĨỊ]", "I");
        unsignedString = unsignedString.replaceAll("[íìỉĩị]", "i");

        unsignedString = unsignedString.replaceAll("[ỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌ]", "O");
        unsignedString = unsignedString.replaceAll("[ốồổỗộôớờởỡợơóòõỏọ]", "o");

        unsignedString = unsignedString.replaceAll("[ỨỪỬỮỰƯÚÙỦŨỤ]", "U");
        unsignedString = unsignedString.replaceAll("[ứừửữựưúùủũụ]", "u");

        unsignedString = unsignedString.replaceAll("[ÝỲỶỸỴ]", "Y");
        unsignedString = unsignedString.replaceAll("[ýỳỷỹỵ]", "y");
        return unsignedString;
    }

    private void tfInputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    run();
                }
            }

        });
    }

    private void run() {
        if (tfInput.getText().equals("")) {
            JOptionPane.showMessageDialog(con, "Please input a string!");

        } else {
            int index = jcbMethod.getSelectedIndex();
            String input = tfInput.getText();
            StringBuilder sb = new StringBuilder();
            switch (index) {
                case 0: {
                    long countedWords = Pattern.compile("\\s").splitAsStream(input.trim()).count();
                    sb.append(String.valueOf(countedWords)).append(" từ");
                    break;
                }
                case 1: {
                    Pattern.compile("\\s").splitAsStream(input.trim())
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet()
                            .forEach(t -> sb.append(t.getKey()).append(": ").append(t.getValue()).append(" lần\n"));
                    break;
                }
                case 2: {
                    sb.append(convertSignedToUnsigned(input));
                    break;
                }
            }
            taResult.setText(sb.toString());
        }
    }
}
