/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 *
 * @author PC
 */
public class MultipleChoicePanel extends JPanel {

    private JRadioButton rdA, rdB, rdC, rdD;
    private JLabel lbQuestion;
    private JPanel pnAll;
    public ButtonGroup bg;

    public MultipleChoicePanel(QuestionAnswer questionAnswer) {
        initComponent(questionAnswer);
    }

    private void initComponent(QuestionAnswer questionAnswer) {
        pnAll = new JPanel(new GridLayout(5, 1));

        lbQuestion = new JLabel(questionAnswer.getQuestion());
        lbQuestion.setFont(new Font("Tahoma", 2, 30));
        lbQuestion.setPreferredSize(new Dimension(800, 100));
        pnAll.add(lbQuestion);
        
        bg=new ButtonGroup();

        rdA = new JRadioButton(questionAnswer.getAnswerA());
        rdA.setFont(new Font("Tahoma", 2, 30));
        pnAll.add(rdA);
        bg.add(rdA);

        rdB = new JRadioButton(questionAnswer.getAnswerB());
        rdB.setFont(new Font("Tahoma", 2, 30));
        pnAll.add(rdB);
        bg.add(rdB);

        rdC = new JRadioButton(questionAnswer.getAnswerC());
        rdC.setFont(new Font("Tahoma", 2, 30));
        pnAll.add(rdC);
        bg.add(rdC);

        rdD = new JRadioButton(questionAnswer.getAnswerD());
        rdD.setFont(new Font("Tahoma", 2, 30));
        pnAll.add(rdD);
        bg.add(rdD);
        

        add(pnAll);
    }
}
