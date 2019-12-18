/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Choice;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class Bai2 extends JFrame {
    private static final String COMBOBOX_APP_TITLE = "Combobox - app";
    private static final int COMBOBOX_APP_WIDTH = 510;
    private static final int COMBOBOX_APP_HEIGHT = 415;
    
    private final Container conn = getContentPane();
    
    private JButton btView;
    private JButton btReset;
    private JButton btExit;
    private Choice cWork;
    private JTextField tfInput;
    private JTextArea taResult;

    public Bai2() {
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        Bai2 combobox = new Bai2();
        combobox.setVisible(true);
    }
    
    private void initEvents() {
        btView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if("Dem tu".equals(cWork.getItem(cWork.getSelectedIndex()))) {
                    taResult.setText(countWords(tfInput.getText()));
                }
                if("Dem tu trung lap".equals(cWork.getItem(cWork.getSelectedIndex()))) {
                    taResult.setText(duplicateWord(tfInput.getText()));
                }
                if("Chuyen sang Tieng Viet khong dau".equals(cWork.getItem(cWork.getSelectedIndex()))) {
                    taResult.setText(convertToVNChars(tfInput.getText()));
                }
            }
        });
        
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfInput.setText("");
                taResult.setText("");
                tfInput.requestFocus();
                cWork.select(0);
                
            }
        });
        
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
            
        });
    }
    
    private String countWords(String s) {
        String[] inputs = s.split("\\s");
        return String.valueOf(inputs.length);
    }
    
    private String duplicateWord(String s) {
        String result ="";
        List<String> strings = new ArrayList<>(Arrays.asList(s.split("\\s")));
        for (int i = 0; i < strings.size();i++) {
            int count = 1;
            for(int j = strings.size() -1; j >i; j--) {
                if(strings.get(i).equals(strings.get(j))) {
                    count ++;
                    strings.remove(j);
                }
            }
            result += strings.get(i) + ": " + count + " lần\r\n";
        }
        
        return result;
    }
    
    private String convertToVNChars(String s) {
        String result ="";
        String[] vnChars = { "á", "à", "ạ", "ả", "ã", "ă", "ắ", "ằ", "ặ", "ẳ", "ẵ", "â", "ấ", "ầ", "ậ", "ẩ", "ẫ", "é",
				"è", "ẹ", "ẻ", "ẽ", "ê", "ế", "ề", "ệ", "ể", "ễ", "í", "ì", "ị", "ỉ", "ĩ", "ó", "ò", "ọ", "ỏ", "õ", "ô",
				"ố", "ồ", "ộ", "ổ", "ỗ", "ơ", "ớ", "ờ", "ợ", "ở", "ỡ", "ú", "ù", "ụ", "ủ", "ũ", "ư", "ứ", "ừ", "ự", "ử",
				"ữ", "đ", "Á", "À", "Ạ", "Ả", "Ã", "Ă", "Ắ", "Ằ", "Ặ", "Ẳ", "Ẵ", "Â", "Ấ", "Ầ", "Ậ", "Ẩ", "Ẫ", "É", "È",
				"Ẹ", "Ẻ", "Ẽ", "Ê", "Ế", "Ề", "Ệ", "Ể", "Ễ", "Í", "Ì", "Ị", "Ỉ", "Ĩ", "Ó", "Ò", "Ọ", "Ỏ", "Õ", "Ô", "Ố",
				"Ồ", "Ộ", "Ổ", "Ỗ", "Ơ", "Ớ", "Ờ", "Ợ", "Ở", "Ỡ", "Ú", "Ù", "Ụ", "Ủ", "Ũ", "Ư", "Ứ", "Ừ", "Ự", "Ử", "Ữ",
				"Đ" };

	String[] chars = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "e",
				"e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "i", "i", "i", "i", "i", "o", "o", "o", "o", "o", "o",
				"o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "o", "u", "u", "u", "u", "u", "u", "u", "u", "u", "u",
				"u", "d", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "E", "E",
				"E", "E", "E", "E", "E", "E", "E", "E", "E", "I", "I", "I", "I", "I", "O", "O", "O", "O", "O", "O", "O",
				"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
				"D" };

		
	String[] strings = s.split("");

	for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < vnChars.length; j++) {
		if (strings[i].equals(vnChars[j])) {
                    strings[i] = chars[j];
		}
            }
            result += strings[i];
	}
        return result;

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(COMBOBOX_APP_TITLE);
        setSize(COMBOBOX_APP_WIDTH, COMBOBOX_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        final int INITTAL_HEADER_X_PADDING = 40;
        final int INITTAL_HEADER_Y_PADDING = 40;
        //-----------------------------------------------------------
        
        JLabel lbInput = new JLabel();
        lbInput.setText("Nhập chuỗi: ");
        lbInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbInput.setBounds(INITTAL_HEADER_X_PADDING, INITTAL_HEADER_Y_PADDING,
                getPreWidth(lbInput), getPreHeight(lbInput));
        conn.add(lbInput);
        //--------------------------------------------------------
        
        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfInput.setBounds(INITTAL_HEADER_X_PADDING + getPreWidth(lbInput) + 10,
                INITTAL_HEADER_Y_PADDING - 5,
                getPreWidth(lbInput) * 3 , getPreHeight(lbInput) + 10);
        conn.add(tfInput);
        //-------------------------------------------------------
        
        JLabel lbWork = new JLabel();
        lbWork.setText("Thực hiện: ");
        lbWork.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbWork.setBounds(INITTAL_HEADER_X_PADDING, INITTAL_HEADER_Y_PADDING * 2 + getPreHeight(tfInput),
                getPreWidth(lbWork), getPreHeight(lbWork));
        conn.add(lbWork);
        //-------------------------------------------------------------
        
        cWork = new Choice();
        cWork.setFocusable(false);
        cWork.addItem("Dem tu");
        cWork.addItem("Dem tu trung lap");
        cWork.addItem("Chuyen sang Tieng Viet khong dau");
        cWork.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cWork.setBounds(INITTAL_HEADER_X_PADDING + getPreWidth(lbInput) + 10,
                INITTAL_HEADER_Y_PADDING * 2 + getPreHeight(tfInput) - 5
                , getPreWidth(lbInput) * 3 + 10 , 0);
        conn.add(cWork);
        //------------------------------------------------------------
        
        JLabel lbResult = new JLabel();
        lbResult.setText("Kết quả: ");
        lbResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbResult.setBounds(INITTAL_HEADER_X_PADDING,
                INITTAL_HEADER_Y_PADDING * 3 + getPreHeight(lbInput) + getPreHeight(lbWork),
                getPreWidth(lbResult), getPreHeight(lbResult));
        conn.add(lbResult);
        //-------------------------------------------------------------
        
        taResult = new JTextArea();
        taResult.setEditable(false);
        taResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
        taResult.setBounds(INITTAL_HEADER_X_PADDING + getPreWidth(lbInput) + 10,
                INITTAL_HEADER_Y_PADDING * 3 + getPreHeight(lbInput) + getPreHeight(lbWork)
                , getPreWidth(lbInput) * 3 + 10,getPreHeight(lbInput)*6 );
        conn.add(taResult);
        //--------------------------------------------------------------------
        
        btView = new JButton();
        btView.setText("View");
        btView.setFocusPainted(false);
        btView.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btView.setBounds(INITTAL_HEADER_X_PADDING + 20, 
                INITTAL_HEADER_Y_PADDING * 3 + getPreHeight(lbInput) + getPreHeight(lbWork) + getPreHeight(lbInput)*6 + 20,
               getPreWidth(lbWork), getPreHeight(tfInput) + 10);
        conn.add(btView);
        //--------------------------------------------------------------------------------
        
        btReset = new JButton();
        btReset.setText("Reset");
        btReset.setFocusPainted(false);
        btReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btReset.setBounds(INITTAL_HEADER_X_PADDING + getPreWidth(lbWork) + 60,
                INITTAL_HEADER_Y_PADDING * 3 + getPreHeight(lbInput) + getPreHeight(lbWork) + getPreHeight(lbInput)*6 + 20
                , getPreWidth(lbWork), getPreHeight(tfInput) + 10);
        conn.add(btReset);
        //-------------------------------------------------------------------------------
        
        btExit = new JButton();
        btExit.setText("Exit");
        btExit.setFocusPainted(false);
        btExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btExit.setBounds(INITTAL_HEADER_X_PADDING + getPreWidth(lbWork)*2 + 100,
                INITTAL_HEADER_Y_PADDING * 3 + getPreHeight(lbInput) + getPreHeight(lbWork) + getPreHeight(lbInput)*6 + 20,
                getPreWidth(lbWork), getPreHeight(tfInput) + 10);
        conn.add(btExit);
        
    }
    
    private int getPreWidth(Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }
    private int getPreHeight(Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }
}
