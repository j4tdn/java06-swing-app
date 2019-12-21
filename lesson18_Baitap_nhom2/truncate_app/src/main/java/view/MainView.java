package view;

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
import utils.ImageUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{

    private static final int TRUNCATE_APP_WIDTH = 500;
    private static final int TRUNCATE_APP_HEIGHT = 300;
    private static final String TRUNCATE_APP_TITLE = "Truncate Numbers";
    private static final String TRUNCATE_APP_TITLE_IMAGE = "D:\\Java\\truncate_app\\src\\main\\java\\images\\48px_love.png";
    private static final int INITIAL_PADDING_X = 140;
    private static final int INITIAL_PADDING_Y = 50;
    
    private final JLabel lbTitle = new JLabel();
    private final JLabel lbInput = new JLabel();
    private final JTextField tfInput = new JTextField();
    private final JLabel lbOutput = new JLabel();
    private final JTextField tfOutput = new JTextField();
    private final JButton btExecute = new JButton();
    
    private final Container conn = getContentPane();
    
    public MainView() {
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(TRUNCATE_APP_TITLE);
        setIconImage(ImageUtils.load(TRUNCATE_APP_TITLE_IMAGE));
        setSize(TRUNCATE_APP_WIDTH, TRUNCATE_APP_HEIGHT);
        setLocationRelativeTo(null);
        
        conn.setBackground(Color.GRAY);
        conn.setLayout(null);
        
        setLbTitleView();
        setLbInputView();
        setTfInputView();
        setBtExecuteView();
        setLbOutputView();
        setTfOutputView();
        
        conn.add(lbTitle);
        conn.add(lbInput);
        conn.add(tfInput);
        conn.add(lbOutput);
        conn.add(tfOutput);
        conn.add(btExecute);
        
        
    }

    private void setLbTitleView() {
        String title = "TRUNCATE - NUMBER";
        
        lbTitle.setText(title);
        lbTitle.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 25));
        lbTitle.setBounds(INITIAL_PADDING_X, 
                INITIAL_PADDING_Y, 
                getPreWidth(lbTitle), 
                getPreHeight(lbTitle));
        lbTitle.setForeground(Color.PINK);
    }

    private void setLbInputView() {
        final String inputText = "Nhap day so: ";
        
        lbInput.setText(inputText);
        lbInput.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 20));
        lbInput.setBounds(INITIAL_PADDING_X - getPreWidth(lbInput) - 10, 
                getLocationY(lbTitle) + getHeight(lbTitle) + 10,
                getPreWidth(lbInput), 
                getPreHeight(lbInput));
    }

    private void setTfInputView() {
        tfInput.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 20));
        tfInput.setColumns(1);
        tfInput.setBounds(INITIAL_PADDING_X, 
                getLocationY(lbTitle) + getHeight(lbTitle) + 10, 
                getWidth(lbTitle),
                getHeight(lbInput));
    }

    private void setLbOutputView() {
        String outputText = "Ket qua";
        
        lbOutput.setText(outputText);
        lbOutput.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 20));
        lbOutput.setBounds(INITIAL_PADDING_X - getPreWidth(lbOutput) - 10, 
                getLocationY(btExecute) + getHeight(btExecute) + 10, 
                getPreWidth(lbOutput), 
                getPreHeight(lbOutput));
    }

    private void setTfOutputView() {
        tfOutput.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 20));
        tfOutput.setColumns(1);
        tfOutput.setEditable(false);
        tfOutput.setBounds(INITIAL_PADDING_X, 
                getLocationY(btExecute) + getHeight(btExecute) + 10, 
                getWidth(lbTitle), 
                getHeight(lbOutput));
    }
    
    private void setBtExecuteView() {
        String text = "Thuc hien";
        
        btExecute.setText(text);
        btExecute.setFont(new Font("Tw Cen MT Bold", Font.PLAIN, 20));
        btExecute.setBounds(INITIAL_PADDING_X + (getPreWidth(lbTitle) - getPreWidth(btExecute)) / 2, 
                getLocationY(lbInput) + getHeight(lbInput) + 10, 
                getPreWidth(btExecute), 
                getPreHeight(btExecute));
        btExecute.setFocusPainted(false);
    }

    private int getPreWidth(Component component) {
        return (int) component.getPreferredSize().getWidth();
    }
    
    private int getPreHeight(Component component) {
        return (int) component.getPreferredSize().getHeight();
    }

    private int getWidth(Component component) {
        return (int) component.getWidth();
    }
    
    private int getHeight(Component component) {
        return (int) component.getHeight();
    }
    
    private int getLocationY(Component component){
        return (int) component.getLocation().getY();
    }

    private void initEvents() {
        setBtExecuteEvents();
        setTfInputEvents(); 
    }

    private void setBtExecuteEvents() {
        btExecute.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String input = tfInput.getText();
                
                if(input.isBlank() || input.matches(".*[^0123456789, ]+.*")){
                    tfOutput.setText("Du lieu khong hop le!");
                    return;
                }
                
                String output = distinctNumbers(input);
                tfOutput.setText(output);
            }
        });
    }
    
    private String distinctNumbers(String input){
        StringBuilder output = new StringBuilder();
        try {
            Pattern.compile(",")
                .splitAsStream(input)
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .distinct()
                .forEach(number -> output.append(number).append(","));
        } catch (NumberFormatException e) {
            return "Du lieu khong hop le!";
        }
        
        
        String outputString = output.toString();
        return (outputString.substring(0, outputString.length() - 1));
    } 

    private void setTfInputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String input = tfInput.getText();
                
                if(input.isBlank() || input.matches(".*[^0123456789, ]+.*")){
                    tfOutput.setText("Du lieu khong hop le!");
                    return;
                }
                
                String output = distinctNumbers(input);
                tfOutput.setText(output);
                }
            }
        });
    }
}
