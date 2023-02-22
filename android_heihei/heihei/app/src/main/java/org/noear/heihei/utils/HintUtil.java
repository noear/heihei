package org.noear.heihei.utils;

import android.app.AlertDialog;
import android.view.Gravity;
import android.widget.Toast;

import org.noear.heihei.App;

/**
 * Created by yuety on 2017/8/3.
 */

public class HintUtil {
    public static void show(String msg){
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static void show2(String msg){
        Toast toast= Toast.makeText(App.getContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void alert(String text){
        new AlertDialog.Builder(App.getContext())
                .setTitle("消息")
                .setMessage(text)
                .setNegativeButton("关闭", (dialog, which) -> {
                }).show();
    }

}
