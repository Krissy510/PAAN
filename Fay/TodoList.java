package com.example.myapp;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.WEST;

public class TodoList extends Container {
    private TextField list;
    private CheckBox done = new CheckBox();

    public TodoList(String text, boolean checked) {
        super(new BorderLayout());
        list = new TextField(text);
        list.setUIID("Label");
        add(WEST, done);
        add(CENTER, list);
        done.setSelected(checked);
    }

}
