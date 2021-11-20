/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author faynch
 */
public class DailyForm extends javax.swing.JFrame {
    private Time t = new Time();
    private static int doneN, remainN, totalN, drinkN;
    static Font font;
    static Color bgColor;
    static Color fgColor;
    static Border border = BorderFactory.createLineBorder(fgColor, 3);
    static Border borderD = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, null, null, fgColor, null);
    
    /**
     * Creates new form dailyForm
     */
    public DailyForm() {
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }     
        
        initComponents();

        dailyL.setText(t.getFormattedDateForDaily());
        taskP.setLayout(new BoxLayout(taskP, BoxLayout.Y_AXIS));
        updateTheme();
        
        MainWindow.getPaanModel().checkReset();
        
        clearDrink();
        setDailyTask();
        setDaily();
        setDailyDrink();
    }
    
    public static void setDaily() {
        doneL.setFont(font.deriveFont(40f));
        doneNumL.setFont(font.deriveFont(40f));
        doneN = MainWindow.getPaanModel().getDailyCheck();
        doneNumL.setText(String.valueOf(doneN));
        
        remainL.setFont(font.deriveFont(40f));
        remainNumL.setFont(font.deriveFont(40f));
        remainN = MainWindow.getPaanModel().getDailyUncheck();
        remainNumL.setText(String.valueOf(remainN));
        
        totalN = MainWindow.getPaanModel().getDailyTotal();
        totalNumL.setText(String.valueOf(totalN));
    }
    
    public static void setDailyTask() {
        LinkedList<TaskList> dailyList = MainWindow.getPaanModel().getDailyTask();
        for (TaskList taskD: dailyList){
            CheckListTaskForDaily tempTask = new CheckListTaskForDaily();
            if (taskD.getStatus() == true) {tempTask.getDone().setSelected(true);}
            tempTask.getTaskName().setText(taskD.getDetail());
            taskP.add(tempTask);
        }
    }
    
    public static void clearDailyTask() {
        LinkedList<TaskList> dailyList = MainWindow.getPaanModel().getDailyTask();
        for (TaskList taskD: dailyList){
            CheckListTaskForDaily tempTask = new CheckListTaskForDaily();
            tempTask.getDone().setSelected(false);
            tempTask.getTaskName().setText(taskD.getDetail());
            taskP.add(tempTask);
        }
    }
    
    public static void setDailyDrink() {
        drinkN = MainWindow.getPaanModel().getDrink();
        if (drinkN-- > 0) {glass1.setSelected(true);}
        if (drinkN-- > 0) {glass2.setSelected(true);}
        if (drinkN-- > 0) {glass3.setSelected(true);}
        if (drinkN-- > 0) {glass4.setSelected(true);}
        if (drinkN-- > 0) {glass5.setSelected(true);}
        if (drinkN-- > 0) {glass6.setSelected(true);}
        if (drinkN-- > 0) {glass7.setSelected(true);}
        if (drinkN-- > 0) {glass8.setSelected(true);}
        MainWindow.getPaanModel().setDrink(MainWindow.getPaanModel().getDrink()/2);
    }
    
        public void clearDrink() {
        glass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
        glass8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
    }

    public static JLabel getDoneNumL() {
        return doneNumL;
    }

    public static JLabel getRemainNumL() {
        return remainNumL;
    }

    public static JLabel getTotalNumL() {
        return totalNumL;
    }

    public static void setDoneN(int doneN) {
        DailyForm.doneN = doneN;
    }

    public static void setRemainN(int remainN) {
        DailyForm.remainN = remainN;
    }

    public static void setTotalN(int totalN) {
        DailyForm.totalN = totalN;
    }

    public static int getDoneN() {
        return doneN;
    }

    public static int getRemainN() {
        return remainN;
    }

    public static int getTotalN() {
        return totalN;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dailyP = new javax.swing.JPanel();
        dailyL = new javax.swing.JLabel();
        backB = new javax.swing.JButton();
        addB = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        doneNumL = new javax.swing.JLabel();
        totalL = new javax.swing.JLabel();
        totalNumL = new javax.swing.JLabel();
        glass4 = new javax.swing.JToggleButton();
        glass5 = new javax.swing.JToggleButton();
        glass6 = new javax.swing.JToggleButton();
        glass7 = new javax.swing.JToggleButton();
        glass8 = new javax.swing.JToggleButton();
        glass3 = new javax.swing.JToggleButton();
        glass2 = new javax.swing.JToggleButton();
        glass1 = new javax.swing.JToggleButton();
        doneL = new javax.swing.JLabel();
        mainTaskP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskP = new javax.swing.JPanel();
        remainL = new javax.swing.JLabel();
        remainNumL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 700));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setResizable(false);

        dailyP.setBackground(new java.awt.Color(255, 255, 255));
        dailyP.setAlignmentX(0.0F);
        dailyP.setAlignmentY(0.0F);
        dailyP.setMaximumSize(new java.awt.Dimension(1100, 700));
        dailyP.setPreferredSize(new java.awt.Dimension(1100, 700));
        dailyP.setSize(new java.awt.Dimension(1100, 700));

        dailyL.setFont(font);
        dailyL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dailyL.setText("DAILY");
        dailyL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(153, 153, 153)));

        backB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backB.png"))); // NOI18N
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false);
        backB.setFocusPainted(false);
        backB.setFocusable(false);
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        addB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addB.setBorderPainted(false);
        addB.setContentAreaFilled(false);
        addB.setFocusPainted(false);
        addB.setFocusable(false);
        addB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addBMousePressed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.setFocusPainted(false);
        delete.setFocusable(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        doneNumL.setFont(font);
        doneNumL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        doneNumL.setText("num");
        doneNumL.setMaximumSize(new java.awt.Dimension(80, 70));
        doneNumL.setMinimumSize(new java.awt.Dimension(80, 70));
        doneNumL.setPreferredSize(new java.awt.Dimension(80, 70));
        doneNumL.setSize(new java.awt.Dimension(80, 70));

        totalL.setFont(font);
        totalL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalL.setText("TOTAL :");
        totalL.setMaximumSize(new java.awt.Dimension(80, 50));
        totalL.setMinimumSize(new java.awt.Dimension(80, 50));
        totalL.setPreferredSize(new java.awt.Dimension(80, 50));
        totalL.setSize(new java.awt.Dimension(80, 50));

        totalNumL.setFont(font);
        totalNumL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalNumL.setText("num");
        totalNumL.setMaximumSize(new java.awt.Dimension(80, 50));
        totalNumL.setMinimumSize(new java.awt.Dimension(80, 50));
        totalNumL.setPreferredSize(new java.awt.Dimension(80, 50));
        totalNumL.setSize(new java.awt.Dimension(80, 50));

        glass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass4.setBorderPainted(false);
        glass4.setContentAreaFilled(false);
        glass4.setFocusPainted(false);
        glass4.setFocusable(false);
        glass4.setMaximumSize(new java.awt.Dimension(60, 70));
        glass4.setMinimumSize(new java.awt.Dimension(60, 70));
        glass4.setPreferredSize(new java.awt.Dimension(60, 70));
        glass4.setSize(new java.awt.Dimension(60, 70));
        glass4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass4ItemStateChanged(evt);
            }
        });

        glass5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass5.setBorderPainted(false);
        glass5.setContentAreaFilled(false);
        glass5.setFocusPainted(false);
        glass5.setMaximumSize(new java.awt.Dimension(60, 70));
        glass5.setMinimumSize(new java.awt.Dimension(60, 70));
        glass5.setPreferredSize(new java.awt.Dimension(60, 70));
        glass5.setSize(new java.awt.Dimension(60, 70));
        glass5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass5ItemStateChanged(evt);
            }
        });

        glass6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass6.setToolTipText("");
        glass6.setBorderPainted(false);
        glass6.setContentAreaFilled(false);
        glass6.setFocusPainted(false);
        glass6.setFocusable(false);
        glass6.setMaximumSize(new java.awt.Dimension(60, 70));
        glass6.setMinimumSize(new java.awt.Dimension(60, 70));
        glass6.setPreferredSize(new java.awt.Dimension(60, 70));
        glass6.setSize(new java.awt.Dimension(60, 70));
        glass6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass6ItemStateChanged(evt);
            }
        });

        glass7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass7.setToolTipText("");
        glass7.setBorderPainted(false);
        glass7.setContentAreaFilled(false);
        glass7.setFocusPainted(false);
        glass7.setFocusable(false);
        glass7.setMaximumSize(new java.awt.Dimension(60, 70));
        glass7.setMinimumSize(new java.awt.Dimension(60, 70));
        glass7.setPreferredSize(new java.awt.Dimension(60, 70));
        glass7.setSize(new java.awt.Dimension(60, 70));
        glass7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass7ItemStateChanged(evt);
            }
        });

        glass8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass8.setToolTipText("");
        glass8.setBorderPainted(false);
        glass8.setContentAreaFilled(false);
        glass8.setFocusPainted(false);
        glass8.setFocusable(false);
        glass8.setMaximumSize(new java.awt.Dimension(60, 70));
        glass8.setMinimumSize(new java.awt.Dimension(60, 70));
        glass8.setPreferredSize(new java.awt.Dimension(60, 70));
        glass8.setSize(new java.awt.Dimension(60, 70));
        glass8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass8ItemStateChanged(evt);
            }
        });

        glass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass3.setToolTipText("");
        glass3.setBorderPainted(false);
        glass3.setContentAreaFilled(false);
        glass3.setFocusPainted(false);
        glass3.setMaximumSize(new java.awt.Dimension(60, 70));
        glass3.setMinimumSize(new java.awt.Dimension(60, 70));
        glass3.setPreferredSize(new java.awt.Dimension(60, 70));
        glass3.setSize(new java.awt.Dimension(60, 70));
        glass3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass3ItemStateChanged(evt);
            }
        });

        glass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass2.setToolTipText("");
        glass2.setBorderPainted(false);
        glass2.setContentAreaFilled(false);
        glass2.setFocusPainted(false);
        glass2.setMaximumSize(new java.awt.Dimension(60, 70));
        glass2.setMinimumSize(new java.awt.Dimension(60, 70));
        glass2.setPreferredSize(new java.awt.Dimension(60, 70));
        glass2.setSize(new java.awt.Dimension(60, 70));
        glass2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass2ItemStateChanged(evt);
            }
        });

        glass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png"))); // NOI18N
        glass1.setToolTipText("");
        glass1.setBorderPainted(false);
        glass1.setContentAreaFilled(false);
        glass1.setFocusPainted(false);
        glass1.setMaximumSize(new java.awt.Dimension(60, 70));
        glass1.setMinimumSize(new java.awt.Dimension(60, 70));
        glass1.setPreferredSize(new java.awt.Dimension(60, 70));
        glass1.setSize(new java.awt.Dimension(60, 70));
        glass1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glass1ItemStateChanged(evt);
            }
        });

        doneL.setFont(font);
        doneL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        doneL.setText("DONE :");
        doneL.setMaximumSize(new java.awt.Dimension(80, 70));
        doneL.setMinimumSize(new java.awt.Dimension(80, 70));
        doneL.setPreferredSize(new java.awt.Dimension(80, 70));
        doneL.setSize(new java.awt.Dimension(80, 70));

        mainTaskP.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), null));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(550, 32767));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(550, 503));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(550, 503));
        jScrollPane1.setSize(new java.awt.Dimension(550, 503));

        taskP.setMaximumSize(new java.awt.Dimension(550, 500));
        taskP.setSize(new java.awt.Dimension(550, 500));

        javax.swing.GroupLayout taskPLayout = new javax.swing.GroupLayout(taskP);
        taskP.setLayout(taskPLayout);
        taskPLayout.setHorizontalGroup(
            taskPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        taskPLayout.setVerticalGroup(
            taskPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(taskP);

        javax.swing.GroupLayout mainTaskPLayout = new javax.swing.GroupLayout(mainTaskP);
        mainTaskP.setLayout(mainTaskPLayout);
        mainTaskPLayout.setHorizontalGroup(
            mainTaskPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainTaskPLayout.setVerticalGroup(
            mainTaskPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        remainL.setFont(font);
        remainL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        remainL.setText("REMAIN :");
        remainL.setMaximumSize(new java.awt.Dimension(80, 70));
        remainL.setMinimumSize(new java.awt.Dimension(80, 70));
        remainL.setPreferredSize(new java.awt.Dimension(80, 70));
        remainL.setSize(new java.awt.Dimension(80, 70));

        remainNumL.setFont(font);
        remainNumL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        remainNumL.setText("num");
        remainNumL.setMaximumSize(new java.awt.Dimension(80, 70));
        remainNumL.setMinimumSize(new java.awt.Dimension(80, 70));
        remainNumL.setPreferredSize(new java.awt.Dimension(80, 70));
        remainNumL.setSize(new java.awt.Dimension(80, 70));

        javax.swing.GroupLayout dailyPLayout = new javax.swing.GroupLayout(dailyP);
        dailyP.setLayout(dailyPLayout);
        dailyPLayout.setHorizontalGroup(
            dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dailyPLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263)
                .addComponent(dailyL, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(dailyPLayout.createSequentialGroup()
                .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dailyPLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dailyPLayout.createSequentialGroup()
                                .addComponent(remainL, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(remainNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dailyPLayout.createSequentialGroup()
                                .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(doneL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(doneNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(dailyPLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dailyPLayout.createSequentialGroup()
                                .addComponent(glass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(glass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(glass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dailyPLayout.createSequentialGroup()
                                .addComponent(glass4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(glass5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(glass6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(glass7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(glass8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainTaskP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        dailyPLayout.setVerticalGroup(
            dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyPLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dailyPLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dailyL, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dailyPLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(remainL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remainNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doneL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doneNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalNumL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(glass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dailyPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(glass8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(glass7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dailyPLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(mainTaskP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dailyP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dailyP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        // TODO add your handling code here:
        Component[] componentList = taskP.getComponents();
        for(Component c : componentList){
            CheckListTaskForDaily temp = (CheckListTaskForDaily)c;
            MainWindow.getPaanModel().addDailyTask(temp.getTaskName().getText());
            if(temp.getDone().isSelected()) {
                MainWindow.getPaanModel().dailyListCheck(temp.getTaskName().getText());
            }
            else {
                MainWindow.getPaanModel().dailyListUncheck(temp.getTaskName().getText());
            }
        }
  
        setVisible(false);
        new MainWindow().setVisible(true);
        MainWindow.bgColor = bgColor;
        MainWindow.fgColor = fgColor;
        MainWindow.updateTheme();
    }//GEN-LAST:event_backBActionPerformed

    private void glass1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass1ItemStateChanged
        // TODO add your handling code here:
        if (glass1.isSelected() == true) {
            glass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass1ItemStateChanged

    private void glass2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass2ItemStateChanged
        // TODO add your handling code here:
        if (glass2.isSelected() == true) {
            glass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass2ItemStateChanged

    private void glass3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass3ItemStateChanged
        // TODO add your handling code here:
        if (glass3.isSelected() == true) {
            glass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass3ItemStateChanged

    private void glass4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass4ItemStateChanged
        // TODO add your handling code here:
        if (glass4.isSelected() == true) {
            glass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass4ItemStateChanged

    private void glass5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass5ItemStateChanged
        // TODO add your handling code here:
        if (glass5.isSelected() == true) {
            glass5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass5ItemStateChanged

    private void glass6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass6ItemStateChanged
        // TODO add your handling code here:
        if (glass6.isSelected() == true) {
            glass6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass6ItemStateChanged

    private void glass7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass7ItemStateChanged
        // TODO add your handling code here:
        if (glass7.isSelected() == true) {
            glass7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass7ItemStateChanged

    private void glass8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glass8ItemStateChanged
        // TODO add your handling code here:
        if (glass8.isSelected() == true) {
            glass8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png")));
            MainWindow.getPaanModel().addDrink();
        }
        else {
            glass8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/glass.png")));
            MainWindow.getPaanModel().removeDrink();
        }
    }//GEN-LAST:event_glass8ItemStateChanged

    private void addBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBMousePressed
        // TODO add your handling code here:
        CheckListTaskForDaily task = new CheckListTaskForDaily();
        taskP.add(task);
        remainNumL.setText(String.valueOf(++remainN));
        totalNumL.setText(String.valueOf(++totalN));
        revalidate();
    }//GEN-LAST:event_addBMousePressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        Component [] componentList = taskP.getComponents();
        int i = 0;

        for(Component c : componentList){
            
            CheckListTaskForDaily temp = (CheckListTaskForDaily)c;
                    
            if(temp.getDone().isSelected()){
                if(i < MainWindow.getPaanModel().getDailyTask().size())
                    MainWindow.getPaanModel().removeDailyTask(i);
                taskP.remove(temp);
            }
            
            i++;
        }
        
        taskP.revalidate();
        taskP.repaint();
        
        doneNumL.setText(String.valueOf(--doneN));
        totalNumL.setText(String.valueOf(--totalN));
    }//GEN-LAST:event_deleteActionPerformed
    
    public static void updateTheme() {
        border = BorderFactory.createLineBorder(fgColor, 3);
        mainTaskP.setBorder(border);
        
        borderD = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, null, null, fgColor, null);
        dailyL.setBorder(borderD);
        
        dailyP.setBackground(bgColor);
        dailyL.setBackground(bgColor);
        mainTaskP.setBackground(bgColor);
        taskP.setBackground(bgColor);
        
        dailyL.setForeground(fgColor);
        remainL.setForeground(fgColor);
        remainNumL.setForeground(fgColor);
        doneL.setForeground(fgColor);
        doneNumL.setForeground(fgColor);
        totalL.setForeground(fgColor);
        totalNumL.setForeground(fgColor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JButton backB;
    private static javax.swing.JLabel dailyL;
    private static javax.swing.JPanel dailyP;
    private javax.swing.JButton delete;
    private static javax.swing.JLabel doneL;
    private static javax.swing.JLabel doneNumL;
    private static javax.swing.JToggleButton glass1;
    private static javax.swing.JToggleButton glass2;
    private static javax.swing.JToggleButton glass3;
    private static javax.swing.JToggleButton glass4;
    private static javax.swing.JToggleButton glass5;
    private static javax.swing.JToggleButton glass6;
    private static javax.swing.JToggleButton glass7;
    private static javax.swing.JToggleButton glass8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JPanel mainTaskP;
    private static javax.swing.JLabel remainL;
    private static javax.swing.JLabel remainNumL;
    private static javax.swing.JPanel taskP;
    private static javax.swing.JLabel totalL;
    private static javax.swing.JLabel totalNumL;
    // End of variables declaration//GEN-END:variables
}
