package com.test.app.Shirley.InjectCompile;

import android.app.Activity;

import com.test.app.Shirley.Injectes.views.ContentLayout;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ContentLayoutParser implements Config {

   public static void injectContentView(Activity activity) throws Exception {
        Class injectC = activity.getClass();
        if (injectC.isAnnotationPresent(ContentLayout.class)) {
            ContentLayout contentView = (ContentLayout) injectC.getAnnotation(ContentLayout.class);
            //获取注解值
            int layoutID = contentView.value();
            //获取方法 使用时 要 invoke
            try {
                Method method = injectC.getMethod(SET_CONTENT_VIEW, int.class);
                method.setAccessible(true);
                method.invoke(activity, layoutID);
            } catch (Exception e) {
                throw new Exception(e.getLocalizedMessage().toString());
            }
        }
    }

}
