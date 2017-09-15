package com.test.app.Shirley.InjectCompile;

import android.app.Activity;

/**
 * Created by Administrator on 2017/7/10.
 */
public class ShirleyUtils {

    public static void inject(Activity activity){
        try {
            ContentLayoutParser.injectContentView(activity);
            ViewIDParser.inject(activity);
            OnclickParser.injectOnclick(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
