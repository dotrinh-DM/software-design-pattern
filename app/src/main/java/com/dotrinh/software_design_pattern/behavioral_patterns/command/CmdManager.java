/*
 * Created by dotrinh on 10/18/22, 10:00 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.behavioral_patterns.command;


import java.util.Stack;

public class CmdManager {

    private static CmdManager ourInstance = new CmdManager();
    private Stack<BaseCmdClass> undoStack = new Stack<>();
    private Stack<BaseCmdClass> redoStack = new Stack<>();

    public static synchronized CmdManager getIO() {
        if (ourInstance == null) {
            ourInstance = new CmdManager();
        }
        return ourInstance;
    }

    public void addUndoStack(BaseCmdClass cmdObj) {
        undoStack.push(cmdObj);// add to top of stack
    }

    public void addRedoStack(BaseCmdClass cmdObj) {
        redoStack.push(cmdObj);
    }

    public void setUndoStack() { // Undo
        if (!undoStack.empty()) {
            BaseCmdClass cmdObj = undoStack.pop();
            addRedoStack(cmdObj);
            cmdObj.undo();
        }
    }

    public void setRedoStack() { // Redo
        if (!redoStack.empty()) {
            BaseCmdClass cmdObj = redoStack.pop();
            addUndoStack(cmdObj);
            cmdObj.redo();
        }
    }

    public BaseCmdClass peekUndoStack() {
        if (!undoStack.empty()) {
            return undoStack.peek(); //without removing it from the stack.
        }
        return null;
    }

    public BaseCmdClass peekRedoStack() {
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
