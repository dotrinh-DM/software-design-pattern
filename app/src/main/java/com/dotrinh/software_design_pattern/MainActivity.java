/*
 * Created by dotrinh on 10/18/22, 8:28 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern;

import static com.dotrinh.software_design_pattern.tools.LogUtil.LogI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dotrinh.software_design_pattern.behavioral_patterns.command.CmdManager;
import com.dotrinh.software_design_pattern.behavioral_patterns.command.MyButton;
import com.dotrinh.software_design_pattern.behavioral_patterns.command.MyField;
import com.dotrinh.software_design_pattern.behavioral_patterns.command.MyText;
import com.dotrinh.software_design_pattern.creational_patterns.Builder_User_2;
import com.dotrinh.software_design_pattern.creational_patterns.Singleton_Toast_1;
import com.dotrinh.software_design_pattern.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //---------------------------------- 3. Command Pattern
        CmdManager cm = CmdManager.getIO();
        cm.addUndoStack(new MyText("MyText 1"));
        cm.addUndoStack(new MyText("MyText 2"));
        cm.addUndoStack(new MyField("MyField 1"));
        cm.addUndoStack(new MyField("MyField 2"));
        //test UNDO button
        LogI("-------------------------------");
        cm.undo();
        cm.printUndoStack();
        //test REDO button
        LogI("-------------------------------");
        cm.redo();
        cm.printUndoStack();
        LogI("-------------------------------");
        MyButton myButton = new MyButton(this);
        myButton.setName("MyButton 1");
        cm.addUndoStack(myButton);
        cm.printUndoStack();

        //---------------------------------- 2. Builder Pattern
        Builder_User_2 myBuilderUser = new Builder_User_2.UserBuilder("do", "trinh").address("Vietnam").phone("0123456789").build();
        // LogI(myBuilderUser.toString());
        // LogI(myBuilderUser.getAddress());

        //---------------------------------- 1. Singleton Pattern
        Singleton_Toast_1.getInstance().showLongToast(this, "Hello");
    }
}