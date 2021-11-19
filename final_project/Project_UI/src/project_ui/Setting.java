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
import static project_ui.MainWindow.bgColor;

/**
 *
 * @author faynch
 */
public class Setting extends javax.swing.JFrame {
    Font font;
    static Color bgColor = Color.WHITE;
    static Color fgColor = Color.BLACK;
    /**
     * Creates new form setting
     */
    public Setting() {
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }
        
        initComponents();
        
        updateTheme();
        
    }

    public static void updateTheme() {
        settingP.setBackground(bgColor);
        backgroundL.setForeground(fgColor);
        timeFormatL.setForeground(fgColor);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroudG = new javax.swing.ButtonGroup();
        settingP = new javax.swing.JPanel();
        backgroundL = new javax.swing.JLabel();
        backB = new javax.swing.JButton();
        lightB = new javax.swing.JToggleButton();
        darkB = new javax.swing.JToggleButton();
        timeFormatL = new javax.swing.JLabel();
        twelveB = new javax.swing.JToggleButton();
        twentyFourB = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        backgroundL.setFont(font);
        backgroundL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundL.setText("THEME");

        backB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backB.png"))); // NOI18N
        backB.setContentAreaFilled(false);
        backB.setFocusPainted(false);
        backB.setFocusable(false);
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        lightB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lightM.png"))); // NOI18N
        lightB.setContentAreaFilled(false);
        lightB.setFocusPainted(false);
        lightB.setFocusable(false);
        lightB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightBActionPerformed(evt);
            }
        });

        darkB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nightM.png"))); // NOI18N
        darkB.setContentAreaFilled(false);
        darkB.setFocusPainted(false);
        darkB.setFocusable(false);
        darkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkBActionPerformed(evt);
            }
        });

        timeFormatL.setFont(font);
        timeFormatL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeFormatL.setText("TIME FORMAT");

        twelveB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/twelve.png"))); // NOI18N
        twelveB.setBorderPainted(false);
        twelveB.setContentAreaFilled(false);
        twelveB.setFocusPainted(false);
        twelveB.setFocusable(false);
        twelveB.setMaximumSize(new java.awt.Dimension(60, 60));
        twelveB.setMinimumSize(new java.awt.Dimension(60, 60));
        twelveB.setPreferredSize(new java.awt.Dimension(60, 60));
        twelveB.setSize(new java.awt.Dimension(60, 60));
        twelveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twelveBActionPerformed(evt);
            }
        });

        twentyFourB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/twenty-four.png"))); // NOI18N
        twentyFourB.setBorderPainted(false);
        twentyFourB.setContentAreaFilled(false);
        twentyFourB.setFocusPainted(false);
        twentyFourB.setFocusable(false);
        twentyFourB.setMaximumSize(new java.awt.Dimension(60, 60));
        twentyFourB.setMinimumSize(new java.awt.Dimension(60, 60));
        twentyFourB.setPreferredSize(new java.awt.Dimension(60, 60));
        twentyFourB.setSize(new java.awt.Dimension(60, 60));
        twentyFourB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyFourBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingPLayout = new javax.swing.GroupLayout(settingP);
        settingP.setLayout(settingPLayout);
        settingPLayout.setHorizontalGroup(
            settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingPLayout.createSequentialGroup()
                        .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(timeFormatL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backgroundL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingPLayout.createSequentialGroup()
                                .addComponent(lightB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(darkB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingPLayout.createSequentialGroup()
                                .addComponent(twelveB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(twentyFourB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        settingPLayout.setVerticalGroup(
            settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(darkB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lightB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backgroundL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeFormatL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(twelveB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(twentyFourB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_backBActionPerformed

    private void lightBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightBActionPerformed
        // TODO add your handling code here:
        MainWindow.getPaanModel().updateSettings("theme",0);
        bgColor = Color.WHITE;
        fgColor = Color.BLACK;
        updateTheme();
        MainWindow.bgColor = bgColor;
        MainWindow.fgColor = fgColor;
        MainWindow.updateTheme();
    }//GEN-LAST:event_lightBActionPerformed

    private void darkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkBActionPerformed
        // TODO add your handling code here:
        MainWindow.getPaanModel().updateSettings("theme",1);
        bgColor = Color.BLACK;
        fgColor = Color.WHITE;
        updateTheme();
        MainWindow.bgColor = bgColor;
        MainWindow.fgColor = fgColor;
        MainWindow.updateTheme();
    }//GEN-LAST:event_darkBActionPerformed

    private void twelveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twelveBActionPerformed
        // TODO add your handling code here:
        MainWindow.getPaanModel().updateSettings("timeFormat",1);
        MainWindow.clearTimeLine();
        MainWindow.setTimeLine();
    }//GEN-LAST:event_twelveBActionPerformed

    private void twentyFourBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twentyFourBActionPerformed
        // TODO add your handling code here:
        MainWindow.getPaanModel().updateSettings("timeFormat",0);
        MainWindow.clearTimeLine();
        MainWindow.setTimeLine();
    }//GEN-LAST:event_twentyFourBActionPerformed

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
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton backB;
    private javax.swing.ButtonGroup backgroudG;
    private static javax.swing.JLabel backgroundL;
    private static javax.swing.JToggleButton darkB;
    private static javax.swing.JToggleButton lightB;
    private static javax.swing.JPanel settingP;
    private static javax.swing.JLabel timeFormatL;
    private javax.swing.JToggleButton twelveB;
    private javax.swing.JToggleButton twentyFourB;
    // End of variables declaration//GEN-END:variables

}
