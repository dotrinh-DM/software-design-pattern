/*
 * Created by dotrinh on 10/18/22, 8:28 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;

import static com.dotrinh.software_design_pattern.tools.LogUtil.LogI;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Class này ngoại lệ, ko extend từ class MyRootComponent.java
 */
public class MyButton extends androidx.appcompat.widget.AppCompatButton implements iAction {

    private String name;

    public MyButton(@NonNull Context context) {
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void undo() {
        LogI("Đã undo " + name);
    }

    @Override
    public void redo() {
        LogI("Đã redo " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return "name: " + name;
    }

}
