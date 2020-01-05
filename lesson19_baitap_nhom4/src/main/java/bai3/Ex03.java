/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

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
 * @author VO DINH DUNG
 */
public class Ex03 extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    private final FlowLayout flowLayout = new FlowLayout();
    private JButton btSubmit;
    private JButton btBookmark;
    private PnQuestion question1 = new PnQuestion(new Question("1", "Trên trời bao nhiêu vì sao ?", "1", "2", "3", "Vô cùng"));
    private PnQuestion question2 = new PnQuestion(new Question("2", "Làm thế nào để qua được câu này? ?", "Bỏ cuộc", "Cho tôi qua đi mà", "Không thể qua", "Câu này khó quá"));
    private PnQuestion question3 = new PnQuestion(new Question("3", "Con Hổ bị xích vào gốc cây, sợi xích dài 30m. Có 1 bụi cỏ cách đấy 31m, làm sao con Hổ ăn được bụi cỏ ?", "Cắn đứt xích", "Húc đổ cây", "Gọi đồng bọn đến", "Không khả thi"));

    private PnQuestion question4 = new PnQuestion(new Question("4", "Cha của Ly có 5 người con tên thứ Nhất, thứ Hai, thứ Ba, thứ Năm, hỏi tên của người con thứ 5 là gì ?", " Thứ 6 ", "Võ Đình Dũng", "Ly", "LinLin"));

    private PnQuestion question5 = new PnQuestion(new Question("5", "Bệnh gì bác sỹ bó tay?", "HIV", "Đáp án khác", "Gãy chân", "Tất cả đều đúng"));

    private PnQuestion question6 = new PnQuestion(new Question("6", "Có 3 thằng lùn xếp hàng dọc đi vào hang. Thằng đi sau cầm 1 cái xô, thằng đi giữa cầm 1 cái xẻng, hỏi thằng đi trước cầm gì? ", "Cầm đầu", "Cầm đèn", "Cầm dao", "Cầm súng"));

    private PnQuestion question7 = new PnQuestion(new Question("7", "Con ma đỏ đập 2 phát chết, con ma xanh đập 1 phát chết. Hỏi làm sao trong 2 lần đập chết cả hai con?", "Dùng súng của Mr.Dan", "Dùng kiếm", "Đập con ma đỏ trước", "Đập con ma xanh trước"));

    private PnQuestion question8 = new PnQuestion(new Question("8", "Con cua đỏ dài 10 cm chạy đua với con cua xanh dài 15cm. Con nào về đích trước?","Con cua đỏ ", "Con cua xanh", "Tất cả đều sai","Con thỏ"));

    private PnQuestion question9 = new PnQuestion(new Question("9", "Càng chơi càng ra nuớc ?", "Lien Minh Huyen Thoai", "PUBG", "Danh co", "Khong co dap an"));

    private PnQuestion question10 = new PnQuestion(new Question("10", "Chúng ta làm gì mỗi khi thức dậy ?", "Đánh răng", "Hát karaoke", "Làm bài tập JAVA", "Mở mắt"));

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
                        System.out.println(indexListAtTheMoment + " Trước khi tăng");

                        if (indexListAtTheMoment == listQuestionNotAnswered.size() - 1) {
                            indexListAtTheMoment = new Integer(0);
                        } else {
                            indexListAtTheMoment++;
                        }
                    } while (listQuestionAnswered.contains((Integer) listQuestionNotAnswered.get(indexListAtTheMoment)));

                    cardLayout.show(pnCard, indexListAtTheMoment + "");
                    System.out.println(indexListAtTheMoment + " Sau khi tăng");

                }

            }

        });

    }

    private void btBookmarkEvents() {
        btBookmark.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                do {
                    System.out.println(indexListAtTheMoment + " Trước khi tăng");

                    if (indexListAtTheMoment == listQuestionNotAnswered.size() - 1) {
                        indexListAtTheMoment = new Integer(0);
                    } else {
                        indexListAtTheMoment++;
                    }
                } while (listQuestionAnswered.contains((Integer) listQuestionNotAnswered.get(indexListAtTheMoment)));

                cardLayout.show(pnCard, indexListAtTheMoment + "");
                System.out.println(indexListAtTheMoment + " Sau khi tăng");

            }

        });
    }
}
