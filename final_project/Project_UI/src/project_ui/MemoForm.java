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
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


/**
 *
 * @author faynch
 */
public class MemoForm extends javax.swing.JFrame {
    static DefaultListModel eventModel = new DefaultListModel();
    Font font;
    static Color bgColor;
    static Color fgColor;
    public Time objTime = new Time();
    static Border borderT = BorderFactory.createLineBorder(fgColor, 3);
    static Border borderE = BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(fgColor, 3), null), null);
    static Border borderD = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, null, null, fgColor, null);
    /**
     * Creates new form memoForm
     */
    public MemoForm() {
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            g.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){
            
        }
        
        initComponents();
        
        dateL.setFont(font.deriveFont(40f));
        dateL.setText(objTime.getFormattedDateForMemo()); //Set The Current Time
        
        todoP.setLayout(new BoxLayout(todoP, BoxLayout.Y_AXIS));
        
        updateTheme();
        
        clearMemoTodo();
        clearMemoEventMood();
        
        setMemoTodo();
        setMemoEventMood();
    }
    
    public static void clearMemoTodo() {
        todoP.removeAll();
    }
    
    public void clearMemoEventMood() {
        eventModel.clear();
    
        redB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png")));
        orangeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orange.png")));
        yellowB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow.png")));
        purpleB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple.png")));
        blueB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue.png")));
    }
    
    public static void setMemoTodo() {
        LinkedList<TaskList> todoList = MainWindow.getPaanModel().getTodoList();
        for (TaskList taskL: todoList){
            CheckListTaskForTodo tempTask = new CheckListTaskForTodo();
            if (taskL.getStatus() == true) {tempTask.getDone().setSelected(true);}
            tempTask.getTaskName().setText(taskL.getDetail());
            todoP.add(tempTask);
        }
    }
    
    public void setMemoEventMood() {
        
        LinkedList<TaskEvent> eventList = MainWindow.getPaanModel().getEventList();
        for (TaskEvent taskE: eventList) {
            String newDetail = formatDetail(taskE.getDetail());
            String newTime = formatTime(taskE.getTime(MainWindow.getPaanModel().getTimeFormat()));
            String tempTask = String.format("%s%s", newDetail, taskE.getTime(MainWindow.getPaanModel().getTimeFormat()));
            MemoForm.eventModel.addElement(tempTask);
        }
        
        String tempMood = MainWindow.getPaanModel().getMood();

        if ("angry".equals(tempMood)) {redB.setSelected(true);}
        else if ("normal".equals(tempMood)) {orangeB.setSelected(true);}
        else if ("happy".equals(tempMood)) {yellowB.setSelected(true);}
        else if ("bored".equals(tempMood)) {purpleB.setSelected(true);}
        else if ("sad".equals(tempMood)) {blueB.setSelected(true);}
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
        
        space = 50-(((detail.length()-check)*2)+check);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moodButtonGroup = new javax.swing.ButtonGroup();
        memoP = new javax.swing.JPanel();
        todolistP = new javax.swing.JPanel();
        todolistL = new javax.swing.JLabel();
        delForListB = new javax.swing.JButton();
        addForListB = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        mainToDoP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        todoP = new javax.swing.JPanel();
        dateP = new javax.swing.JPanel();
        leftB = new javax.swing.JButton();
        rightB = new javax.swing.JButton();
        dateL = new javax.swing.JLabel();
        eventP = new javax.swing.JPanel();
        eventL = new javax.swing.JLabel();
        mainEventP = new javax.swing.JScrollPane();
        eventT = new javax.swing.JList<>();
        delForEventB = new javax.swing.JButton();
        addForEventB = new javax.swing.JButton();
        moodP = new javax.swing.JPanel();
        orangeB = new javax.swing.JToggleButton();
        redB = new javax.swing.JToggleButton();
        moodL = new javax.swing.JLabel();
        blueB = new javax.swing.JToggleButton();
        yellowB = new javax.swing.JToggleButton();
        purpleB = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setResizable(false);

        memoP.setBackground(new java.awt.Color(255, 255, 255));
        memoP.setMaximumSize(new java.awt.Dimension(1100, 700));
        memoP.setMinimumSize(new java.awt.Dimension(1100, 700));
        memoP.setPreferredSize(new java.awt.Dimension(1100, 700));

        todolistP.setBackground(new java.awt.Color(255, 255, 255));
        todolistP.setPreferredSize(new java.awt.Dimension(500, 500));

        todolistL.setFont(font);
        todolistL.setText("TO DO LIST");

        delForListB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        delForListB.setBorder(null);
        delForListB.setBorderPainted(false);
        delForListB.setContentAreaFilled(false);
        delForListB.setFocusable(false);
        delForListB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delForListBActionPerformed(evt);
            }
        });

        addForListB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addForListB.setBorder(null);
        addForListB.setBorderPainted(false);
        addForListB.setContentAreaFilled(false);
        addForListB.setFocusable(false);
        addForListB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addForListBMousePressed(evt);
            }
        });

        backB.setBackground(new java.awt.Color(255, 255, 255));
        backB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backB.png"))); // NOI18N
        backB.setBorder(null);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false);
        backB.setFocusable(false);
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        mainToDoP.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), null));
        mainToDoP.setMaximumSize(new java.awt.Dimension(500, 450));
        mainToDoP.setPreferredSize(new java.awt.Dimension(500, 450));
        mainToDoP.setSize(new java.awt.Dimension(500, 450));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 450));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 450));
        jScrollPane1.setSize(new java.awt.Dimension(500, 450));

        javax.swing.GroupLayout todoPLayout = new javax.swing.GroupLayout(todoP);
        todoP.setLayout(todoPLayout);
        todoPLayout.setHorizontalGroup(
            todoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        todoPLayout.setVerticalGroup(
            todoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(todoP);

        javax.swing.GroupLayout mainToDoPLayout = new javax.swing.GroupLayout(mainToDoP);
        mainToDoP.setLayout(mainToDoPLayout);
        mainToDoPLayout.setHorizontalGroup(
            mainToDoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
        );
        mainToDoPLayout.setVerticalGroup(
            mainToDoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout todolistPLayout = new javax.swing.GroupLayout(todolistP);
        todolistP.setLayout(todolistPLayout);
        todolistPLayout.setHorizontalGroup(
            todolistPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todolistPLayout.createSequentialGroup()
                .addGroup(todolistPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todolistPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(delForListB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addForListB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(todolistPLayout.createSequentialGroup()
                        .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(todolistPLayout.createSequentialGroup()
                .addComponent(mainToDoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(todolistPLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(todolistL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        todolistPLayout.setVerticalGroup(
            todolistPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todolistPLayout.createSequentialGroup()
                .addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(todolistL)
                .addGap(18, 18, 18)
                .addComponent(mainToDoP, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(todolistPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delForListB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addForListB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateP.setBackground(new java.awt.Color(255, 255, 255));

        leftB.setBackground(new java.awt.Color(255, 255, 255));
        leftB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftB.png"))); // NOI18N
        leftB.setBorderPainted(false);
        leftB.setContentAreaFilled(false);
        leftB.setFocusable(false);
        leftB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBActionPerformed(evt);
            }
        });

        rightB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rightB.png"))); // NOI18N
        rightB.setBorderPainted(false);
        rightB.setContentAreaFilled(false);
        rightB.setFocusable(false);
        rightB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBActionPerformed(evt);
            }
        });

        dateL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateL.setText("MON 23 OCT");
        dateL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(0, 0, 0)));
        dateL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout datePLayout = new javax.swing.GroupLayout(dateP);
        dateP.setLayout(datePLayout);
        datePLayout.setHorizontalGroup(
            datePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(leftB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rightB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        datePLayout.setVerticalGroup(
            datePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        eventP.setBackground(new java.awt.Color(255, 255, 255));

        eventL.setFont(font);
        eventL.setText("EVENT");

        mainEventP.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), null), null));

        eventT.setFont(font);
        eventT.setModel(eventModel);
        eventT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mainEventP.setViewportView(eventT);

        delForEventB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        delForEventB.setBorder(null);
        delForEventB.setBorderPainted(false);
        delForEventB.setContentAreaFilled(false);
        delForEventB.setFocusable(false);
        delForEventB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delForEventBActionPerformed(evt);
            }
        });

        addForEventB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addForEventB.setBorder(null);
        addForEventB.setBorderPainted(false);
        addForEventB.setContentAreaFilled(false);
        addForEventB.setFocusable(false);
        addForEventB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addForEventBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eventPLayout = new javax.swing.GroupLayout(eventP);
        eventP.setLayout(eventPLayout);
        eventPLayout.setHorizontalGroup(
            eventPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainEventP)
            .addGroup(eventPLayout.createSequentialGroup()
                .addGroup(eventPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(delForEventB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addForEventB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eventPLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(eventL)
                        .addGap(0, 186, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eventPLayout.setVerticalGroup(
            eventPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventL)
                .addGap(16, 16, 16)
                .addComponent(mainEventP, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(eventPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delForEventB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addForEventB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        moodP.setBackground(new java.awt.Color(255, 255, 255));

        moodButtonGroup.add(orangeB);
        orangeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orange.png"))); // NOI18N
        orangeB.setBorderPainted(false);
        orangeB.setContentAreaFilled(false);
        orangeB.setFocusable(false);
        orangeB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                orangeBItemStateChanged(evt);
            }
        });

        moodButtonGroup.add(redB);
        redB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png"))); // NOI18N
        redB.setToolTipText("");
        redB.setBorder(null);
        redB.setBorderPainted(false);
        redB.setContentAreaFilled(false);
        redB.setFocusable(false);
        redB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                redBItemStateChanged(evt);
            }
        });

        moodL.setBackground(new java.awt.Color(255, 255, 255));
        moodL.setFont(font);
        moodL.setText("MOOD");

        moodButtonGroup.add(blueB);
        blueB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue.png"))); // NOI18N
        blueB.setBorderPainted(false);
        blueB.setContentAreaFilled(false);
        blueB.setFocusable(false);
        blueB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                blueBItemStateChanged(evt);
            }
        });

        moodButtonGroup.add(yellowB);
        yellowB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow.png"))); // NOI18N
        yellowB.setBorderPainted(false);
        yellowB.setContentAreaFilled(false);
        yellowB.setFocusable(false);
        yellowB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yellowBItemStateChanged(evt);
            }
        });

        moodButtonGroup.add(purpleB);
        purpleB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple.png"))); // NOI18N
        purpleB.setBorderPainted(false);
        purpleB.setContentAreaFilled(false);
        purpleB.setFocusable(false);
        purpleB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                purpleBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout moodPLayout = new javax.swing.GroupLayout(moodP);
        moodP.setLayout(moodPLayout);
        moodPLayout.setHorizontalGroup(
            moodPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moodPLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(moodL)
                .addGap(31, 31, 31)
                .addComponent(redB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orangeB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yellowB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(purpleB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(blueB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        moodPLayout.setVerticalGroup(
            moodPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moodPLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(moodPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moodL)
                    .addComponent(purpleB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yellowB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout memoPLayout = new javax.swing.GroupLayout(memoP);
        memoP.setLayout(memoPLayout);
        memoPLayout.setHorizontalGroup(
            memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoPLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(todolistP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moodP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        memoPLayout.setVerticalGroup(
            memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoPLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(memoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(todolistP, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(memoPLayout.createSequentialGroup()
                        .addComponent(dateP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moodP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Time Feature
    //Button for going to the previous day
    private void leftBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBActionPerformed
        // TODO add your handling code here:
        objTime.decreaseTime();
        dateL.setText(objTime.getFormattedDateForMemo());
        MainWindow.getPaanModel().setDate(objTime.getFormattedDateForBackend());
        clearMemoEventMood();
        MainWindow.getPaanModel().loadEvent();
        MainWindow.getPaanModel().loadMood();
        setMemoEventMood();

    }//GEN-LAST:event_leftBActionPerformed

    //Button for going to the next day
    private void rightBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBActionPerformed
        // TODO add your handling code here:
        objTime.increaseTime();
        dateL.setText(objTime.getFormattedDateForMemo());
        MainWindow.getPaanModel().setDate(objTime.getFormattedDateForBackend());
        clearMemoEventMood();
        MainWindow.getPaanModel().loadEvent();
        MainWindow.getPaanModel().loadMood();
        setMemoEventMood();
        
    }//GEN-LAST:event_rightBActionPerformed

    private void delForEventBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delForEventBActionPerformed
        // TODO add your handling code here:
        int index = eventT.getSelectedIndex();
        if (index != -1) {
            eventModel.remove(index);
            MainWindow.getPaanModel().removeEventTask(index);
        }
    }//GEN-LAST:event_delForEventBActionPerformed

    private void addForEventBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addForEventBActionPerformed
        // TODO add your handling code here:
        new EventUsin().setVisible(true);
        EventUsin.bgColor = bgColor;
        EventUsin.fgColor = fgColor;
        EventUsin.updateTheme();
    }//GEN-LAST:event_addForEventBActionPerformed

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        // TODO add your handling code here:
        Component[] componentList = todoP.getComponents();
        for(Component c : componentList){
            CheckListTaskForTodo temp = (CheckListTaskForTodo)c;
            MainWindow.getPaanModel().addTodoTask(temp.getTaskName().getText());
            if(temp.getDone().isSelected()) {
                MainWindow.getPaanModel().todoListCheck(temp.getTaskName().getText());
            }
            else {
                MainWindow.getPaanModel().todoListUncheck(temp.getTaskName().getText());
            }
        }
        MainWindow.getPaanModel().resetFocusDate();
        MainWindow.getPaanModel().loadEvent();
        setVisible(false);
        new MainWindow().setVisible(true);
        MainWindow.bgColor = bgColor;
        MainWindow.fgColor = fgColor;
        MainWindow.updateTheme();
    }//GEN-LAST:event_backBActionPerformed

    private void addForListBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addForListBMousePressed
        // TODO add your handling code here:
        CheckListTaskForTodo task = new CheckListTaskForTodo();
        todoP.add(task);
        
        revalidate();
    }//GEN-LAST:event_addForListBMousePressed

    private void delForListBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delForListBActionPerformed
        // TODO add your handling code here:
        Component [] componentList = todoP.getComponents();
        int i = 0;

        for(Component c : componentList){
            
            CheckListTaskForTodo temp = (CheckListTaskForTodo)c;
                    
            if(temp.getDone().isSelected()){
                System.out.println("Here:");
                System.out.println(i);
                if(i < MainWindow.getPaanModel().getTodoList().size())
                    MainWindow.getPaanModel().removeTodoTask(i);
                todoP.remove(temp);
            }
            
            i++;
        }
        
        todoP.revalidate();
        todoP.repaint();
    }//GEN-LAST:event_delForListBActionPerformed

    private void redBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_redBItemStateChanged
        // TODO add your handling code here:
        if (redB.isSelected() == true) {
            redB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redClicked.png")));
            MainWindow.getPaanModel().updateMood("angry");
        }
        else {
            redB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red.png")));
        }
    }//GEN-LAST:event_redBItemStateChanged

    private void orangeBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_orangeBItemStateChanged
        // TODO add your handling code here:
        if (orangeB.isSelected() == true) {
            orangeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orangeClicked.png")));
            MainWindow.getPaanModel().updateMood("normal");
        }
        else {
            orangeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orange.png")));
        }
    }//GEN-LAST:event_orangeBItemStateChanged

    private void yellowBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yellowBItemStateChanged
        // TODO add your handling code here:
        if (yellowB.isSelected() == true) {
            yellowB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowClicked.png")));
            MainWindow.getPaanModel().updateMood("happy");
        }
        else {
            yellowB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow.png")));
        }
    }//GEN-LAST:event_yellowBItemStateChanged

    private void purpleBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_purpleBItemStateChanged
        // TODO add your handling code here:
        if (purpleB.isSelected() == true) {
            purpleB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purpleClicked.png")));
            MainWindow.getPaanModel().updateMood("bored");
        }
        else {
            purpleB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple.png")));
        }
    }//GEN-LAST:event_purpleBItemStateChanged

    private void blueBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_blueBItemStateChanged
        // TODO add your handling code here:
        if (blueB.isSelected() == true) {
            blueB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueClicked.png")));
            MainWindow.getPaanModel().updateMood("sad");
        }
        else {
            blueB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue.png")));
        }
    }//GEN-LAST:event_blueBItemStateChanged
    
    public static void updateTheme() {
        borderT = BorderFactory.createLineBorder(fgColor, 3);
        mainToDoP.setBorder(borderT);
        
        borderE = BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(fgColor, 3), null), null);
        mainEventP.setBorder(borderE);
        
        borderD = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, null, null, fgColor, null);
        dateL.setBorder(borderD);
        
        memoP.setBackground(bgColor);
        todolistP.setBackground(bgColor);
        todoP.setBackground(bgColor);
        dateP.setBackground(bgColor);
        dateL.setBackground(bgColor);
        eventP.setBackground(bgColor);
        eventL.setBackground(bgColor);
        eventT.setBackground(bgColor);
        moodP.setBackground(bgColor);
        moodL.setBackground(bgColor);
       
        
        todolistL.setForeground(fgColor);
        dateL.setForeground(fgColor);
        eventL.setForeground(fgColor);
        eventT.setForeground(fgColor);
        moodL.setForeground(fgColor);
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton addForEventB;
    private static javax.swing.JButton addForListB;
    private javax.swing.JButton backB;
    private static javax.swing.JToggleButton blueB;
    private static javax.swing.JLabel dateL;
    private static javax.swing.JPanel dateP;
    private static javax.swing.JButton delForEventB;
    private static javax.swing.JButton delForListB;
    private static javax.swing.JLabel eventL;
    private static javax.swing.JPanel eventP;
    private static javax.swing.JList<String> eventT;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JButton leftB;
    private static javax.swing.JScrollPane mainEventP;
    private static javax.swing.JPanel mainToDoP;
    private static javax.swing.JPanel memoP;
    private javax.swing.ButtonGroup moodButtonGroup;
    private static javax.swing.JLabel moodL;
    private static javax.swing.JPanel moodP;
    private static javax.swing.JToggleButton orangeB;
    private static javax.swing.JToggleButton purpleB;
    private static javax.swing.JToggleButton redB;
    private static javax.swing.JButton rightB;
    private static javax.swing.JPanel todoP;
    private static javax.swing.JLabel todolistL;
    private static javax.swing.JPanel todolistP;
    private static javax.swing.JToggleButton yellowB;
    // End of variables declaration//GEN-END:variables
}
