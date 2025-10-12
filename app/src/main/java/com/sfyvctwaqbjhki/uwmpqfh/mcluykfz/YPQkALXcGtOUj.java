package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.content.Context;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.RestoreUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean;

/* loaded from: classes.dex */
public class YPQkALXcGtOUj {
    public static ConfigBean createConfigBean(Context context) {
        try {
            ConfigBean configBean = new ConfigBean();
            configBean.setAppId(Integer.parseInt(RestoreUtil.decrypt(context.getString(R.string.cg_a_d))));
            configBean.setAppKey(RestoreUtil.decrypt(context.getString(R.string.cg_a_k)));
            configBean.setUrl(RestoreUtil.decrypt(context.getString(R.string.cg_a_add)));
            configBean.setLoginJson(context.getString(R.string.pg_login_method));
            configBean.setAdvChannel(context.getString(R.string.pg_adv_channel));
            return configBean;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
