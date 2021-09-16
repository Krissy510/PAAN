package com.example.myapp;

import com.codename1.ui.events.ActionEvent;

public class MyForm extends com.codename1.ui.Form {
    public MyForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public MyForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().hideToolbar();
    }

    public void onCheck_BoxActionEvent(ActionEvent ev) {
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_ListFrame = new com.codename1.ui.Container(new com.codename1.ui.table.TableLayout(12, 2));
    protected com.codename1.ui.CheckBox gui_Check_Box = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_12 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_1 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_2 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_3 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_4 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_6 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_7 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_5 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_8 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_9 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.CheckBox gui_Check_Box_10 = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.table.TableLayout(5, 2));
    protected com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_5 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_6 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_7 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_8 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Check_Box.addActionListener(callback);
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

            if(sourceComponent == gui_Check_Box) {
                onCheck_BoxActionEvent(ev);
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
        gui_Label_3.setPreferredSizeStr("62.5062mm 11.905943mm");
        gui_Label_3.setText("To do list");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:8.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:0; alignment:center; margin:30px inherit 30px inherit; padding:inherit inherit inherit inherit;");
        gui_Label_3.setName("Label_3");
        gui_ListFrame.setScrollableY(false);
        gui_ListFrame.setUIID("ContentPane");
                gui_ListFrame.setInlineStylesTheme(resourceObjectInstance);
        gui_ListFrame.setInlineAllStyles("border:none; margin:inherit inherit inherit inherit; padding:0px 30px 0px 30px;");
        gui_ListFrame.setName("ListFrame");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setInlineAllStyles("transparency:0; margin:inherit inherit inherit inherit; padding:inherit inherit inherit inherit;");
        gui_Container_3.setName("Container_3");
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_ListFrame);
        gui_Check_Box.setSelected(false);
                gui_Check_Box.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box.setInlineAllStyles("border:none; fgColor:0;");
        gui_Check_Box.setInlineUnselectedStyles("border:none; fgColor:0;");
        gui_Check_Box.setInlineSelectedStyles("border:none; fgColor:0;");
        gui_Check_Box.setName("Check_Box");
        gui_Check_Box_12.setText("");
                gui_Check_Box_12.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_12.setName("Check_Box_12");
        gui_Check_Box_1.setText("");
                gui_Check_Box_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_1.setName("Check_Box_1");
        gui_Check_Box_2.setText("");
                gui_Check_Box_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_2.setName("Check_Box_2");
        gui_Check_Box_3.setText("");
                gui_Check_Box_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_3.setName("Check_Box_3");
        gui_Check_Box_4.setText("");
                gui_Check_Box_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_4.setName("Check_Box_4");
        gui_Check_Box_6.setText("");
                gui_Check_Box_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_6.setName("Check_Box_6");
        gui_Check_Box_7.setText("");
                gui_Check_Box_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_7.setName("Check_Box_7");
        gui_Check_Box_5.setText("");
                gui_Check_Box_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_5.setName("Check_Box_5");
        gui_Check_Box_8.setText("");
                gui_Check_Box_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_8.setName("Check_Box_8");
        gui_Check_Box_9.setText("");
                gui_Check_Box_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_9.setName("Check_Box_9");
        gui_Check_Box_10.setText("");
                gui_Check_Box_10.setInlineStylesTheme(resourceObjectInstance);
        gui_Check_Box_10.setName("Check_Box_10");
        com.codename1.ui.table.TableLayout.Constraint Check_BoxConstraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(0, 0);
        gui_ListFrame.addComponent(Check_BoxConstraint, gui_Check_Box);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_12Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(1, 0);
        gui_ListFrame.addComponent(Check_Box_12Constraint, gui_Check_Box_12);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_1Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(2, 0);
        gui_ListFrame.addComponent(Check_Box_1Constraint, gui_Check_Box_1);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_2Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(3, 0);
        gui_ListFrame.addComponent(Check_Box_2Constraint, gui_Check_Box_2);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_3Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(4, 0);
        gui_ListFrame.addComponent(Check_Box_3Constraint, gui_Check_Box_3);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_4Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(5, 0);
        gui_ListFrame.addComponent(Check_Box_4Constraint, gui_Check_Box_4);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_6Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(6, 0);
        gui_ListFrame.addComponent(Check_Box_6Constraint, gui_Check_Box_6);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_7Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(7, 0);
        gui_ListFrame.addComponent(Check_Box_7Constraint, gui_Check_Box_7);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_5Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(8, 0);
        gui_ListFrame.addComponent(Check_Box_5Constraint, gui_Check_Box_5);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_8Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(9, 0);
        gui_ListFrame.addComponent(Check_Box_8Constraint, gui_Check_Box_8);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_9Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(10, 0);
        gui_ListFrame.addComponent(Check_Box_9Constraint, gui_Check_Box_9);
        com.codename1.ui.table.TableLayout.Constraint Check_Box_10Constraint = ((com.codename1.ui.table.TableLayout)gui_ListFrame.getLayout()).createConstraint(11, 0);
        gui_ListFrame.addComponent(Check_Box_10Constraint, gui_Check_Box_10);
        gui_Container.addComponent(gui_Container_3);
        gui_Button.setPreferredSizeStr("inherit 10.516916mm");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("font:7.0mm; border:none; fgColor:fb1e03;");
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue147".charAt(0));
        gui_Container_3.addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "0px 0px 1.4mm 78.30769%").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("82.448654mm 14.485563mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("border:roundRect stroke(0.5mm 000000) +top-left +top-right +bottom-left +bottom-right 7.5mm; bgColor:ffffff; transparency:255; alignment:center; margin:inherit inherit 30px inherit; padding:inherit inherit inherit inherit;");
        gui_Container_2.setName("Container_2");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setInlineAllStyles("border:0.5mm solid 0; bgColor:ffffff; transparency:255; opacity:255; margin:0px 0px 0px 0px; padding:inherit inherit inherit inherit;");
        gui_Container_4.setName("Container_4");
                gui_Container_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_7.setInlineAllStyles("padding:30px inherit inherit inherit;");
        gui_Container_7.setName("Container_7");
        gui_Container_1.addComponent(gui_Container_2);
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setInlineAllStyles("alignment:left; margin:inherit inherit inherit 30px; padding:inherit inherit inherit inherit;");
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"\ue314".charAt(0));
        gui_Label.setText("SUN 29 AUG");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:7.0mm; fgColor:0; alignment:center; margin:inherit 0px inherit 0px; padding:inherit inherit inherit inherit;");
        gui_Label.setName("Label");
                gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setInlineAllStyles("alignment:right; margin:inherit 30px inherit inherit; padding:inherit inherit inherit inherit;");
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2,"\ue315".charAt(0));
        gui_Container_2.addComponent(gui_Button_1);
        gui_Container_2.addComponent(gui_Label);
        gui_Container_2.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_1.setText("Event");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:6.0mm; fgColor:0; alignment:center; margin:30px inherit 30px inherit;");
        gui_Label_1.setName("Label_1");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setInlineAllStyles("transparency:0; padding:inherit 30px inherit 30px;");
        gui_Container_5.setName("Container_5");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setInlineAllStyles("transparency:0; margin:inherit inherit inherit inherit; padding:inherit inherit inherit inherit;");
        gui_Container_6.setName("Container_6");
        gui_Container_4.addComponent(gui_Label_1);
        gui_Container_4.addComponent(gui_Container_5);
        gui_Text_Field_1.setHint("");
        gui_Text_Field_1.setText("11:00");
                gui_Text_Field_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_1.setInlineAllStyles("font:3.0mm; border:none; padding:inherit inherit inherit inherit;");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Text_Field_1.setColumns(20);
        gui_Text_Field_3.setText("12:00");
                gui_Text_Field_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_3.setInlineAllStyles("font:3.0mm; border:none;");
        gui_Text_Field_3.setName("Text_Field_3");
        gui_Text_Field_3.setColumns(20);
        gui_Text_Field_5.setText("13:00");
                gui_Text_Field_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_5.setInlineAllStyles("font:3.0mm; border:none;");
        gui_Text_Field_5.setName("Text_Field_5");
        gui_Text_Field_5.setColumns(20);
        gui_Text_Field.setText("15:00");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setInlineAllStyles("border:none;");
        gui_Text_Field.setName("Text_Field");
        gui_Text_Field_2.setText("19:00");
                gui_Text_Field_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_2.setInlineAllStyles("border:none;");
        gui_Text_Field_2.setName("Text_Field_2");
        com.codename1.ui.table.TableLayout.Constraint Text_Field_1Constraint = ((com.codename1.ui.table.TableLayout)gui_Container_5.getLayout()).createConstraint(0, 0);
        gui_Container_5.addComponent(Text_Field_1Constraint, gui_Text_Field_1);
        com.codename1.ui.table.TableLayout.Constraint Text_Field_3Constraint = ((com.codename1.ui.table.TableLayout)gui_Container_5.getLayout()).createConstraint(1, 0);
        gui_Container_5.addComponent(Text_Field_3Constraint, gui_Text_Field_3);
        com.codename1.ui.table.TableLayout.Constraint Text_Field_5Constraint = ((com.codename1.ui.table.TableLayout)gui_Container_5.getLayout()).createConstraint(2, 0);
        gui_Container_5.addComponent(Text_Field_5Constraint, gui_Text_Field_5);
        com.codename1.ui.table.TableLayout.Constraint Text_FieldConstraint = ((com.codename1.ui.table.TableLayout)gui_Container_5.getLayout()).createConstraint(3, 0);
        gui_Container_5.addComponent(Text_FieldConstraint, gui_Text_Field);
        com.codename1.ui.table.TableLayout.Constraint Text_Field_2Constraint = ((com.codename1.ui.table.TableLayout)gui_Container_5.getLayout()).createConstraint(4, 0);
        gui_Container_5.addComponent(Text_Field_2Constraint, gui_Text_Field_2);
        gui_Container_4.addComponent(gui_Container_6);
                gui_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_3.setInlineAllStyles("font:7.0mm; fgColor:fb1e03; transparency:0; opacity:255;");
        gui_Button_3.setName("Button_3");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_3,"\ue147".charAt(0));
        gui_Container_6.addComponent(gui_Button_3);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_3.getParent().getLayout()).setInsets(gui_Button_3, "0px 0px 1.4mm auto").setReferenceComponents(gui_Button_3, "-1 -1 -1 -1").setReferencePositions(gui_Button_3, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_7);
        gui_Label_2.setText(" Mood :");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:5.0mm; fgColor:0;");
        gui_Label_2.setName("Label_2");
                gui_Container_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_8.setInlineAllStyles("margin:inherit inherit inherit 280px; padding:inherit inherit inherit inherit;");
        gui_Container_8.setName("Container_8");
        gui_Container_7.addComponent(gui_Label_2);
        gui_Container_7.addComponent(gui_Container_8);
                gui_Button_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_4.setInlineAllStyles("font:6.0mm; border:none; fgColor:d33419; padding:0px 0px 0px 0px;");
        gui_Button_4.setName("Button_4");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_4,"\ue061".charAt(0));
                gui_Button_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_5.setInlineAllStyles("font:6.0mm; fgColor:e0603c; padding:0px 0px 0px 0px;");
        gui_Button_5.setName("Button_5");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_5,"\ue061".charAt(0));
                gui_Button_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_6.setInlineAllStyles("font:6.0mm; fgColor:e89902; padding:0px 0px 0px 0px;");
        gui_Button_6.setName("Button_6");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_6,"\ue061".charAt(0));
                gui_Button_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_7.setInlineAllStyles("font:6.0mm; fgColor:496212; padding:0px 0px 0px 0px;");
        gui_Button_7.setName("Button_7");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_7,"\ue061".charAt(0));
                gui_Button_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_8.setInlineAllStyles("font:6.0mm; fgColor:18468d; padding:0px 0px 0px 0px;");
        gui_Button_8.setName("Button_8");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_8,"\ue061".charAt(0));
        gui_Container_8.addComponent(gui_Button_4);
        gui_Container_8.addComponent(gui_Button_5);
        gui_Container_8.addComponent(gui_Button_6);
        gui_Container_8.addComponent(gui_Button_7);
        gui_Container_8.addComponent(gui_Button_8);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "40px 50.0% 40px 40px").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "40px 40px 40px 50.0%").setReferenceComponents(gui_Container_1, "-1 -1 -1 0 ").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
