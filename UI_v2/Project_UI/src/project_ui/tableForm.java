/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author faynch
 */
public class tableForm extends javax.swing.JFrame {
    static Font font;
    static Color bgColor;
    static Color fgColor;
    static Border border = BorderFactory.createLineBorder(fgColor, 3);
    

    /**
     * Creates new form timetableForm
     */
    public tableForm() {
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }       
        
        initComponents();
        timeL.setFont(font.deriveFont(20f));
        
    }

    public static JPanel getMainP() {
        return mainP;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableP = new javax.swing.JPanel();
        backB = new javax.swing.JButton();
        fixB = new javax.swing.JButton();
        tableL = new javax.swing.JLabel();
        mainP = new javax.swing.JPanel();
        timeL = new javax.swing.JLabel();
        monL = new javax.swing.JLabel();
        tueL = new javax.swing.JLabel();
        wedL = new javax.swing.JLabel();
        thuL = new javax.swing.JLabel();
        friL = new javax.swing.JLabel();
        satL = new javax.swing.JLabel();
        sunL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1100, 700));
        setMaximumSize(new java.awt.Dimension(1100, 700));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setResizable(false);

        tableP.setMaximumSize(new java.awt.Dimension(1100, 700));
        tableP.setMinimumSize(new java.awt.Dimension(1100, 700));

        backB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backB.png"))); // NOI18N
        backB.setContentAreaFilled(false);
        backB.setFocusPainted(false);
        backB.setFocusable(false);
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        fixB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/writeB.png"))); // NOI18N
        fixB.setContentAreaFilled(false);
        fixB.setFocusPainted(false);
        fixB.setFocusable(false);
        fixB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixBActionPerformed(evt);
            }
        });

        tableL.setFont(font);
        tableL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableL.setText("TIME TABLE");

        mainP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        mainP.setMaximumSize(new java.awt.Dimension(1050, 570));
        mainP.setMinimumSize(new java.awt.Dimension(1050, 570));
        mainP.setPreferredSize(new java.awt.Dimension(1050, 570));

        timeL.setBackground(new java.awt.Color(90, 84, 84));
        timeL.setFont(font);
        timeL.setForeground(new java.awt.Color(255, 255, 255));
        timeL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeL.setText("        6:00    7:00     8:00    9:00     10:00   11:00    12:00    13:00   14:00   15:00    16:00   17:00   18:00   19:00");
        timeL.setMaximumSize(new java.awt.Dimension(890, 50));
        timeL.setMinimumSize(new java.awt.Dimension(890, 50));
        timeL.setOpaque(true);
        timeL.setPreferredSize(new java.awt.Dimension(890, 50));

        monL.setBackground(new java.awt.Color(253, 245, 138));
        monL.setFont(font);
        monL.setForeground(new java.awt.Color(255, 255, 255));
        monL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monL.setText("MON");
        monL.setMaximumSize(new java.awt.Dimension(100, 50));
        monL.setMinimumSize(new java.awt.Dimension(100, 50));
        monL.setOpaque(true);
        monL.setPreferredSize(new java.awt.Dimension(100, 50));

        tueL.setBackground(new java.awt.Color(253, 174, 207));
        tueL.setFont(font);
        tueL.setForeground(new java.awt.Color(255, 255, 255));
        tueL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tueL.setText("TUE");
        tueL.setMaximumSize(new java.awt.Dimension(100, 50));
        tueL.setMinimumSize(new java.awt.Dimension(100, 50));
        tueL.setOpaque(true);
        tueL.setPreferredSize(new java.awt.Dimension(100, 50));

        wedL.setBackground(new java.awt.Color(119, 221, 170));
        wedL.setFont(font);
        wedL.setForeground(new java.awt.Color(255, 255, 255));
        wedL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wedL.setText("WED");
        wedL.setMaximumSize(new java.awt.Dimension(100, 50));
        wedL.setMinimumSize(new java.awt.Dimension(100, 50));
        wedL.setOpaque(true);
        wedL.setPreferredSize(new java.awt.Dimension(100, 50));

        thuL.setBackground(new java.awt.Color(255, 179, 71));
        thuL.setFont(font);
        thuL.setForeground(new java.awt.Color(255, 255, 255));
        thuL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thuL.setText("THU");
        thuL.setMaximumSize(new java.awt.Dimension(100, 50));
        thuL.setMinimumSize(new java.awt.Dimension(100, 50));
        thuL.setOpaque(true);
        thuL.setPreferredSize(new java.awt.Dimension(100, 50));

        friL.setBackground(new java.awt.Color(133, 199, 224));
        friL.setFont(font);
        friL.setForeground(new java.awt.Color(255, 255, 255));
        friL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        friL.setText("FRI");
        friL.setMaximumSize(new java.awt.Dimension(100, 50));
        friL.setMinimumSize(new java.awt.Dimension(100, 50));
        friL.setOpaque(true);
        friL.setPreferredSize(new java.awt.Dimension(100, 50));

        satL.setBackground(new java.awt.Color(177, 156, 217));
        satL.setFont(font);
        satL.setForeground(new java.awt.Color(255, 255, 255));
        satL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        satL.setText("SAT");
        satL.setMaximumSize(new java.awt.Dimension(100, 50));
        satL.setMinimumSize(new java.awt.Dimension(100, 50));
        satL.setOpaque(true);
        satL.setPreferredSize(new java.awt.Dimension(100, 50));

        sunL.setBackground(new java.awt.Color(255, 105, 97));
        sunL.setFont(font);
        sunL.setForeground(new java.awt.Color(255, 255, 255));
        sunL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sunL.setText("SUN");
        sunL.setMaximumSize(new java.awt.Dimension(100, 50));
        sunL.setMinimumSize(new java.awt.Dimension(100, 50));
        sunL.setOpaque(true);
        sunL.setPreferredSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout mainPLayout = new javax.swing.GroupLayout(mainP);
        mainP.setLayout(mainPLayout);
        mainPLayout.setHorizontalGroup(
            mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(mainPLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sunL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPLayout.setVerticalGroup(
            mainPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(monL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tueL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wedL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thuL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(friL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(satL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sunL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout tablePLayout = new javax.swing.GroupLayout(tableP);
        tableP.setLayout(tablePLayout);
        tablePLayout.setHorizontalGroup(
            tablePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tablePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePLayout.createSequentialGroup()
                        .addComponent(mainP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tablePLayout.createSequentialGroup()
                        .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tableL, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(fixB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        tablePLayout.setVerticalGroup(
            tablePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(tablePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fixB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(mainP, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new mainWindow().setVisible(true);
        mainWindow.bgColor = bgColor;
        mainWindow.fgColor = fgColor;
        mainWindow.updateTheme();
    }//GEN-LAST:event_backBActionPerformed

    private void fixBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixBActionPerformed
        // TODO add your handling code here:
        new usinTable().setVisible(true);
        usinTable.bgColor = bgColor;
        usinTable.fgColor = fgColor;
        usinTable.updateTheme();
    }//GEN-LAST:event_fixBActionPerformed

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
            java.util.logging.Logger.getLogger(tableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tableForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tableForm().setVisible(true);
            }
        });
    }
    
    public static void updateTheme() {
        border = BorderFactory.createLineBorder(fgColor, 3);
        mainP.setBorder(border);
        
        tableP.setBackground(bgColor);
        mainP.setBackground(bgColor);
        tableL.setBackground(bgColor);
        
        tableL.setForeground(fgColor);
        
    }
    
    public static void addSubject(String name, int x, int y, int w) {
        JLabel sub = new JLabel(name); 
        sub.setHorizontalAlignment(sub.CENTER);
        sub.setFont(font.deriveFont(20f));
        sub.setForeground(fgColor);
        sub.setBackground(Color.LIGHT_GRAY);
        sub.setOpaque(true);
        sub.setBounds(x, y, w, 50);
        mainP.add(sub);
        System.out.println("add sub");  
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backB;
    private javax.swing.JButton fixB;
    private javax.swing.JLabel friL;
    private static javax.swing.JPanel mainP;
    private javax.swing.JLabel monL;
    private javax.swing.JLabel satL;
    private javax.swing.JLabel sunL;
    private static javax.swing.JLabel tableL;
    private static javax.swing.JPanel tableP;
    private javax.swing.JLabel thuL;
    private static javax.swing.JLabel timeL;
    private javax.swing.JLabel tueL;
    private javax.swing.JLabel wedL;
    // End of variables declaration//GEN-END:variables
}
