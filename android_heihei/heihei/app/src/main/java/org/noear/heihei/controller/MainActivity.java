package org.noear.heihei.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.noear.heihei.App;
import org.noear.heihei.R;
import org.noear.heihei.dao.Session;
import org.noear.heihei.utils.CallUtil;
import org.noear.heihei.utils.HintUtil;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by yuety on 2017/8/3.
 */

public class MainActivity extends ActivityBase {
    public static boolean isForeground = false;

    TextView userId;
    EditText userKey;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        userId = $(R.id.userId);
        userKey = $(R.id.userKey);
        btnSave = $(R.id.btnSave);

        init();


        CallUtil.asynCall(500, () -> {
            String user_id = JPushInterface.getRegistrationID(getApplicationContext());
            userId.setText(user_id);

            userKey.setText(Session.userName());
        });

        btnSave.setOnClickListener((v) -> {
            String alias = userKey.getText().toString();

            Session.setUserName(alias);


            if(TextUtils.isEmpty(alias) == false) {
                JPushInterface.setAlias(App.getContext(),alias,(i,s,set)->{
                    HintUtil.show("操作成功");
                });
            }else{
                JPushInterface.deleteAlias(App.getContext(), 1);
                HintUtil.show("操作成功");
            }


        });

        Intent intent = getIntent();
        tryAlert(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        tryAlert(intent);
    }

    private void tryAlert(Intent intent) {
        if (intent == null) {
            return;
        }

        Bundle bundle = intent.getExtras();

        if (bundle == null) {
            return;
        }

        String msg = bundle.getString(JPushInterface.EXTRA_MESSAGE);

        if (TextUtils.isEmpty(msg)) {
            msg = bundle.getString(JPushInterface.EXTRA_ALERT);
        }

        if (TextUtils.isEmpty(msg) == false) {
            HintUtil.show(msg);
        }
    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init(){
        JPushInterface.init(this);
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }

}
