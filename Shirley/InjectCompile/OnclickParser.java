package com.test.app.Shirley.InjectCompile;

import android.app.Activity;
import android.view.View;

import com.test.app.Shirley.Injectes.views.OnClick;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/10.
 */
 class OnclickParser implements Config {

    static void injectOnclick(final Activity activity){
        ViewIDParser.inject(activity);
        Method[] declaredMethod=activity.getClass().getDeclaredMethods();
        for(final Method method:declaredMethod){
            method.setAccessible(true);
            //找类中所有带有注解的方法
            OnClick onClick=method.getAnnotation(OnClick.class);
            if(onClick!=null){
                int values[]=onClick.value();
                for(int buttonID:values){
                    final View btn=activity.findViewById(buttonID);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity,btn);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
