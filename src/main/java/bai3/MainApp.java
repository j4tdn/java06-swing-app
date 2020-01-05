/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author PC
 */
public class MainApp extends JFrame {

    private QuestionAnswer questionAnswer;
    private QuestionAnswer[] questionAnswers;
    private MultipleChoicePanel multipleChoicePanels;
    private JButton btNext, btBookMark;
    private Container container = getContentPane();
    private JPanel pnButton;
    private JPanel pnChoice;
    private JLabel lbScore;
    private int count = 0;

    public MainApp() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        container.setLayout(new BorderLayout());
        initComponent();
        initEvents();

    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.setVisible(true);
    }

    private void initComponent() {
        pnChoice = new JPanel();
        lbScore = new JLabel("START");
        lbScore.setFont(new Font("Tahoma", 2, 30));
        pnChoice.add(lbScore);
        container.add(pnChoice, BorderLayout.CENTER);
        btNext = new JButton("NEXT");
        btNext.setVisible(false);
        btBookMark = new JButton("OK");
        pnButton = new JPanel(new GridLayout(1, 2, 200, 0));
        pnButton.add(btNext);
        pnButton.add(btBookMark);
        container.add(pnButton, BorderLayout.SOUTH);
    }

    private void initEvents() {
        btBookMark.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btNext.setVisible(true);
                btBookMark.setText("BOOKMARK");
                count++;
                if (count < initQuestionAnswers().length) {
                    pnChoice.revalidate();
                    pnChoice = new JPanel();
                    pnChoice.add(initMultipleChoicePanel(initQuestionAnswers()[count]));
                    //AbstractButton button = (AbstractButton) initMultipleChoicePanel(initQuestionAnswers()[count]).bg.getElements();
                    container.add(pnChoice, BorderLayout.CENTER);
                    System.out.println("question " + count );
                } else if (count == initQuestionAnswers().length) {
                    pnChoice.revalidate();
                    pnChoice = new JPanel();
                    lbScore = new JLabel("SCORE");
                    lbScore.setFont(new Font("Tahoma", 2, 30));
                    pnChoice.add(lbScore);
                    container.add(pnChoice, BorderLayout.CENTER);
                    btNext.setVisible(false);
                    btBookMark.setText("EXIT");
                    System.out.println("question " + count);
                } else {
                    System.exit(0);
                }
            }

        });
    }
    

    private MultipleChoicePanel initMultipleChoicePanel(QuestionAnswer questionAnswer) {
        multipleChoicePanels = new MultipleChoicePanel(questionAnswer);
        return multipleChoicePanels;
    }

    private QuestionAnswer[] initQuestionAnswers() {
        QuestionAnswer questionAnswer1 = new QuestionAnswer("What is the result of the addiction between one and one?", "1", "2", "3", "4");
        QuestionAnswer questionAnswer2 = new QuestionAnswer("What is the most famous song of Alan Walker?", "Spectre", "Fade", "Alone", "Dark Side");
        QuestionAnswer questionAnswer3 = new QuestionAnswer("What is the name of C2H5NH2?", "Ethylamine", "Methanol", "Methylamine", "Ethane");
        QuestionAnswer questionAnswer4 = new QuestionAnswer("What is the formula of Newton II law?", "E=MC^2", "U=I*R", "F=m*a", "a^2=b^2+c^2");
        QuestionAnswer questionAnswer5 = new QuestionAnswer("Who is Quyen N. Phan?", "Teacher", "Coder", "Vlogger", "Shipper");
        questionAnswers = new QuestionAnswer[]{null, questionAnswer1, questionAnswer2, questionAnswer3, questionAnswer4, questionAnswer5};
        return questionAnswers;
    }
}
