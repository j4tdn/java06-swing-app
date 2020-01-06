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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import object.MultipleChoiceQuestion;
import utils.ImageUtils;
import utils.MCQUtils;
import utils.SizeUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{
    private final String APP_ICON = "";
    private final int APP_WIDTH = 600;
    private final int APP_HEIGHT = 400;
    private final int INITIAL_PADDING_X = 50;
    private final int INITIAL_PADDING_Y = 50;
    private final List<MultipleChoiceQuestion> data = MCQUtils.initData();
    private int questionIndex = -1;
    private int numberOfRightAnswer = 0;
    
    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final FlowLayout flowLayout = new FlowLayout();
    
    private JPanel pnContent;
    private JPanel pnBottom;
    private JLabel lbQuestion;
    private List<JRadioButton> rbChoices = new ArrayList<>();
    private JButton btNext;
    private JButton btBookmark;
    private JButton btStart;
    private ButtonGroup rbChoicesGroup;
    private JLabel lbResult;

    public MainView(String title){
        super(title);
        
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        MainView mainView = new MainView("Multiple Choice Question");
        mainView.setVisible(true);
    }

    private void initComponents() {
        setSize(APP_WIDTH, APP_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load(APP_ICON));
        
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);

        btStart = new JButton();
        btStart.setFocusPainted(false);
        btStart.setText("START");
        btStart.setFont(new Font("Tahoma", Font.BOLD, 20));
        btStart.setBounds((APP_WIDTH - SizeUtils.getPreWidth(btStart) * 2) / 2, 
                (APP_HEIGHT - SizeUtils.getPreHeight(btStart) * 2) / 2, 
                SizeUtils.getPreWidth(btStart) * 2, 
                SizeUtils.getPreHeight(btStart) * 2);
        
        container.add(btStart);
    }

    private void initEvents() {
        initBtStartEvents();
    }

    private void initBtStartEvents() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initTestView();
                initBtNextEvents();
                initBtBookmarkEvents();
                revalidate();
            }
            
        });
    }
    
    private void initTestView(){
        container.removeAll();
        container.setLayout(borderLayout);
        
        initContentComponents();
        initBottomComponents();
        
        container.add(pnContent, BorderLayout.CENTER);
        container.add(pnBottom, BorderLayout.SOUTH);
    }
    
    private void initContentComponents() {
        pnContent = new JPanel();
        pnContent.setLayout(null);
        pnContent.setPreferredSize(new Dimension(0, 300));
        
        setNewQuestion();
    }
    
    private void initBottomComponents() {
        pnBottom = new JPanel();
        flowLayout.setHgap(50);
        pnBottom.setLayout(flowLayout);
        pnBottom.setPreferredSize(new Dimension(0, 100));
        
        btNext = new JButton();
        btNext.setText("NEXT");
        btNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btNext.setFocusPainted(false);
        pnBottom.add(btNext);
        
        btBookmark = new JButton();
        btBookmark.setText("BOOKMARK");
        btBookmark.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btBookmark.setFocusPainted(false);
        pnBottom.add(btBookmark);
    }

    private void initBtNextEvents() {
        btNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for(int i = 0; i < rbChoices.size(); i++){
                    if(rbChoices.get(i).isSelected()){
                        if(i == data.get(questionIndex).getAnswer()){
                            numberOfRightAnswer++;
                        }

                        setNewQuestion();
                        break;
                    }
                }
            }
        });
    }
    
    private void setNewQuestion(){
        questionIndex++;
        
        if(questionIndex == data.size()){
            showResult();
            return;
        }
        
        pnContent.removeAll();
        pnContent.repaint();
        rbChoices = new ArrayList<>();
        
        lbQuestion = new JLabel();
        String question = "Question " + (questionIndex + 1) + ": " + data.get(questionIndex).getQuestion();
        lbQuestion.setText(question);
        lbQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbQuestion.setBounds(INITIAL_PADDING_X, 
                INITIAL_PADDING_Y, 
                SizeUtils.getPreWidth(lbQuestion), 
                SizeUtils.getPreHeight(lbQuestion));
        
        pnContent.add(lbQuestion);
        
        // init anwers view
        int x = lbQuestion.getLocation().x;
        int y = lbQuestion.getLocation().y + SizeUtils.getPreHeight(lbQuestion) + 20;
        rbChoicesGroup = new ButtonGroup();
        List<String> choices = data.get(questionIndex).getChoices();
        for(int i = 0; i < choices.size(); i++){
            JRadioButton rbChoice = new JRadioButton();
            rbChoice.setFocusPainted(false);
            rbChoice.setText(choices.get(i));
            rbChoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
            rbChoice.setBounds(x, 
                    y, 
                    SizeUtils.getPreWidth(rbChoice), 
                    SizeUtils.getPreHeight(rbChoice));
            
            y += SizeUtils.getPreHeight(rbChoice);
            rbChoicesGroup.add(rbChoice);
            pnContent.add(rbChoice);
            rbChoices.add(rbChoice);
        }
        
        pnContent.validate();
    }

    private void initBtBookmarkEvents() {
        btBookmark.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setNewQuestion();
            }
        });
    }

    private void showResult() {
        container.removeAll();
        container.repaint();
        container.setLayout(null);
        
        lbResult = new JLabel();
        String result = "Số câu trả lời đúng: " + numberOfRightAnswer;
        lbResult.setText(result);
        lbResult.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbResult.setBounds((APP_WIDTH - SizeUtils.getPreWidth(lbResult)) / 2, 
                (APP_HEIGHT - SizeUtils.getPreHeight(lbResult)) / 2, 
                SizeUtils.getPreWidth(lbResult), 
                SizeUtils.getPreHeight(lbResult));
        
        container.add(lbResult);
        revalidate();
    }
    
}
