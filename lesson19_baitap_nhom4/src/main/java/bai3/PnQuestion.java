/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author VO DINH DUNG
 */
public class PnQuestion extends JPanel {

    private JLabel lbQuestion;
    private JRadioButton rdAnswer1;
    private JRadioButton rdAnswer2;
    private JRadioButton rdAnswer3;
    private JRadioButton rdAnswer4;
    private final GridLayout gridLayout = new GridLayout();

    private ButtonGroup orientationGroup;

    public PnQuestion(Question question) {
        initComponents(question);
    }

    private void initComponents(Question question) {
        gridLayout.setRows(5);
        this.setLayout(gridLayout);
        lbQuestion = new JLabel();
        lbQuestion.setText(question.getNumber() + ": " + question.getQuestion());
        rdAnswer1 = new JRadioButton();
        rdAnswer2 = new JRadioButton();
        rdAnswer3 = new JRadioButton();
        rdAnswer4 = new JRadioButton();
        orientationGroup = new ButtonGroup();
        rdAnswer1.setText(question.getAnswer1());
        rdAnswer2.setText(question.getAnswer2());
        rdAnswer3.setText(question.getAnswer3());
        rdAnswer4.setText(question.getAnswer4());
        orientationGroup.add(rdAnswer1);
        orientationGroup.add(rdAnswer2);
        orientationGroup.add(rdAnswer3);
        orientationGroup.add(rdAnswer4);
        this.add(lbQuestion);

        this.add(rdAnswer1);
        this.add(rdAnswer2);
        this.add(rdAnswer3);
        this.add(rdAnswer4);

    }

    public int returnSelected() {
        if (rdAnswer1.isSelected()) {
            return 1;
        }
        if (rdAnswer2.isSelected()) {
            return 2;
        }
        if (rdAnswer3.isSelected()) {
            return 3;
        }
        if (rdAnswer4.isSelected()) {
            return 4;
        }

        return 0;

    }
}
