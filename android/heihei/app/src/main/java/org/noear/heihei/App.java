package org.noear.heihei;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import org.noear.heihei.dao.Setting;

import java.util.Iterator;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by yuety on 2017/8/3.
 */

public class App extends Application {
    private static App mCurrent;
    @Override
    public void onCreate() {
        super.onCreate();

        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);

        mCurrent = this;

        if (TextUtils.isEmpty(processAppName)) {
            return;
        }

        Setting.tryInit();

        JPushInterface.setDebugMode(false); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }

    public static App getCurrent(){
        return mCurrent;
    }

    public static Context getContext() {
        return mCurrent.getApplicationContext();
    }

    public static SharedPreferences getSettings(String name, int mode){
        return mCurrent.getSharedPreferences(name,mode);
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return processName;
    }


}
