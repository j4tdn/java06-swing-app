package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import util.ImageUtils;
import util.SizeUtils;

/**
 *
 * @author VO DINH DUNG
 */
public class Ex011 extends JFrame {

    private static final String Ex01_ICON = "E:\\64px_flower.png";
    private static final String Ex01_TITLE = "Ex01_Truncate";
    private static final int Ex01_WIDTH = 540;
    private static final int Ex01_HEIGHT = 480;

    private final Container conn = getContentPane();
    private JLabel labelHeader;
    private JLabel labelInput;
    private JLabel labelResult;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btSubmit;

    public Ex011() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex011 ex01 = new Ex011();
        ex01.setVisible(true);
    }

    private void initComponents() {
        // DEFAULT
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(Ex01_TITLE);
        setIconImage(ImageUtils.load(Ex01_ICON));
        setSize(Ex01_WIDTH, Ex01_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        conn.setBackground(Color.WHITE);
        conn.setLayout(null);

        final int VERTICAL_PADDING = 30;
        final int INITIAL_HEADER_X_PADDING = 100;
        final int INITIAL_HEADER_Y_PADDING = 30;

        labelHeader = new JLabel();
        labelHeader.setText("TRUNCATE_NUMBER");
        labelHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
        labelHeader.setBounds(INITIAL_HEADER_X_PADDING, INITIAL_HEADER_Y_PADDING,
                SizeUtils.getPreWidth(labelHeader), SizeUtils.getPreHeight(labelHeader));
        conn.add(labelHeader);

        final int INITIAL_X_PADDING = 20;
        final int INITIAL_Y_PADDING = 100;
        labelInput = new JLabel();
        labelInput.setText("Nhập dãy số : ");
        labelInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelInput.setBounds(INITIAL_X_PADDING, INITIAL_Y_PADDING,
                SizeUtils.getPreWidth(labelInput), SizeUtils.getPreHeight(labelInput));
        conn.add(labelInput);

        labelResult = new JLabel();
        labelResult.setText("Kết quả : ");
        labelResult.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelResult.setBounds(INITIAL_X_PADDING + 20, INITIAL_Y_PADDING + 100,
                SizeUtils.getPreWidth(labelResult), SizeUtils.getPreHeight(labelResult));
        conn.add(labelResult);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setBounds(INITIAL_HEADER_X_PADDING + 50,
                INITIAL_HEADER_Y_PADDING + VERTICAL_PADDING +25,
                SizeUtils.getWidth(labelHeader),
                36);
        conn.add(tfInput);

        btSubmit = new JButton();
        btSubmit.setFocusPainted(false);
        btSubmit.setText("Thực hiện");
        btSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSubmit.setBounds(INITIAL_HEADER_X_PADDING + 300,
                INITIAL_HEADER_Y_PADDING-32 + VERTICAL_PADDING * 6,
                SizeUtils.getPreWidth(labelHeader) / 2,
                36);
        conn.add(btSubmit);

        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfOutput.setBounds(INITIAL_X_PADDING + 60 + SizeUtils.getWidth(labelResult),
                INITIAL_HEADER_Y_PADDING + VERTICAL_PADDING
                + SizeUtils.getWidth(labelInput)+20,
                SizeUtils.getWidth(labelHeader), 36);
        conn.add(tfOutput);

    }

    private void initEvents() {
        btSubmitEvents();
        tfOutputEvents();
    }

    private void tfOutputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfInput.setText(convertextToNumber(tfInput.getText()));
                }
            }
        });
    }

    private void btSubmitEvents() {
        Font btSubmitFont = btSubmit.getFont();
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(convertextToNumber(tfInput.getText()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font hightlightFont = new Font(btSubmitFont.getName(), Font.BOLD, btSubmitFont.getSize());
                btSubmit.setFont(hightlightFont);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btSubmit.setFont(btSubmitFont);
            }
        });
    }

    private String convertextToNumber(String input) {
        String[] arr = input.split("\\,");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (isUnique(arr, arr[i])) {
                result += arr[i] + " ";
            }
        }
        return result;
    }

    private static boolean isUnique(String[] arr, String s) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.equals(arr[i])) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

}
