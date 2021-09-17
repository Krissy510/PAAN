package com.example.myapp;

import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.WEST;

public class Event extends Container {
    private TextField listEvent;
    private TextField time;

    public Event(String text, String timeText) {
        super(new BorderLayout());
        listEvent = new TextField(text);
        listEvent.setUIID("Label");
        time = new TextField(timeText);
        time.setUIID("Label");
        add(WEST, time);
        add(CENTER, listEvent);
    }

}
