package ru.guar7387.surfaceviewsample.utils;

import android.util.Log;

public class Logger {

    private static final boolean isDebug = true;

    public static void log(String tag, String message) {
        if (isDebug) {
            Log.i(tag, message);
        }
    }

}
