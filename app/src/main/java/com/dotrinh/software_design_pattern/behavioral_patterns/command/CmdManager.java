/*
 * Created by dotrinh on 10/18/22, 10:00 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;


import static com.dotrinh.software_design_pattern.tools.LogUtil.LogI;

import java.util.Stack;

public class CmdManager {

    private static CmdManager ourInstance = new CmdManager();
    private Stack<iAction> undoStack = new Stack<>();
    private Stack<iAction> redoStack = new Stack<>();

    public static synchronized CmdManager getIO() {
        if (ourInstance == null) {
            ourInstance = new CmdManager();
        }
        return ourInstance;
    }

    public void addUndoStack(iAction cmdObj) {
        LogI("add to stack: " + ((MyComponent) cmdObj).getName());
        undoStack.push(cmdObj);// add to top of stack
    }

    public void addRedoStack(iAction cmdObj) {
        redoStack.push(cmdObj);
    }

    public void undo() { // Undo
        if (!undoStack.empty()) {
            iAction cmdObj = undoStack.pop();
            addRedoStack(cmdObj);
            cmdObj.undo(); //call subscribers
        }
    }

    public void redo() { // Redo
        if (!redoStack.empty()) {
            iAction cmdObj = redoStack.pop();
            addUndoStack(cmdObj);
            cmdObj.redo();
        }
    }

    public iAction peekUndoStack() {
        if (!undoStack.empty()) {
            return undoStack.peek(); //without removing it from the stack.
        }
        return null;
    }

    public void print() {
        for (iAction ia : undoStack) {
            LogI("name: " + ((MyComponent) ia).getName());
        }
    }

    public iAction peekRedoStack() {
        if (!redoStack.empty()) {
            return redoStack.peek();
        }
        return null;
    }

    public int countUndo() {
        return undoStack.size();
    }

    public int countRedo() {
        return redoStack.size();
    }
}
