package com.example.myapp;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

public class MyForm extends com.codename1.ui.Form {
    public Time objTime = new Time();
    public MyForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public MyForm(Resources resourceObjectInstance) {
        super("",BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().hideToolbar();

        gui_Label_Time.setText(objTime.getFormattedDate()); //Set The Current Time
    }

    //Time Feature
    //Button for going to the previous day
    public void onLeft_ButtonActionEvent(ActionEvent ev) {
        gui_Label_Time.setText(objTime.decreaseTime());
        System.out.println("the previous day");
    }

    //Button for going to the next day
    public void onRight_ButtonActionEvent(ActionEvent ev) {
        gui_Label_Time.setText(objTime.increaseTime());
        System.out.println("the next day");
    }

    //Mood Feature
    public void onButton_Mood5ActionEvent(ActionEvent ev) {
    }

    public void onButton_Mood4ActionEvent(ActionEvent ev) {
    }

    public void onButton_Mood3ActionEvent(ActionEvent ev) {
    }

    public void onButton_Mood2ActionEvent(ActionEvent ev) {
        setUIID("ButtonMood");
    }

    public void onButton_Mood1ActionEvent(ActionEvent ev) {
//        gui_Button_Mood1.setToggle(true);
//        setUIID("Button");
    }

    //Event Feature
    //Button for adding task event
    public void onButton_EventActionEvent(ActionEvent ev) {
        Event item = new Event("");
        gui_Box_Event.add(item);
        revalidate();
        System.out.println("Add event item");
    }

    //Todolist Feature
    //Button for adding task list
    public void onButton_TodoListActionEvent(ActionEvent ev) {
        TodoList item = new TodoList("", false);
        gui_Box_List.add(item);
        revalidate();
        System.out.println("Add list item");
    }


    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Layered_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Button_TodoList = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_List = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Right_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Left_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_Time = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Layered_Layout_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Button_Event = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Box_Event = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_Button_Mood1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_Mood2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_Mood3 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_Mood4 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_Mood5 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_TodoList.addActionListener(callback);
        gui_Right_Button.addActionListener(callback);
        gui_Left_Button.addActionListener(callback);
        gui_Button_Event.addActionListener(callback);
        gui_Button_Mood1.addActionListener(callback);
        gui_Button_Mood2.addActionListener(callback);
        gui_Button_Mood3.addActionListener(callback);
        gui_Button_Mood4.addActionListener(callback);
        gui_Button_Mood5.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_TodoList) {
                onButton_TodoListActionEvent(ev);
            }
            if(sourceComponent == gui_Right_Button) {
                onRight_ButtonActionEvent(ev);
            }
            if(sourceComponent == gui_Left_Button) {
                onLeft_ButtonActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Event) {
                onButton_EventActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Mood1) {
                onButton_Mood1ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Mood2) {
                onButton_Mood2ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Mood3) {
                onButton_Mood3ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Mood4) {
                onButton_Mood4ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_Mood5) {
                onButton_Mood5ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollVisible(true);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:c5c5c5;");
        setTitle("MyForm");
        setName("MyForm");
        gui_Container.setPreferredSizeStr("inherit 91.27889mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("border:0.5mm solid 0; bgColor:ffffff; transparency:255; opacity:255; margin:inherit 20px inherit inherit;");
        gui_Container.setName("Container");
        gui_Container_1.setPreferredSizeStr("inherit 137.51364mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setInlineAllStyles("margin:inherit inherit inherit 20px;");
        gui_Container_1.setName("Container_1");
        addComponent(gui_Container);
        gui_Layered_Layout.setPreferredSizeStr("68.359955mm 13.394185mm");
                gui_Layered_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout.setName("Layered_Layout");
        gui_Label_3.setPreferredSizeStr("66.67328mm 11.905943mm");
        gui_Label_3.setText("To do list");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:8.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:0; alignment:center; margin:30px inherit 10px inherit; padding:inherit inherit inherit inherit;");
        gui_Label_3.setName("Label_3");
        gui_Box_List.setPreferredSizeStr("91.378105mm 75.404305mm");
        gui_Box_List.setScrollableY(true);
                gui_Box_List.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_List.setInlineAllStyles("margin:0.0mm 0.7mm 0.0mm 0.7mm; padding:inherit 10px inherit 10px;");
        gui_Box_List.setName("Box_List");
        gui_Container.addComponent(gui_Layered_Layout);
        gui_Button_TodoList.setPreferredSizeStr("13.394185mm 13.592618mm");
                gui_Button_TodoList.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_TodoList.setInlineAllStyles("font:150px; fgColor:d33419; transparency:0; margin:0.0mm 0.7mm 0.7mm 0.7mm;");
        gui_Button_TodoList.setName("Button_TodoList");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_TodoList,"\ue147".charAt(0));
        gui_Layered_Layout.addComponent(gui_Button_TodoList);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_TodoList.getParent().getLayout()).setInsets(gui_Button_TodoList, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Button_TodoList, "-1 -1 -1 -1").setReferencePositions(gui_Button_TodoList, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_Box_List);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredWidthMM((float)91.378105);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredHeightMM((float)13.394185);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getParent().getLayout()).setInsets(gui_Layered_Layout, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Layered_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "-1 0 -1 0 ").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_List.getParent().getLayout()).setInsets(gui_Box_List, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_List, "1 -1 0 -1").setReferencePositions(gui_Box_List, "1.0 0.0 1.0 0.0");
        addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("82.448654mm 14.485563mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("border:roundRect stroke(0.5mm 000000) +top-left +top-right +bottom-left +bottom-right 7.5mm; bgColor:ffffff; transparency:255; alignment:center; margin:inherit inherit 30px inherit;");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("82.05179mm 65.185036mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setInlineAllStyles("border:0.5mm solid 0; bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_4.setName("Container_4");
        gui_Container_7.setPreferredSizeStr("80.06747mm 22.42286mm");
                gui_Container_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_7.setName("Container_7");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Right_Button.setPreferredSizeStr("10.020835mm 14.485563mm");
                gui_Right_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Right_Button.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:left; padding:inherit 0.0mm inherit 0.0mm;");
        gui_Right_Button.setName("Right_Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Right_Button,"\ue5cc".charAt(0));
        gui_Left_Button.setPreferredSizeStr("10.814565mm 14.485563mm");
                gui_Left_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Left_Button.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:right; padding:inherit 0.0mm inherit 0.0mm;");
        gui_Left_Button.setName("Left_Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Left_Button,"\ue314".charAt(0));
        gui_Label_Time.setPreferredSizeStr("44.94493mm 14.088698mm");
        gui_Label_Time.setText("SUN 29 AUG");
                gui_Label_Time.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_Time.setInlineAllStyles("font:7.0mm; fgColor:0; alignment:center;");
        gui_Label_Time.setName("Label_Time");
        gui_Container_2.addComponent(gui_Right_Button);
        gui_Container_2.addComponent(gui_Left_Button);
        gui_Container_2.addComponent(gui_Label_Time);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Right_Button.getParent().getLayout()).setInsets(gui_Right_Button, "0.0mm 0.0mm 0.0mm 84.162895%").setReferenceComponents(gui_Right_Button, "-1 -1 -1 -1").setReferencePositions(gui_Right_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Left_Button.getParent().getLayout()).setInsets(gui_Left_Button, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Left_Button, "-1 -1 -1 -1").setReferencePositions(gui_Left_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_Time.getParent().getLayout()).setInsets(gui_Label_Time, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label_Time, "-1 0 -1 1 ").setReferencePositions(gui_Label_Time, "0.0 1.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_1.setPreferredSizeStr("80.06747mm 8.433376mm");
        gui_Label_1.setText("Event");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:6.0mm; fgColor:0; alignment:center; margin:30px inherit 20px inherit;");
        gui_Label_1.setName("Label_1");
        gui_Layered_Layout_1.setPreferredSizeStr("68.359955mm 13.989483mm");
                gui_Layered_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_1.setName("Layered_Layout_1");
        gui_Box_Event.setPreferredSizeStr("65.780334mm 35.817043mm");
        gui_Box_Event.setScrollableY(true);
                gui_Box_Event.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Event.setInlineAllStyles("bgImage:null; margin:inherit 1.0mm inherit 20.0mm;");
        gui_Box_Event.setName("Box_Event");
        gui_Container_4.addComponent(gui_Label_1);
        gui_Container_4.addComponent(gui_Layered_Layout_1);
        gui_Button_Event.setPreferredSizeStr("13.394185mm 13.592618mm");
                gui_Button_Event.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Event.setInlineAllStyles("font:150px; fgColor:d33419; transparency:0; margin:0.7mm 0.7mm 0.7mm 0.7mm;");
        gui_Button_Event.setName("Button_Event");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Event,"\ue147".charAt(0));
        gui_Layered_Layout_1.addComponent(gui_Button_Event);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_Event.getParent().getLayout()).setInsets(gui_Button_Event, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Button_Event, "-1 -1 -1 -1").setReferencePositions(gui_Button_Event, "0.0 0.0 0.0 0.0");
        gui_Container_4.addComponent(gui_Box_Event);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredWidthMM((float)68.6576);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredHeightMM((float)13.989483);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getParent().getLayout()).setInsets(gui_Layered_Layout_1, "auto -2.9802322E-8mm 0.0mm 0.0mm").setReferenceComponents(gui_Layered_Layout_1, "-1 -1 -1 0 ").setReferencePositions(gui_Layered_Layout_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Event.getParent().getLayout()).setInsets(gui_Box_Event, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Event, "0 0 1 0 ").setReferencePositions(gui_Box_Event, "1.0 0.0 1.0 0.0");
        gui_Container_1.addComponent(gui_Container_7);
        gui_Label_2.setPreferredSizeStr("79.6706mm 8.83024mm");
        gui_Label_2.setText(" Mood :");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:5.0mm; fgColor:0;");
        gui_Label_2.setName("Label_2");
        gui_Container_8.setPreferredSizeStr("80.06747mm 18.156563mm");
                gui_Container_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_8.setInlineAllStyles("alignment:center; padding:inherit inherit inherit 220px;");
        gui_Container_8.setName("Container_8");
        gui_Container_7.addComponent(gui_Label_2);
        gui_Container_7.addComponent(gui_Container_8);
                gui_Button_Mood1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Mood1.setInlineUnselectedStyles("font:6.0mm; border:none; fgColor:e0603c; bgImage:; padding:0px 0px 0px 0px;");
        gui_Button_Mood1.setInlineSelectedStyles("font:3.0mm; border:round ffe0603c stroke(0.5mm ffffff); fgColor:e0603c; transparency:0; padding:0px 0px 0px 0px;");
        gui_Button_Mood1.setInlinePressedStyles("font:3.0mm; border:round ffe0603c stroke(0.5mm ffffff); fgColor:e0603c; padding:0px 0px 0px 0px;");
        gui_Button_Mood1.setName("Button_Mood1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Mood1,"\ue061".charAt(0));
        gui_Button_Mood2.setUIID("ButtonMood");
                gui_Button_Mood2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Mood2.setInlineAllStyles("font:6.0mm; border:none; fgColor:d33419; padding:0px 0px 0px 0px;");
        gui_Button_Mood2.setName("Button_Mood2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Mood2,"\ue061".charAt(0));
                gui_Button_Mood3.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Mood3.setInlineAllStyles("font:6.0mm; fgColor:e89902; padding:0px 0px 0px 0px;");
        gui_Button_Mood3.setName("Button_Mood3");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Mood3,"\ue061".charAt(0));
                gui_Button_Mood4.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Mood4.setInlineAllStyles("font:6.0mm; fgColor:496212; padding:0px 0px 0px 0px;");
        gui_Button_Mood4.setName("Button_Mood4");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Mood4,"\ue061".charAt(0));
                gui_Button_Mood5.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_Mood5.setInlineAllStyles("font:6.0mm; fgColor:18468d; padding:0px 0px 0px 0px;");
        gui_Button_Mood5.setName("Button_Mood5");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_Mood5,"\ue061".charAt(0));
        gui_Container_8.addComponent(gui_Button_Mood1);
        gui_Container_8.addComponent(gui_Button_Mood2);
        gui_Container_8.addComponent(gui_Button_Mood3);
        gui_Container_8.addComponent(gui_Button_Mood4);
        gui_Container_8.addComponent(gui_Button_Mood5);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getParent().getLayout()).setInsets(gui_Container_8, "0.0mm 0.0mm 1.7858914mm 0.0mm").setReferenceComponents(gui_Container_8, "0 -1 -1 -1").setReferencePositions(gui_Container_8, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm 0.0mm 24.208748mm 0.0mm").setReferenceComponents(gui_Container_4, "0 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredWidthMM((float)80.06747);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredHeightMM((float)22.42286);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getParent().getLayout()).setInsets(gui_Container_7, "auto 0.0mm 0.0mm 1.9843245mm").setReferenceComponents(gui_Container_7, "1 -1 -1 0 ").setReferencePositions(gui_Container_7, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "40px 50.0% 40px 40px").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "40px 40px 40px 50.0%").setReferenceComponents(gui_Container_1, "-1 -1 -1 0 ").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

}

