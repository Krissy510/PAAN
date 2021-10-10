package com.example.myapp;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.WEST;

public class TodoList extends Container {
    private TextField list;
    private CheckBox check = new CheckBox();

    //Create TodoList task
    public TodoList(String text, boolean checked) {
        super(new BorderLayout());
        list = new TextField(text);
        list.setUIID("Label");
        add(WEST, check);
        add(CENTER, list);
        check.setToggle(true);
        check.setMaterialIcon(FontImage.MATERIAL_BRIGHTNESS_1, 4);
        check.setSelected(checked);
    }

}
