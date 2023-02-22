package org.noear.heihei.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import org.noear.heihei.utils.ext.Act0;

/**
 * Created by yuety on 2017/8/3.
 */

public class CallUtil {
    public static void asynCall(int delayMillis, Act0 fun) {
        new Handler().postDelayed(() -> {
            fun.run();
        }, delayMillis);
    }

    public static void asynCall(Act0 fun) {
        asynCall(10, fun);
    }

    public static void mainCall(Act0 fun){
        new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                fun.run();
            }
        }.sendEmptyMessage(1);
    }
}
