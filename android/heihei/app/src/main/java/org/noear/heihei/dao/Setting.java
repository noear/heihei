package org.noear.heihei.dao;

import android.content.Context;

import org.noear.heihei.App;
import org.noear.heihei.utils.SettingsUtil;

/**
 * Created by yuety on 2017/8/3.
 */

public class Setting extends SettingsUtil {
    static {
        mSets = App.getSettings("setting", Context.MODE_PRIVATE);
    }

    public static void tryInit(){

    }
}
