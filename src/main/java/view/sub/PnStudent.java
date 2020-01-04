/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Grade;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.text.JTextComponent;
import org.apache.commons.lang3.StringUtils;
import utils.ImageUtils;

/**
 *
 * @author qphan
 */
public class PnStudent extends javax.swing.JPanel {

    private final String CURRENT_DIRECTORY = "C:\\Users\\qphan\\Pictures\\4k-5k-wallpaper-for-pc-techrum";
    private final int IMAGE_WIDTH = 120;
    private final int IMAGE_HEIGHT = 150;

    private File selectedFile;
    private FrameImage imageFrame;

    public PnStudent() {
        initComponents();

        initComponentsManually();
        initData();
        initEvents();
    }

    private void initComponentsManually() {
        setBackgroundPnCenterLeft(new Color(153, 255, 255), rdMale, rdFemale, rdBD, cbBadminton, cbFootball, cbVolleyball);
    }

    private void setBackgroundPnCenterLeft(Color color, Component... components) {
        for (Component component : components) {
            component.setBackground(color);
        }
    }

    private void initData() {
        Grade grade11 = new Grade(11, "Lớp 11T1");
        Grade grade12 = new Grade(12, "Lớp 12T2");
        Grade grade13 = new Grade(13, "Lớp 13T3");
        Grade[] grades = {grade11, grade12, grade13};
        ComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(grades);
        cbbGrade.setModel(gradeModel);
    }

    private void initEvents() {
        btResetEvent();
        btSubmitEvent();
        btUploadEvent();
        lbImageEvent();
    }

    private void lbImageEvent() {
        imageFrame = new FrameImage(lbImage);
        lbImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (selectedFile != null) {
                    imageFrame.setPath(selectedFile.getAbsolutePath());
                    imageFrame.setVisible();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageFrame.setVisible(false);
            }
        });

    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resetTextComponents(tfFullname, tfMath, tfLiter, taInfo);
                cbbGrade.setSelectedIndex(0);
                resetCheckBoxes(cbFootball, cbVolleyball, cbBadminton);
                tfFullname.requestFocus();
            }
        });
    }

    private void btSubmitEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StringBuilder info = new StringBuilder();
                // Take grade, gender, hobbies only
                Grade grade = (Grade) cbbGrade.getSelectedItem();
                info.append(grade.getId())
                        .append(StringUtils.LF)
                        .append(grade.getName());

                String gender = getSelectedRadioButton();
                info.append(StringUtils.LF)
                        .append(gender);

                String hobbies = getSelectedCheckBoxes(cbFootball, cbVolleyball, cbBadminton);
                info.append(StringUtils.LF)
                        .append(hobbies);

                taInfo.setText(info.toString());
            }
        });
    }

    private void btUploadEvent() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFileChooser fc = new JFileChooser(CURRENT_DIRECTORY);
                if (JFileChooser.APPROVE_OPTION == fc.showDialog(null, "UPLOAD")) {
                    selectedFile = fc.getSelectedFile();
                    System.out.println("file: " + selectedFile.getAbsolutePath());
                    if (selectedFile.getName().matches("[\\w-\\s()]+[.](?i)(?:png|jpg|jpeg|gif)")) {
                        lbImage.setIcon(ImageUtils.loadImageIcon(selectedFile.getAbsolutePath(), IMAGE_WIDTH, IMAGE_HEIGHT));
                    }
                }
            }
        });
    }

    private String getSelectedRadioButton() {
        Enumeration<AbstractButton> elements = btgrGender.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton abstractButton = elements.nextElement();
            if (abstractButton.isSelected()) {
                return abstractButton.getText();
            }
        }
        return StringUtils.EMPTY;
    }

    private String getSelectedCheckBoxes(JCheckBox... checkBoxes) {
        List<String> result = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                result.add(checkBox.getText());
            }
        }
        return String.join("-", result);
    }

    private void resetTextComponents(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText(StringUtils.EMPTY);
        }
    }

    private void resetCheckBoxes(JCheckBox... checkboxes) {
        for (JCheckBox checkbox : checkboxes) {
            checkbox.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrGender = new javax.swing.ButtonGroup();
        PnTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        PnBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        PnCenter = new javax.swing.JPanel();
        spCenter = new javax.swing.JSplitPane();
        pnCLeft = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        tfFullname = new javax.swing.JTextField();
        cbbGrade = new javax.swing.JComboBox<>();
        lbGrade = new javax.swing.JLabel();
        lbGrade1 = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdBD = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        cbBadminton = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        cbFootball = new javax.swing.JCheckBox();
        lbGrade2 = new javax.swing.JLabel();
        pnCRight = new javax.swing.JPanel();
        lbLiter = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        tfLiter = new javax.swing.JTextField();
        lbMath = new javax.swing.JLabel();
        scrollInfo = new javax.swing.JScrollPane();
        taInfo = new javax.swing.JTextArea();
        lbLiter1 = new javax.swing.JLabel();
        lbLiter2 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 51, 153));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PnTop.add(lbStudentInfo);

        add(PnTop, java.awt.BorderLayout.PAGE_START);

        PnBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btSubmit.setText("Submit");
        btSubmit.setFocusPainted(false);
        PnBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btReset.setText("Reset");
        btReset.setFocusPainted(false);
        PnBottom.add(btReset);

        add(PnBottom, java.awt.BorderLayout.PAGE_END);

        PnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(51, 0, 204)))); // NOI18N
        PnCenter.setLayout(new java.awt.BorderLayout());

        spCenter.setOneTouchExpandable(true);

        pnCLeft.setBackground(new java.awt.Color(153, 255, 255));

        lbFullname.setText("Họ tên:");

        lbGrade.setText("Lớp:");

        lbGrade1.setText("Giới tính:");

        btgrGender.add(rdMale);
        rdMale.setText("Nam");
        rdMale.setFocusPainted(false);

        btgrGender.add(rdBD);
        rdBD.setText("Nữ");
        rdBD.setFocusPainted(false);

        btgrGender.add(rdFemale);
        rdFemale.setText("Khác");
        rdFemale.setFocusPainted(false);

        cbBadminton.setText("Cầu lông");
        cbBadminton.setFocusPainted(false);

        cbVolleyball.setText("Bóng chuyền");
        cbVolleyball.setFocusPainted(false);

        cbFootball.setText("Đá bóng");
        cbFootball.setFocusPainted(false);

        lbGrade2.setText("Sở thích:");

        javax.swing.GroupLayout pnCLeftLayout = new javax.swing.GroupLayout(pnCLeft);
        pnCLeft.setLayout(pnCLeftLayout);
        pnCLeftLayout.setHorizontalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
            .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCLeftLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbFullname)
                        .addComponent(lbGrade)
                        .addComponent(lbGrade1)
                        .addComponent(lbGrade2))
                    .addGap(25, 25, 25)
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnCLeftLayout.createSequentialGroup()
                            .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnCLeftLayout.createSequentialGroup()
                                    .addComponent(cbFootball)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbVolleyball))
                                .addGroup(pnCLeftLayout.createSequentialGroup()
                                    .addComponent(rdMale)
                                    .addGap(20, 20, 20)
                                    .addComponent(rdBD)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdFemale)
                                .addComponent(cbBadminton))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(tfFullname)
                        .addComponent(cbbGrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        pnCLeftLayout.setVerticalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCLeftLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lbFullname)
                        .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lbGrade)
                        .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lbGrade1)
                        .addComponent(rdMale)
                        .addComponent(rdBD)
                        .addComponent(rdFemale))
                    .addGap(26, 26, 26)
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lbGrade2)
                        .addComponent(cbFootball)
                        .addComponent(cbVolleyball)
                        .addComponent(cbBadminton))
                    .addContainerGap(306, Short.MAX_VALUE)))
        );

        pnCLeftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbGrade, tfFullname});

        spCenter.setLeftComponent(pnCLeft);

        pnCRight.setBackground(new java.awt.Color(255, 255, 51));
        pnCRight.setMinimumSize(new java.awt.Dimension(340, 100));

        lbLiter.setText("Điểm Văn:");

        tfMath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMathActionPerformed(evt);
            }
        });

        lbMath.setText("Điểm toán:");

        taInfo.setColumns(20);
        taInfo.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        taInfo.setForeground(new java.awt.Color(51, 0, 204));
        taInfo.setLineWrap(true);
        taInfo.setRows(5);
        taInfo.setTabSize(4);
        taInfo.setWrapStyleWord(true);
        scrollInfo.setViewportView(taInfo);

        lbLiter1.setText("Nhận xét:");

        lbLiter2.setText("Hình ảnh:");

        lbImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));

        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUpload.setFocusPainted(false);

        javax.swing.GroupLayout pnCRightLayout = new javax.swing.GroupLayout(pnCRight);
        pnCRight.setLayout(pnCRightLayout);
        pnCRightLayout.setHorizontalGroup(
            pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMath)
                    .addComponent(lbLiter)
                    .addComponent(lbLiter1)
                    .addComponent(lbLiter2))
                .addGap(40, 40, 40)
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMath)
                    .addComponent(tfLiter)
                    .addComponent(scrollInfo)
                    .addGroup(pnCRightLayout.createSequentialGroup()
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnCRightLayout.setVerticalGroup(
            pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbMath)
                    .addComponent(tfMath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbLiter)
                    .addComponent(tfLiter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCRightLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(scrollInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCRightLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbLiter1)))
                .addGap(22, 22, 22)
                .addGroup(pnCRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLiter2)
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        spCenter.setRightComponent(pnCRight);

        PnCenter.add(spCenter, java.awt.BorderLayout.CENTER);

        add(PnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfMathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMathActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnBottom;
    private javax.swing.JPanel PnCenter;
    private javax.swing.JPanel PnTop;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgrGender;
    private javax.swing.JCheckBox cbBadminton;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JCheckBox cbVolleyball;
    private javax.swing.JComboBox<Grade> cbbGrade;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbGrade1;
    private javax.swing.JLabel lbGrade2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLiter;
    private javax.swing.JLabel lbLiter1;
    private javax.swing.JLabel lbLiter2;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JPanel pnCLeft;
    private javax.swing.JPanel pnCRight;
    private javax.swing.JRadioButton rdBD;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JScrollPane scrollInfo;
    private javax.swing.JSplitPane spCenter;
    private javax.swing.JTextArea taInfo;
    private javax.swing.JTextField tfFullname;
    private javax.swing.JTextField tfLiter;
    private javax.swing.JTextField tfMath;
    // End of variables declaration//GEN-END:variables
}
