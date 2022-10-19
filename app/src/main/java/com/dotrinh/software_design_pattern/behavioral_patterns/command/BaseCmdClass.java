/*
 * Created by dotrinh on 10/18/22, 9:57 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;

/**
 * lớp trừu tượng (có thể dùng cách khác là interface)
 */
public abstract class BaseCmdClass {

    public String name;

    abstract public void undo();
    abstract public void redo();
}
