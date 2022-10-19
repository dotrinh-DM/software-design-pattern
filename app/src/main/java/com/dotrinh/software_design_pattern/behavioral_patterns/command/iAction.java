/*
 * Created by dotrinh on 10/18/22, 9:57 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;

/**
 * Dung interface de mo rong tot hon
 * có thể dùng cách khác là abstract class nhung kho mo rong
 */
public interface iAction {
    void undo();
    void redo();
}
