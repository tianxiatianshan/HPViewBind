package com.peace.hp.viewbind.util;

import android.view.View;

import com.peace.hp.viewbind.annotation.BindView;
import com.peace.hp.viewbind.annotation.OnClick;
import com.peace.hp.viewbind.annotation.RBindView;
import com.peace.hp.viewbind.annotation.ROnClick;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: HePing
 * @Date: 2019/10/31
 * @Description:
 */
public class HpReflectUtil {

    public static void startReflect(Object target, View rootView) {

        ObjectUtil.requireNonNull(rootView, "Binding method call location error!");

        Class<?> targetClass = target.getClass();

        //处理成员变量
        Field[] fields = targetClass.getDeclaredFields();
        parseFields(target, rootView, fields);

        //处理方法
        Method[] methods = targetClass.getDeclaredMethods();
        parseMethods(target, rootView, methods);
    }

    private static void parseFields(Object target, View rootView, Field[] fields) {
        if (fields == null || fields.length == 0) {
            return;
        }

        for (Field field : fields) {
            parseBindView(target, rootView, field);
            parseRBindView(target, rootView, field);
        }
    }

    private static void parseMethods(Object target, View rootView, Method[] methods) {
        if (methods == null || methods.length == 0) {
            return;
        }

        for (Method method : methods) {
            parseOnClick(target, rootView, method);
            parseROnClick(target, rootView, method);
        }
    }

    private static void parseBindView(Object target, View rootView, Field field) {
        BindView bindView = field.getAnnotation(BindView.class);
        View temView;
        String resName, type;
        if (bindView != null) {
            try {
                resName = bindView.value();
                type = bindView.type();
                temView = rootView.findViewById(ResUtil.getResId(rootView.getContext(), resName, type));
                field.setAccessible(true);
                if (temView != null) {
                    field.set(target, temView);
                }
            } catch (Exception e) {
                throw new RuntimeException(bindView.value() + "inject error!");
            }
        }
    }

    private static void parseRBindView(Object target, View rootView, Field field) {
        RBindView rBindView = field.getAnnotation(RBindView.class);
        int id;
        View temView;
        if (rBindView != null) {
            try {
                id = rBindView.value();
                temView = rootView.findViewById(id);
                field.setAccessible(true);
                if (temView != null) {
                    field.set(target, temView);
                }
            } catch (Exception e) {
                throw new RuntimeException(rBindView.value() + "inject error!");
            }
        }

    }


    private static void parseOnClick(final Object target, View rootView, final Method method) {
        OnClick onClick = method.getAnnotation(OnClick.class);
        final String value;
        View view;
        if (onClick != null) {
            value = onClick.value();
            view = rootView.findViewById(ResUtil.getResId(rootView.getContext(), value, "id"));
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        invokeMethod(target, method, v);
                    }
                });
            }
        }
    }

    private static void parseROnClick(final Object target, View rootView, final Method method) {
        ROnClick rOnClick = method.getAnnotation(ROnClick.class);
        int id;
        View temView;
        if (rOnClick != null) {
            id = rOnClick.value();
            temView = rootView.findViewById(id);
            if (temView != null) {
                temView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        invokeMethod(target, method, v);
                    }
                });
            }
        }
    }

    private static void invokeMethod(Object target, Method method, Object... args) {
        try {
            method.setAccessible(true);
            method.invoke(target, args);
        } catch (Exception e) {
            throw new RuntimeException(method.getName() + ": invoke fail!");
        }
    }
}
