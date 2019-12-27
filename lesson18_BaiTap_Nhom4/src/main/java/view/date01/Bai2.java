/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.date01;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author PC
 */
public class Bai2 extends JFrame {

    private static final String TEXT_APP_ICON = "E:\\GiaoTrinhHocTap\\Java\\64px_flower.png";
    private static final String TEXT_APP_TITLE = "Text - app";
    private static final String TEXT_INPUT = "Nhập chuỗi:";
    private static final String TEXT_COMBOBOX = "Thực hiện:";
    private static final String TEXT_OUTPUT = "Kết quả:";
    private static final String TEXT_VIEW = "View";
    private static final String TEXT_RESET = "Reset";
    private static final String TEXT_EXIT = "Exit";
    private static final String TEXT_SELECT1 = "ĐẾM TỪ";
    private static final String TEXT_SELECT2 = "ĐẾM TỪ TRÙNG LẶP";
    private static final String TEXT_SELECT3 = "CHUYỂN SANG TIẾNG VIỆT KHÔNG GIẤU";
    private static final int TEXT_APP_WIDTH = 650;
    private static final int TEXT_APP_HEIGHT = 600;
    private final Container conn = getContentPane();

    private JLabel lbInput;
    private JLabel lbComboBox;
    private JLabel lbOutput;
    private JTextField tfInput;
    private JComboBox comboBox;
    private JTextArea taOutput;
    private JButton btView;
    private JButton btReset;
    private JButton btExit;

    public Bai2() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Bai2 textApp = new Bai2();
        textApp.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(TEXT_APP_WIDTH, TEXT_APP_HEIGHT);
        setTitle(TEXT_APP_TITLE);
        setIconImage(ImageUtils.load(TEXT_APP_ICON));
        setLocationRelativeTo(null);
        setResizable(false);
        conn.setLayout(null);

        final int INITIAL_HEADER_X_PADDING = 50;
        final int INITIAL_HEADER_Y_PADDING = 40;
        lbInput = new JLabel();
        lbInput.setText(TEXT_INPUT);
        lbInput.setFont(new Font("arial", Font.BOLD, 20));
        lbInput.setBounds(INITIAL_HEADER_X_PADDING, INITIAL_HEADER_Y_PADDING,
                getPreWidth(lbInput),
                getPreHeight(lbInput));
        conn.add(lbInput);

        tfInput = new JTextField();
        tfInput.setFont(new Font("arial", Font.BOLD, 20));
        tfInput.setBounds(2 * INITIAL_HEADER_X_PADDING + getPreWidth(lbInput), INITIAL_HEADER_Y_PADDING - 5,
                TEXT_APP_WIDTH - 3 * INITIAL_HEADER_X_PADDING - getPreWidth(lbInput),
                INITIAL_HEADER_Y_PADDING);
        conn.add(tfInput);

        lbComboBox = new JLabel();
        lbComboBox.setText(TEXT_COMBOBOX);
        lbComboBox.setFont(new Font("arial", Font.BOLD, 20));
        lbComboBox.setBounds(INITIAL_HEADER_X_PADDING, 2 * INITIAL_HEADER_Y_PADDING + getPreHeight(lbInput),
                getPreWidth(lbComboBox),
                getPreHeight(lbComboBox));
        conn.add(lbComboBox);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("arial", Font.BOLD, 18));
        comboBox.setBounds(2 * INITIAL_HEADER_X_PADDING + getPreWidth(lbInput), 2 * INITIAL_HEADER_Y_PADDING + getPreHeight(lbComboBox) - 5,
                TEXT_APP_WIDTH - 3 * INITIAL_HEADER_X_PADDING - getPreWidth(lbInput),
                INITIAL_HEADER_Y_PADDING);
        comboBox.addItem(TEXT_SELECT1);
        comboBox.addItem(TEXT_SELECT2);
        comboBox.addItem(TEXT_SELECT3);
        conn.add(comboBox);

        lbOutput = new JLabel();
        lbOutput.setText(TEXT_OUTPUT);
        lbOutput.setFont(new Font("arial", Font.BOLD, 20));
        lbOutput.setBounds(INITIAL_HEADER_X_PADDING, 3 * INITIAL_HEADER_Y_PADDING + 2 * getPreHeight(lbComboBox),
                getPreWidth(lbOutput),
                getPreHeight(lbOutput));
        conn.add(lbOutput);

        taOutput = new JTextArea();
        taOutput.setFont(new Font("arial", Font.BOLD, 20));
        taOutput.setBounds(2 * INITIAL_HEADER_X_PADDING + getPreWidth(lbInput), 3 * INITIAL_HEADER_Y_PADDING + 2 * getPreHeight(lbOutput) - 5,
                TEXT_APP_WIDTH - 3 * INITIAL_HEADER_X_PADDING - getPreWidth(lbInput),
                7 * INITIAL_HEADER_Y_PADDING);
        conn.add(taOutput);

        btView = new JButton();
        btView.setFont(new Font("arial", Font.PLAIN, 18));
        btView.setText(TEXT_VIEW);
        btView.setFocusPainted(false);
        btView.setBounds(2 * INITIAL_HEADER_X_PADDING, TEXT_APP_HEIGHT - INITIAL_HEADER_Y_PADDING - 2 * getPreHeight(btView), getPreWidth(btView) + 10, getPreHeight(btView));
        conn.add(btView);

        btReset = new JButton();
        btReset.setText(TEXT_RESET);
        btReset.setFont(new Font("arial", Font.PLAIN, 18));
        btReset.setFocusPainted(false);
        btReset.setBounds(5 * INITIAL_HEADER_X_PADDING, TEXT_APP_HEIGHT - INITIAL_HEADER_Y_PADDING - 2 * getPreHeight(btReset), getPreWidth(btReset) + 10, getPreHeight(btReset));
        conn.add(btReset);

        btExit = new JButton();
        btExit.setText(TEXT_EXIT);
        btExit.setFont(new Font("arial", Font.PLAIN, 18));
        btExit.setFocusPainted(false);
        btExit.setBounds(8 * INITIAL_HEADER_X_PADDING, TEXT_APP_HEIGHT - INITIAL_HEADER_Y_PADDING - 2 * getPreHeight(btExit), getPreWidth(btExit) + 10, getPreHeight(btExit));
        conn.add(btExit);
    }

    private int getPreWidth(Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }

    private int getPreHeight(Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }

    private void initEvents() {
        btViewEvents();
        btResetEvents();
        btExitEvents();
    }

    private void btViewEvents() {
        btView.addMouseListener(new MouseAdapter() {
            Font btViewFont = btView.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                if (TEXT_SELECT1.equals(comboBox.getSelectedItem())) {
                    taOutput.setText(tfInput.getText().split("\\s").length + "");

                }
                if (TEXT_SELECT2.equals(comboBox.getSelectedItem())) {
                    String output = "";
                    Map<String, Integer> res = countDuplicateWord(tfInput.getText());
                    output = res.entrySet().stream().map((s) -> s.getKey() + ": " + s.getValue() + " lần" + "\n").reduce(output, String::concat);
                    taOutput.setText(output);
                }
                if (TEXT_SELECT3.equals(comboBox.getSelectedItem())) {
                    char[] lowwerAccentLetters = {'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ',
                        'ậ', 'đ', 'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ơ', 'ờ', 'ớ',
                        'ở', 'ỡ', 'ợ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'ì',
                        'í', 'ỉ', 'ĩ', 'ị', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'};
                    taOutput.setText(convertUnsignedString(tfInput.getText(), lowwerAccentLetters));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btViewFont.getFontName(),
                        Font.BOLD, this.btViewFont.getSize());
                btView.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btView.setFont(btViewFont);
            }
        });
    }

    private void btResetEvents() {
        btReset.addMouseListener(new MouseAdapter() {
            Font btResetFont = btReset.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                tfInput.setText("");
                taOutput.setText("");
                comboBox.setSelectedItem(TEXT_SELECT1);
                tfInput.requestFocus();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btResetFont.getFontName(),
                        Font.BOLD, this.btResetFont.getSize());
                btReset.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btReset.setFont(btResetFont);
            }
        });
    }

    private void btExitEvents() {
        btExit.addMouseListener(new MouseAdapter() {
            Font btExitFont = btExit.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btExitFont.getFontName(),
                        Font.BOLD, this.btExitFont.getSize());
                btExit.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btExit.setFont(btExitFont);
            }
        });
    }

    private static Map<String, Integer> countDuplicateWord(String input) {
        Set<String> set = new HashSet<>();
        String temp[] = input.split("\\s");
        set.addAll(Arrays.asList(temp));
        Map<String, Integer> res = new HashMap<>();
        set.forEach((item) -> {
            res.put(item, countAWord(input, item));
        });
        return res;
    }

    private static int countAWord(String input, String item) {
        int count = 0;
        String[] temp = input.split("\\s");
        for (String i : temp) {
            if (item.equals(i)) {
                count++;
            }
        }
        return count;
    }

    private String convertUnsignedString(String input, char[] lowwerAccentLetters) {
        char[] result = input.toCharArray();
        for (int i = 0; i < result.length; i++) {
            char lowwerLetter = String.valueOf(result[i]).toLowerCase().charAt(0);
            if (Character.isLowerCase(result[i])) {
                result[i] = convertLowwerAlphabetic(lowwerLetter, lowwerAccentLetters);
            } else {
                result[i] = convertUpperAlphabetic(lowwerLetter, lowwerAccentLetters);
            }

        }
        return String.valueOf(result);

    }

    private char convertLowwerAlphabetic(char letter, char[] lowwerAccentLetters) {
        String lowwerAccentLetter = String.valueOf(lowwerAccentLetters);
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('à'), lowwerAccentLetter.indexOf('ậ'))) {
            return 'a';
        }
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('đ'), lowwerAccentLetter.indexOf('đ'))) {
            return 'd';
        }
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('è'), lowwerAccentLetter.indexOf('ệ'))) {
            return 'e';
        }
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('ò'), lowwerAccentLetter.indexOf('ộ'))) {
            return 'o';
        }

        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('ù'), lowwerAccentLetter.indexOf('ự'))) {
            return 'u';

        }
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('ì'), lowwerAccentLetter.indexOf('ị'))) {
            return 'i';
        }
        if (isExist(letter, lowwerAccentLetters, lowwerAccentLetter.indexOf('ỳ'), lowwerAccentLetter.indexOf('ỵ'))) {
            return 'y';
        }
        return letter;
    }

    private char convertUpperAlphabetic(char letter, char[] lowwerAccentLetters) {
        return String.valueOf(convertLowwerAlphabetic(letter, lowwerAccentLetters)).toUpperCase().charAt(0);
    }

    private boolean isExist(char letter, char[] lowwerAccentLetters, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (letter == lowwerAccentLetters[i]) {
                return true;
            }
        }
        return false;
    }

}
