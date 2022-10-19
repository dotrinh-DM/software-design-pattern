/*
 * Created by dotrinh on 10/18/22, 8:28 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;

import static com.dotrinh.software_design_pattern.tools.LogUtil.LogI;

public class MyRootComponent implements iAction {

    private String name;

    public MyRootComponent(String str) {
        name = str;
    }

    @Override
    public void undo() {
        LogI("Đã undo " + name);
    }

    @Override
    public void redo() {
        LogI("Đã redo " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return "name: " + name;
    }
}
