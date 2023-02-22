package org.noear.heihei.dao;

import android.content.Context;

import org.noear.heihei.App;
import org.noear.heihei.utils.SettingsUtil;

/**
 * Created by yuety on 2017/8/3.
 */

public class Session {
    public static String userName() {
        return Setting.getString("user_name","");
    }

    public static void setUserName(String userName) {
        Setting.setString("user_name", userName);
    }
}
