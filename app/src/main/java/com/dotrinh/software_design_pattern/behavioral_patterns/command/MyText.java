/*
 * Created by dotrinh on 10/18/22, 8:28 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;

import static com.dotrinh.software_design_pattern.tools.LogUtil.LogI;

public class MyText extends BaseCmdClass {

    public MyText(String str) {
        super.name = str;
    }

    @Override
    public void undo() {
        LogI("Đã undo");
    }

    @Override
    public void redo() {
        LogI("Đã redo");
    }
}
