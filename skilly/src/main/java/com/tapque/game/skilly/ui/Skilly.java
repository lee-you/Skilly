package com.tapque.game.skilly.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.tapque.game.skilly.SkillyActivity;

public class Skilly {

    public static Application app;
    public static boolean isDebug = false;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, SkillyActivity.class);
        activity.startActivity(intent);
    }

    public static void init(Application context) {
        app = context;
    }

    public static void setDebugMode(boolean debug) {
        isDebug = debug;
    }

    public static Application getInstance() {
        return app;
    }
}
