/*
 * Created by dotrinh on 10/18/22, 8:44 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.creational_patterns;

import android.content.Context;
import android.widget.Toast;

/**
 The singleton pattern allows objects to:
 * Ensure they only have one instance
 * Provide easy access to that instance
 * Control their instantiation (for example, hiding the constructors of a class)
 * https://en.wikipedia.org/wiki/Singleton_pattern
 *
 * vi:
 * toàn ứng dụng chỉ thao tác với 1 đối tượng duy nhất, không tạo lại đối tượng lần thứ 2
 */
public class Singleton_Toast_1 {

    private static Singleton_Toast_1 ourInstance = new Singleton_Toast_1();
    private static Toast toast;

    public static synchronized Singleton_Toast_1 getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton_Toast_1();
        }
        return ourInstance;
    }

    public void showShortToast(Context ct, String message) {
        if (null != toast) {
            toast.cancel();
        }
        (toast = Toast.makeText(ct, message, Toast.LENGTH_SHORT)).show();
    }

    public void showLongToast(Context ct, String message) {
        if (null != toast) {
            toast.cancel();
        }
        (toast = Toast.makeText(ct, message, Toast.LENGTH_LONG)).show();
    }
}
