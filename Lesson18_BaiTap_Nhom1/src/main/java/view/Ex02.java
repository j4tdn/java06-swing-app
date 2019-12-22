/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author phanv
 */
public class Ex02 extends JFrame {

    private static final String TEXT_CONVERTION_APP_TITILE = "Xử lí chuỗi";
    private static final String[] TEXT_CONVERTION_APP_METHOD = {"Đếm từ", "Đếm từ trùng lặp", "Chuyển sang tiếng việt không dấu"};
    private static final int TEXT_CONVERTION_APP_WIDTH = 500;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 500;
    private final Container conn = getContentPane();
    private JLabel lbInput;
    private JLabel lbMethod;
    private JLabel lbResult;
    private JTextField tfInput;
    private JComboBox<String> cbMethod;
    private JTextArea taResult;
    private JButton btView;
    private JButton btReset;
    private JButton btExit;

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.setVisible(true);
    }

    public Ex02() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setTitle(TEXT_CONVERTION_APP_TITILE);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setLayout(null);

        lbInput = new JLabel("Nhập chuỗi:");
        lbInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbInput.setBounds(50, 50, SizeUtils.getPreWidth(lbInput), SizeUtils.getPreHeight(lbInput));
        conn.add(lbInput);

        lbMethod = new JLabel("Thực hiện:");
        lbMethod.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbMethod.setBounds(50, 100, SizeUtils.getPreWidth(lbMethod), SizeUtils.getPreHeight(lbMethod));
        conn.add(lbMethod);

        lbResult = new JLabel("Kết quả:");
        lbResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbResult.setBounds(50, 150, SizeUtils.getPreWidth(lbResult), SizeUtils.getPreHeight(lbResult));
        conn.add(lbResult);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tfInput.setBounds(150, 50, 300, 20);
        conn.add(tfInput);

        cbMethod = new JComboBox<>(TEXT_CONVERTION_APP_METHOD);
        cbMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cbMethod.setBounds(150, 100, 200, 20);
        conn.add(cbMethod);

        taResult = new JTextArea();
        taResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        taResult.setEditable(false);
        taResult.setBounds(150, 150, 300, 200);
        conn.add(taResult);

        btReset = new JButton("Reset");
        btReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btReset.setFocusPainted(false);
        btReset.setBounds(220, 400, SizeUtils.getPreWidth(btReset), SizeUtils.getPreHeight(btReset));
        conn.add(btReset);

        btView = new JButton("View");
        btView.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btView.setFocusPainted(false);
        btView.setBounds(70, 400, SizeUtils.getPreWidth(btReset), SizeUtils.getPreHeight(btReset));
        conn.add(btView);

        btExit = new JButton("Exit");
        btExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btExit.setFocusPainted(false);
        btExit.setBounds(370, 400, SizeUtils.getPreWidth(btReset), SizeUtils.getPreHeight(btReset));
        conn.add(btExit);

    }

    private void initEvents() {
        btResetEvent();
        btExitEvent();
        btViewEvent();
    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfInput.setText("");
                taResult.setText("");
            }

        });
    }

    private void btExitEvent() {
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

        });
    }

    private void btViewEvent() {
        btView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFieldIsEmpty();
                switch (cbMethod.getSelectedIndex()) {
                    case 0:
                        taResult.setText("Số từ: " + countWords(tfInput.getText()));
                        break;
                    case 1:
                        taResult.setText(convertMapToString(countDuplicate(tfInput.getText())));
                        break;
                    case 2:
                        taResult.setText(convert(tfInput.getText()));
                        break;
                    default:
                        break;
                }
            }

        });
    }

    private void textFieldIsEmpty() {
        if (tfInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ", "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private int countWords(String str) {
        return Pattern.compile("\\s+").split(str).length;
    }

    private Map<String, Integer> countDuplicate(String str) {
        Map<String, Integer> result = new LinkedHashMap<>();
        String[] temp = Pattern.compile("\\s+").split(str);
        for (String word : temp) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
               result.put(word, 1);
            }
        }
        return result;
    }

    private String convert(String str) {
        String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    private String convertMapToString(Map<String, Integer> map) {
        String result = "";
        result = map.entrySet().stream().map((entry) -> entry.getKey() + " : " + entry.getValue() + "\n").reduce(result, String::concat);
        return result;
    }

}
