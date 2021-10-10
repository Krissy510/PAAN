package com.example.myapp;

import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;

public class Event extends Container {
    private TextField listEvent;

    //Create Event task
    public Event(String text) {
        super(new BorderLayout());
        listEvent = new TextField(text);
        listEvent.setUIID("LabelE");
        add(CENTER, listEvent);
    }

}
