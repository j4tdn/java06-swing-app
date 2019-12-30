/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author PC
 */
public class Ex02 extends JFrame {

    private final Container container = getContentPane();
    private final String imageDir = "D:\\java06-swing\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image";
    private Thread imageThread;

    private final String imageDtDir = imageDir + File.separator + "imageDT";
    private final String[] imagesDt = {"DT1.jpg", "DT2.jpg", "DT3.jpg", "DT4.jpg", "DT5.jpg"};
    private final String initialImageDt = imagesDt[0];
    private List<String> listDt = new ArrayList<>();

    private final String imageGDir = imageDir + File.separator + "imageG";
    private final String[] imagesGs = {"G1.jpg", "G2.jpg", "G3.jpg", "G4.jpg", "G5.jpg"};
    private final String initialImageG = imagesGs[0];
    private List<String> listG = new ArrayList<>();

    private final String imageVlDir = imageDir + File.separator + "imageVL";
    private final String[] imagesVl = {"VL1.jpg", "VL2.jpg", "VL3.jpg", "VL4.jpg", "VL5.jpg"};
    private final String initialImageVl = imagesVl[0];
    private List<String> listVl = new ArrayList<>();

    private JButton btStart;
    private JLabel lbDt;
    private JLabel lbG;
    private JLabel lbVl;

    public Ex02() {
        initComponents();
        btStartEvent();

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME ĐÁNH NHAU ");
        setSize(670, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        container.setLayout(null);
        container.setBackground(Color.PINK);

        lbDt = new JLabel();
        Image imageDT = ImageUtils.load(imageDtDir + File.separator + initialImageDt).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbDt.setIcon(new ImageIcon(imageDT));
        lbDt.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbDt.setBounds(30, 20, SizeUtils.getPreWidth(lbDt), SizeUtils.getPreHeight(lbDt));
        container.add(lbDt);

        lbG = new JLabel();
        Image imageG = ImageUtils.load(imageGDir + File.separator + initialImageG).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbG.setIcon(new ImageIcon(imageG));
        lbG.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbG.setBounds(240, 20, SizeUtils.getPreWidth(lbG), SizeUtils.getPreHeight(lbG));
        container.add(lbG);

        lbVl = new JLabel();
        Image imageVL = ImageUtils.load(imageVlDir + File.separator + initialImageVl).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbVl.setIcon(new ImageIcon(imageVL));
        lbVl.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbVl.setBounds(450, 20, SizeUtils.getPreWidth(lbVl), SizeUtils.getPreHeight(lbVl));
        container.add(lbVl);

        btStart = new JButton();
        btStart.setText("START");
        btStart.setFocusPainted(false);
        btStart.setFont(new Font("Tahoma", Font.BOLD, 22));
        btStart.setBounds(300, 300, SizeUtils.getPreWidth(btStart), SizeUtils.getPreHeight(btStart));
        container.add(btStart);

    }

    private void randomMember() {
        random(imageDtDir, imagesDt, lbDt);
        random(imageGDir, imagesGs, lbG);
        random(imageVlDir, imagesVl, lbVl);

    }

    private void random(String dir, String[] image, JLabel label) {
        Random rd = new Random();

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name;
                String nameMembers = image[rd.nextInt(image.length)];
                String pathDt = dir + File.separator + nameMembers;
                System.out.println(changeName(nameMembers));
                Image image = ImageUtils.load(pathDt).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
                sleep(0.1);

            }
        });
        imageThread.start();
    }

    private void btStartEvent() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                randomMember();
=======
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
>>>>>>> 8e981c7f7f09f487de8e91779042e3264aec14db
            }

        });
    }

<<<<<<< HEAD
    private String changeName(String string) {
        if (string.contains(".jpg")) {
            string = string.replace(".jpg", "");
        }
        return string;
    }

    private boolean checkName(List<String> list, String string) {
        for (String name : list) {
            if (string.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.setVisible(true);
=======
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
>>>>>>> 8e981c7f7f09f487de8e91779042e3264aec14db
    }

}
