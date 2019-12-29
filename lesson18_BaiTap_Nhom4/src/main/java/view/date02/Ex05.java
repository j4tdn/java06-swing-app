/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.date02;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Ex05 extends javax.swing.JFrame {

    /**
     * Creates new form Ex05
     */
    public Ex05() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        initEvents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTeamG = new javax.swing.JLabel();
        lbTeamVL = new javax.swing.JLabel();
        lbTeamDT = new javax.swing.JLabel();
        btStart = new javax.swing.JButton();
        lbBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Võ Lâm Truyền Kì 3D");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTeamG.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image\\VoLamTruyenKi\\G01.jpg")); // NOI18N
        getContentPane().add(lbTeamG, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 240, 160));

        lbTeamVL.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image\\VoLamTruyenKi\\VL01.jpg")); // NOI18N
        getContentPane().add(lbTeamVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 220, 140));

        lbTeamDT.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image\\VoLamTruyenKi\\DT01.jpg")); // NOI18N
        getContentPane().add(lbTeamDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 240, 150));

        btStart.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image\\VoLamTruyenKi\\start.jpg")); // NOI18N
        btStart.setAlignmentY(0.0F);
        btStart.setMaximumSize(new java.awt.Dimension(100, 100));
        btStart.setMinimumSize(new java.awt.Dimension(100, 100));
        btStart.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(btStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 100, 100));

        lbBackgroundImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image\\VoLamTruyenKi\\volamtruyenkibackground.png")); // NOI18N
        getContentPane().add(lbBackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex05().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStart;
    private javax.swing.JLabel lbBackgroundImage;
    private javax.swing.JLabel lbTeamDT;
    private javax.swing.JLabel lbTeamG;
    private javax.swing.JLabel lbTeamVL;
    // End of variables declaration//GEN-END:variables

    private Thread threadImageTeam;
    private String[] randomTeamDT = {"DT01.jpg", "DT02.jpg", "DT03.jpg", "DT04.jpg", "DT05.jpg"};
    private String[] randomTeamG = {"G01.jpg", "G02.jpg", "G03.jpg", "G04.png", "G05.png"};
    private String[] randomTeamVL = {"VL01.jpg", "VL02.png", "VL03.jpg", "VL04.png", "VL05.jpg"};

    private final String imageDirTeamDT = "C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image";
    private final String imageTeamDTDir = imageDirTeamDT + File.separator + "VoLamTruyenKi";
    private List<String> imagesTeamDT = new ArrayList<>();

    private final String imageDirTeamG = "C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image";
    private final String imageTeamGDir = imageDirTeamG + File.separator + "VoLamTruyenKi";
    private List<String> imagesTeamG = new ArrayList<>();

    private final String imageDirTeamVL = "C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson18_BaiTap_Nhom4\\src\\main\\java\\image";
    private final String imageTeamVLDir = imageDirTeamVL + File.separator + "VoLamTruyenKi";
    private List<String> imagesTeamVL = new ArrayList<>();

    private boolean isRunning = true;

    private void randomImageTeams() {
        Random rd = new Random();

        threadImageTeam = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    String teamDT = randomTeamDT[rd.nextInt(randomTeamDT.length)];
                    String teamG = randomTeamG[rd.nextInt(randomTeamG.length)];
                    String teamVL = randomTeamVL[rd.nextInt(randomTeamVL.length)];
                    String pathTeamDT = imageTeamDTDir + File.separator + teamDT;
                    String pathTeamG = imageTeamGDir + File.separator + teamG;
                    String pathTeamVL = imageTeamVLDir + File.separator + teamVL;
                    lbTeamG.setIcon(new javax.swing.ImageIcon(pathTeamDT));
                    lbTeamVL.setIcon(new javax.swing.ImageIcon(pathTeamG));
                    lbTeamDT.setIcon(new javax.swing.ImageIcon(pathTeamVL));
                    sleep(1);
                    teamDT = removeFileFormat(teamDT);
                    teamG = removeFileFormat(teamG);
                    teamVL = removeFileFormat(teamVL);
                    if (!isExist(imagesTeamDT, teamDT) && !isExist(imagesTeamG, teamG) && !isExist(imagesTeamVL, teamVL)) {

                        imagesTeamDT.add(teamDT);
                        imagesTeamG.add(teamG);
                        imagesTeamVL.add(teamVL);
                        System.out.println(teamDT + " VS " + teamG + " VS " + teamVL);
                    } else {
                        if (imagesTeamDT.size() == 5 && imagesTeamG.size() == 5 && imagesTeamVL.size() == 5) {
                            try {
                                writeFile("game.txt");
                                System.out.println("Random 5 vòng chơi và ghi vào file game.txt thành công!");
                                sleep(3);
                                System.exit(0);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        if (isRunning) {
            threadImageTeam.start();
            isRunning = !isRunning;
            System.out.println("Start");
        }

    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
        }
    }

    private void initEvents() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                randomImageTeams();

            }

        });
    }

    private String removeFileFormat(String s) {
        if (s.contains(".jpg")) {
            s = s.replace(".jpg", "");
        }
        if (s.contains(".png")) {
            s = s.replace(".png", "");
        }
        return s;
    }

    private boolean isExist(List<String> images, String image) {
        for (String item : images) {
            if (image.equals(item)) {
                return true;
            }
        }
        return false;
    }

    void writeFile(String path) throws IOException {
        File file = new File(path);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < imagesTeamDT.size(); i++) {
                bw.write("Game " + (i + 1) + " : " + imagesTeamDT.get(i) + " vs " + imagesTeamG.get(i) + " vs " + imagesTeamVL.get(i) + "\n");
            }
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.close();
            fw.close();
        }
    }

}
