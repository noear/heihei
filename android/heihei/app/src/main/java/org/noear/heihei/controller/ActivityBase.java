package org.noear.heihei.controller;

import android.app.Activity;

/**
 * Created by yuety on 2017/8/3.
 */

public class ActivityBase extends Activity {
    public <T> T $(int viewID) {
        return (T) findViewById(viewID);
    }
}
