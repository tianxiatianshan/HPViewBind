package com.peace.hp.viewbind.util;

import android.content.Context;

/**
 * @Author: HePing
 * @Date: 2019/10/31
 * @Description:
 */
public class ResUtil {

    public static int getResId(Context context, String id, String type) {
        return context.getResources().getIdentifier(id, type, context.getPackageName());
    }
}
