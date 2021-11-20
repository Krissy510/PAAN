/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author faynch
 */
public class CheckListTaskForDaily extends javax.swing.JPanel {
    static Font font;
    /**
     * Creates new form CheckListTaskForDaily
     */
    public CheckListTaskForDaily() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }     
        
        initComponents();
    }
    
    public JTextField getTaskName() {
        return taskName;
    }

    public JToggleButton getDone() {
        return done;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        done = new javax.swing.JToggleButton();
        taskName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(550, 50));
        setMinimumSize(new java.awt.Dimension(550, 50));
        setPreferredSize(new java.awt.Dimension(550, 50));

        done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incomplete.png"))); // NOI18N
        done.setBorderPainted(false);
        done.setContentAreaFilled(false);
        done.setFocusPainted(false);
        done.setFocusable(false);
        done.setMaximumSize(new java.awt.Dimension(50, 50));
        done.setMinimumSize(new java.awt.Dimension(50, 50));
        done.setPreferredSize(new java.awt.Dimension(50, 50));
        done.setSize(new java.awt.Dimension(50, 50));
        done.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                doneItemStateChanged(evt);
            }
        });

        taskName.setFont(font);
        taskName.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskName, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(taskName)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_doneItemStateChanged
        // TODO add your handling code here:
        if (done.isSelected()) {
            done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complete.png")));
            MainWindow.getPaanModel().dailyListCheck(taskName.getText());
            int temp = DailyForm.getDoneN() + 1;
            DailyForm.setDoneN(temp);
            DailyForm.getDoneNumL().setText(String.valueOf(DailyForm.getDoneN()));
            temp = DailyForm.getRemainN() - 1;
            DailyForm.setRemainN(temp);
            DailyForm.getRemainNumL().setText(String.valueOf(DailyForm.getRemainN()));
        }
        else {
            done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incomplete.png")));
            MainWindow.getPaanModel().dailyListUncheck(taskName.getText());
            int temp = DailyForm.getDoneN() - 1;
            DailyForm.setDoneN(temp);
            DailyForm.getDoneNumL().setText(String.valueOf(DailyForm.getDoneN()));
            temp = DailyForm.getRemainN() + 1;
            DailyForm.setRemainN(temp);
            DailyForm.getRemainNumL().setText(String.valueOf(DailyForm.getRemainN()));
        }
    }//GEN-LAST:event_doneItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton done;
    private javax.swing.JTextField taskName;
    // End of variables declaration//GEN-END:variables
}
