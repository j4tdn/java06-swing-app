/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author MyPC
 */
public class Ex03 extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    private final FlowLayout flowLayout = new FlowLayout();
    private JButton btSubmit;
    private JButton btBookmark;
    private PnQuestion question1 = new PnQuestion(new Question("1", "Có bao nhiêu kiểu dữ liệu cơ sở trong java ?", "7", "8", "9", "5"));
    private PnQuestion question2 = new PnQuestion(new Question("2", "Có bao nhiêu kiểu số nguyên trong java ?", "1", "2", "3", "Tất cả đều sai"));
    private PnQuestion question3 = new PnQuestion(new Question("3", "Có bao nhiêu kiểu dữ liệu kí tự cơ sở trong java ?", "1", "2", "3", "Tất cả đều sai"));

    private PnQuestion question4 = new PnQuestion(new Question("4", "Một lớp trong java có thể có bao nhiêu lớp cha ?", "1", "2", "3", "4"));

    private PnQuestion question5 = new PnQuestion(new Question("5", "Java chạy trên hệ điều hành nào ?", "Window", "Sun Solaris OS", "Linux", "Tất cả đều đúng"));

    private PnQuestion question6 = new PnQuestion(new Question("6", "Có bao nhiêu loại quyền truy cập trong java ? ", "1", "2", "3", "4"));

    private PnQuestion question7 = new PnQuestion(new Question("7", "Một lớp trong Java có thể có bao nhiêu lớp con ? ", "1", "Vô số", "2", "3"));

    private PnQuestion question8 = new PnQuestion(new Question("8", "API là gì ?", "Thư viện mã nguồn của java", "Thư viện cung cấp giao diện đồ họa cho chương trình java", "Thư viện chứa các thành phần phần mềm tạo sẵn cung cấp các chức năng cho chương trình java", "Tất cả đều sai"));

    private PnQuestion question9 = new PnQuestion(new Question("9", "File chứa mã nguồn của java sau khi được biên dịch có đuôi là gì ?", ".java", ".exe", ".class", ".txt"));

    private PnQuestion question10 = new PnQuestion(new Question("10", "Phạm vi truy cập của đối tượng được khai báo protected là ?", "Mọi vị trí", "Cùng package", "Cùng package và lớp con trong package khác", "Từ các phương thức khác trong class đó"));

    private PnQuestion[] questions = {question1, question2, question3, question4, question5, question6, question7, question8, question9, question10};

    private JPanel pnLast = new JPanel();
    private JLabel lbResult = new JLabel();
    private final Container conn = getContentPane();
    private List<Integer> listQuestionNotAnswered = new ArrayList<>();
    private List<Integer> listQuestionAnswered = new ArrayList<>();

    private JPanel pnCard;
    private JPanel pnButton;
    private final JSplitPane splitPane = new JSplitPane();
    private final GridLayout gridLayout = new GridLayout();
    private int[] answers = {2, 4, 1, 1, 4, 4, 2, 3, 3, 1};
    int indexListAtTheMoment = 0;
    int score = 0;

    public Ex03(String title) {
        super(title);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setSize(800, 600);
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        for (int i = 1; i <= 10; i++) {
            listQuestionNotAnswered.add(i);
        }
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        gridLayout.setRows(2);
        conn.setLayout(gridLayout);

        pnCard = new javax.swing.JPanel();
        pnButton = new javax.swing.JPanel();

        pnCard.setBackground(Color.GRAY);
        pnCard.setPreferredSize(new java.awt.Dimension(800, 500));

        pnCard.setLayout(cardLayout);

        pnButton.setBackground(Color.GRAY);

        pnButton.setLayout(flowLayout);
        btBookmark = new JButton("Bookmark");
        btSubmit = new JButton("Submit");
        pnButton.add(btSubmit);
        pnButton.add(btBookmark);

        for (int i = 0; i < questions.length; i++) {
            pnCard.add(questions[i], i + "");
        }
        pnLast.add(lbResult);
        pnCard.add(pnLast, "Result");

        conn.add(pnCard);
        conn.add(pnButton);

    }

    public static void main(String[] arg) {
        Ex03 ex03 = new Ex03("BorderLayout");
        ex03.setVisible(true);

    }

    private void initEvents() {
        btSubmitEvents();
        btBookmarkEvents();
    }

    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (questions[listQuestionNotAnswered.get(indexListAtTheMoment) - 1].returnSelected() == answers[listQuestionNotAnswered.get(indexListAtTheMoment) - 1]) {
                    score++;
                }
                listQuestionAnswered.add(listQuestionNotAnswered.get(indexListAtTheMoment));
                if (listQuestionAnswered.size() == 10) {
                    lbResult.setText("Kết quả của bạn là: " + score + " câu.");
                    cardLayout.show(pnCard, "Result");
                } else {
                    do {
                        System.out.println(indexListAtTheMoment + "Trước khi tăng");

                        if (indexListAtTheMoment == listQuestionNotAnswered.size() - 1) {
                            indexListAtTheMoment = new Integer(0);
                        } else {
                            indexListAtTheMoment++;
                        }
                    } while (listQuestionAnswered.contains((Integer) listQuestionNotAnswered.get(indexListAtTheMoment)));

                    cardLayout.show(pnCard, indexListAtTheMoment + "");
                    System.out.println(indexListAtTheMoment + "Sau khi tăng");

                }

            }

        });

    }

    private void btBookmarkEvents() {
        btBookmark.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                do {
                    System.out.println(indexListAtTheMoment + "Trước khi tăng");

                    if (indexListAtTheMoment == listQuestionNotAnswered.size() - 1) {
                        indexListAtTheMoment = new Integer(0);
                    } else {
                        indexListAtTheMoment++;
                    }
                } while (listQuestionAnswered.contains((Integer) listQuestionNotAnswered.get(indexListAtTheMoment)));

                cardLayout.show(pnCard, indexListAtTheMoment + "");
                System.out.println(indexListAtTheMoment + "Sau khi tăng");

            }

        });
    }
}
