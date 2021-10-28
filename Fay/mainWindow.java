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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author faynch
 */
public class mainWindow extends javax.swing.JFrame {
    Font font;
    static Color bgColor;
    static Color fgColor;
    /**
     * Creates new form mainWindow
     */
    public mainWindow() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }
        
        initComponents();
       
        
    }
    
    
    public static void updateTheme() {
        memoP.setBackground(bgColor);
        memoB.setBackground(bgColor);
        dailyB.setBackground(bgColor);
        tableB.setBackground(bgColor);
        helpB.setBackground(bgColor);
        timelineL.setBackground(bgColor);
        timelineP.setBackground(bgColor);
        timelineT.setBackground(bgColor);
        
        memoB.setForeground(fgColor);
        dailyB.setForeground(fgColor);
        tableB.setForeground(fgColor);
        helpB.setForeground(fgColor);
        timelineL.setForeground(fgColor);
        timelineP.setForeground(fgColor);
        timelineT.setForeground(fgColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memoP = new javax.swing.JPanel();
        memoB = new javax.swing.JButton();
        dailyB = new javax.swing.JButton();
        tableB = new javax.swing.JButton();
        helpB = new javax.swing.JButton();
        settingB = new javax.swing.JButton();
        timelineP = new javax.swing.JPanel();
        timelineL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        timelineT = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        memoP.setBackground(new java.awt.Color(255, 255, 255));
        memoP.setPreferredSize(new java.awt.Dimension(1100, 700));

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

        helpB.setBackground(new java.awt.Color(255, 255, 255));
        helpB.setFont(font);
        helpB.setText("HELP");

        settingB.setText("jButton5");
        settingB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBActionPerformed(evt);
            }
        });

        timelineP.setBackground(new java.awt.Color(255, 255, 255));

        timelineL.setFont(font);
        timelineL.setText("TIMELINE");

        timelineT.setColumns(20);
        timelineT.setRows(5);
        timelineT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setViewportView(timelineT);

        javax.swing.GroupLayout timelinePLayout = new javax.swing.GroupLayout(timelineP);
        timelineP.setLayout(timelinePLayout);
        timelinePLayout.setHorizontalGroup(
            timelinePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timelinePLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(timelineL)
                .addGap(264, 264, 264))
        );
        timelinePLayout.setVerticalGroup(
            timelinePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(timelineL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout memoPLayout = new javax.swing.GroupLayout(memoP);
        memoP.setLayout(memoPLayout);
        memoPLayout.setHorizontalGroup(
            memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoPLayout.createSequentialGroup()
                .addGroup(memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memoPLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(settingB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, memoPLayout.createSequentialGroup()
                        .addContainerGap(118, Short.MAX_VALUE)
                        .addGroup(memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dailyB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memoB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)))
                .addComponent(timelineP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        memoPLayout.setVerticalGroup(
            memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoPLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(timelineP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(memoPLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(memoB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dailyB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tableB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingB)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dailyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dailyBActionPerformed

    private void memoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memoBActionPerformed

    private void tableBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableBActionPerformed

    private void settingBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBActionPerformed
        // TODO add your handling code here:
        new setting().setVisible(true);
    }//GEN-LAST:event_settingBActionPerformed

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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow mainWindow = new mainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton dailyB;
    private static javax.swing.JButton helpB;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JButton memoB;
    private static javax.swing.JPanel memoP;
    private javax.swing.JButton settingB;
    private static javax.swing.JButton tableB;
    private static javax.swing.JLabel timelineL;
    private static javax.swing.JPanel timelineP;
    private static javax.swing.JTextArea timelineT;
    // End of variables declaration//GEN-END:variables
}
