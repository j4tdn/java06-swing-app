/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author MyPC
 */
public class Ex02 extends JFrame {
    
    private static Button btView;
    private static Button btReset;
    private static Button btExit;
    private static JTextArea tableResult;
    private static JComboBox<String> comboBox;
    private static JTextField tableInput;
    
    public static void main(String[] args) {
        Ex02 ex02 =new Ex02();
        ex02.setResizable(false);
        
    }
    
    public Ex02() {
        initComponent();
        initEvents();
        
    }
    
    public static Map<String, Integer> countDuplicate(String input) {
        String[] arr = Pattern.compile("\\s").split(input);
        
        Map<String, Integer> result = new TreeMap<String, Integer>();
        Set<String> setString = new HashSet<String>();
        for (int i = 0; i < arr.length; i++) {
            setString.add(arr[i]);
        }
        List<String> listString = setString.stream().collect(Collectors.toList());
        for (int i = 0; i < setString.size(); i++) {
            String temp = listString.get(i);
            result.put(temp, countWord(temp, input));
        }
        return result;
    }
    
    public static int countWord(String word, String sentence) {
        String[] arr = Pattern.compile("\\s").split(sentence);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (word.equals(arr[i])) {
                result += 1;
            }
        }
        
        return result;
    }
    
    private void initComponent() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        JLabel jlabelInput = new JLabel("Nhập chuỗi");
        jlabelInput.setFont(new Font("arial", Font.BOLD, 14));
        jlabelInput.setBounds(10, 50, 300, 50);
        this.add(jlabelInput);
        
        tableInput = new JTextField();
        tableInput.setFont(new Font("arial", Font.BOLD, 28));
        tableInput.setBounds(100, 50, 300, 50);
        this.add(tableInput);
        int th = 0;
        
        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("arial", Font.BOLD, 20));
        comboBox.setBounds(100, 100, 300, 50);
        comboBox.addItem("Đếm từ");
        comboBox.addItem("Đếm từ trùng lặp");
        comboBox.addItem("Chuỗi không dấu");
        /*
		 * comboBox.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { String temp =(String)
		 * e.getItem(); if(temp.equals("Đếm từ")){ th=0; } else
		 * if(temp.equals("Đếm từ trùng lặp" )) { th=1; }
		 * 
		 * // TODO Auto-generated method stub
		 * 
		 * } });
         */
        this.add(comboBox);
        
        JLabel jlabelResult = new JLabel("Kết quả");
        jlabelResult.setFont(new Font("arial", Font.BOLD, 14));
        jlabelResult.setBounds(10, 150, 300, 50);
        this.add(jlabelResult);
        
        tableResult = new JTextArea();
        tableResult.setFont(new Font("arial", Font.BOLD, 28));
        tableResult.setBounds(100, 170, 300, 300);
        this.add(tableResult);
        
        btView = new Button("View");
        btView.setFont(new Font("arial", Font.BOLD, 20));
        btView.setBounds(50, 500, 100, 50);
        this.add(btView);
        
        btReset = new Button("Reset");
        btReset.setFont(new Font("arial", Font.BOLD, 20));
        btReset.setBounds(250, 500, 100, 50);
        
        this.add(btReset);
        
        btExit = new Button("Exit");
        btExit.setFont(new Font("arial", Font.BOLD, 20));
        btExit.setBounds(450, 500, 100, 50);
        
        this.add(btExit);
        
        this.setVisible(true);
    }
    
    private void initEvents() {
        btViewEvents();
        btResetEvents();
        btExitEvents();
    }
    
    public static String convert(String str) {
        str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
        str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
        str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
        str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
        str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
        str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
        str = str.replaceAll("đ", "d");
        
        str = str.replaceAll("À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ", "A");
        str = str.replaceAll("È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ", "E");
        str = str.replaceAll("Ì|Í|Ị|Ỉ|Ĩ", "I");
        str = str.replaceAll("Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ", "O");
        str = str.replaceAll("Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ", "U");
        str = str.replaceAll("Ỳ|Ý|Ỵ|Ỷ|Ỹ", "Y");
        str = str.replaceAll("Đ", "D");
        return str;
    }
    
    private void btViewEvents() {
        btView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(tableInput.getText().isEmpty()){
                tableResult.setText("Chuỗi rỗng !");
                }
                else{
                if (comboBox.getSelectedIndex() == 0) {
                    String[] arr = Pattern.compile("\\s").split(tableInput.getText().trim());
                    tableResult.setText(arr.length + " từ.");
                } else if (comboBox.getSelectedIndex() == 1) {
                    Map<String, Integer> result = countDuplicate(tableInput.getText());
                    // Set<Entry<String, Integer>> entry = result.entrySet();
                    String res = "";
                    for (Entry<String, Integer> entry : result.entrySet()) {
                        res = res + entry.getKey() + ": " + entry.getValue() + " từ.\n";
                    }
                    tableResult.setText(res);
                    
                } else {
                    String res = convert(tableInput.getText());
                    tableResult.setText(res);
                    
                }
                
            }}
            
        });
        
    }
    
    private void btResetEvents() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tableResult.setText("");
                tableInput.setText("");
                comboBox.setSelectedIndex(0);
                tableInput.requestFocus();
                tableInput.setCaretPosition(1);
                
                
            }
            
        });
    }
    
    private void btExitEvents() {
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
            
        });
    }
    
}
