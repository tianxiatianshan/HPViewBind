package com.peace.hp.viewbind;

import android.app.Activity;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.peace.hp.viewbind.util.HpReflectUtil;
import com.peace.hp.viewbind.util.ObjectUtil;

/**
 * @Author: HePing
 * @Date: 2019/10/30
 * @Description:
 */
public class HpBind {

    public static void bind(Activity activity) {
        ObjectUtil.requireNonNull(activity);
        View decorView = activity.getWindow().getDecorView();
        HpReflectUtil.startReflect(activity, decorView);
    }

    public static void bind(Fragment fragment) {
        ObjectUtil.requireNonNull(fragment);
        View view = fragment.getView();
        HpReflectUtil.startReflect(fragment, view);
    }

    public static void bind(Object target, View rootView) {
        ObjectUtil.requireNonNull(target);
        ObjectUtil.requireNonNull(rootView);
        HpReflectUtil.startReflect(target, rootView);
    }
}
