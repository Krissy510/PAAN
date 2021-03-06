/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

/**
 *
 * @author faynch
 */
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class MainWindow extends javax.swing.JFrame {
    static PaanModel paanModel = new PaanModel();
    static DefaultListModel timelineModel = new DefaultListModel();
    Font font;
    static Color bgColor = Color.WHITE;
    static Color fgColor = Color.BLACK;
    static Border border = BorderFactory.createLineBorder(fgColor, 3);
    /**
     * Creates new form mainWindow
     */
    public MainWindow() {

        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }
        
        initComponents();
       
        clearTimeLine();
        setTimeLine();
        
        setTheme();
        
        updateTheme();
        
    }
    
    public void setTheme() {
        if (paanModel.getTheme() == 0) {
            bgColor = Color.WHITE;
            fgColor = Color.BLACK;
        }
        else {
            bgColor = Color.BLACK;
            fgColor = Color.WHITE;
        }
    }

    public static PaanModel getPaanModel() {
        return paanModel;
    }
    
    public static void setTimeLine() {
        String tempTask;
        paanModel.loadTimeline();
        LinkedList<TaskEvent> TimeLineList = paanModel.getTimelineList();
        for (TaskEvent taskE: TimeLineList){
            String newDetail = formatDetail(taskE.getDetail());
            String newTime = formatTime(taskE.getTime(paanModel.getTimeFormat()));
            tempTask = String.format("    %s%s%s", newDetail, newTime, taskE.getStrDate());
            MainWindow.timelineModel.addElement(tempTask);
        }
    }
    
    public static String formatDetail(String detail) {
        String shift = " ";
        String specialChar = " .ijls";
        int space;
        int check = 0;
        
        
        if (detail.length() > 16) {
            detail = detail.substring(0,14) + "...";
        }
       
        for (int i = 0; i < detail.length(); i++) {
            if (specialChar.contains(Character.toString(detail.charAt(i)))) {check++;}
        }
        check--;
        
        space = 40-(((detail.length()-check)*2)+check);
        detail = detail + shift.repeat(space); 
        
        return detail;
    }
    
    public static String formatTime(String time) {
        String shift = " ";
        int space = 15-time.length();
        int check = 0;
        
        if (time.contains("1")) {
            for (int i = 0; i < time.length(); i++) {
                if (time.charAt(i) == '1') {check += 2;}
            }
        }
        
        space += check;
        time = time + shift.repeat(space);

        return time;
    }
 
    public static void clearTimeLine() {
        timelineModel.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainP = new javax.swing.JPanel();
        memoB = new javax.swing.JButton();
        dailyB = new javax.swing.JButton();
        tableB = new javax.swing.JButton();
        settingB = new javax.swing.JButton();
        timelineP = new javax.swing.JPanel();
        timelineL = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        timelineT = new javax.swing.JList<>();
        exitB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setResizable(false);

        mainP.setBackground(new java.awt.Color(255, 255, 255));
        mainP.setMaximumSize(new java.awt.Dimension(1100, 700));
        mainP.setMinimumSize(new java.awt.Dimension(1100, 700));
        mainP.setPreferredSize(new java.awt.Dimension(1100, 700));

        memoB.setBackground(new java.awt.Color(255, 255, 255));
        memoB.setFont(font);
        memoB.setText("MEMO");
        memoB.setSize(new java.awt.Dimension(100, 30));
        memoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoBActionPerformed(evt);
            }
        });

        dailyB.setBackground(new java.awt.Color(255, 255, 255));
        dailyB.setFont(font);
        dailyB.setText("DAILY");
        dailyB.setSize(new java.awt.Dimension(100, 30));
        dailyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyBActionPerformed(evt);
            }
        });

        tableB.setBackground(new java.awt.Color(255, 255, 255));
        tableB.setFont(font);
        tableB.setText("TABLE");
        tableB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableBActionPerformed(evt);
            }
        });

        settingB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settingButton.png"))); // NOI18N
        settingB.setBorderPainted(false);
        settingB.setContentAreaFilled(false);
        settingB.setFocusable(false);
        settingB.setMaximumSize(new java.awt.Dimension(20, 50));
        settingB.setMinimumSize(new java.awt.Dimension(20, 50));
        settingB.setPreferredSize(new java.awt.Dimension(50, 50));
        settingB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBActionPerformed(evt);
            }
        });

        timelineP.setBackground(new java.awt.Color(255, 255, 255));
        timelineP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        timelineL.setFont(font);
        timelineL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timelineL.setText("TIMELINE");

        jScrollPane2.setBorder(null);

        timelineT.setFont(font);
        timelineT.setModel(timelineModel);
        timelineT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(timelineT);

        javax.swing.GroupLayout timelinePLayout = new javax.swing.GroupLayout(timelineP);
        timelineP.setLayout(timelinePLayout);
        timelinePLayout.setHorizontalGroup(
            timelinePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timelineL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        timelinePLayout.setVerticalGroup(
            timelinePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timelineL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );

        exitB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exitB.png"))); // NOI18N
        exitB.setBorderPainted(false);
        exitB.setContentAreaFilled(false);
        exitB.setFocusable(false);
        exitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPLayout = new javax.swing.GroupLayout(mainP);
        mainP.setLayout(mainPLayout);
        mainPLayout.setHorizontalGroup(
            mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dailyB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memoB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(timelineP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        mainPLayout.setVerticalGroup(
            mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(memoB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(dailyB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(tableB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(mainPLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(timelineP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dailyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyBActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new DailyForm().setVisible(true);    
        DailyForm.bgColor = bgColor;
        DailyForm.fgColor = fgColor;
        DailyForm.updateTheme();
        paanModel.resetFocusDate();
        paanModel.dailyLoad();
    }//GEN-LAST:event_dailyBActionPerformed

    private void memoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoBActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new MemoForm().setVisible(true);    
        MemoForm.bgColor = bgColor;
        MemoForm.fgColor = fgColor;
        MemoForm.updateTheme();
        paanModel.memoLoad();
    }//GEN-LAST:event_memoBActionPerformed

    private void tableBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new TableForm().setVisible(true);    
        TableForm.bgColor = bgColor;
        TableForm.fgColor = fgColor;
        TableForm.updateTheme();
        paanModel.loadTimeTable();
    }//GEN-LAST:event_tableBActionPerformed

    private void settingBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBActionPerformed
        // TODO add your handling code here:
        new Setting().setVisible(true);
        Setting.bgColor = bgColor;
        Setting.fgColor = fgColor;
        Setting.updateTheme();
    }//GEN-LAST:event_settingBActionPerformed

    private void exitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBActionPerformed
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_exitBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

    public static void updateTheme() {
        border = BorderFactory.createLineBorder(fgColor, 3);
        timelineP.setBorder(border);
        
        mainP.setBackground(bgColor);
        memoB.setBackground(bgColor);
        dailyB.setBackground(bgColor);
        tableB.setBackground(bgColor);
        timelineL.setBackground(bgColor);
        timelineP.setBackground(bgColor);
        timelineT.setBackground(bgColor);
        
        memoB.setForeground(fgColor);
        dailyB.setForeground(fgColor);
        tableB.setForeground(fgColor);
        timelineL.setForeground(fgColor);
        timelineP.setForeground(fgColor);
        timelineT.setForeground(fgColor);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton dailyB;
    private javax.swing.JButton exitB;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JPanel mainP;
    private static javax.swing.JButton memoB;
    private javax.swing.JButton settingB;
    private static javax.swing.JButton tableB;
    private static javax.swing.JLabel timelineL;
    private static javax.swing.JPanel timelineP;
    private static javax.swing.JList<String> timelineT;
    // End of variables declaration//GEN-END:variables
}
