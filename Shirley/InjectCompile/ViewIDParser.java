package com.test.app.Shirley.InjectCompile;

import android.app.Activity;
import android.view.View;

import com.test.app.Shirley.Injectes.views.ViewID;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/7/10.
 */
class ViewIDParser implements Config{
    public static void inject(Object object){

        try {
          parseViewID(object);
        }catch (Exception e){
            
        }
    }

    private static void parseViewID(Object object)throws Exception{
        //先反射找到了这个注解类
        final  Class<?> injectClass=object.getClass();
        Field[] classFields=injectClass.getDeclaredFields();
        View view=null;
        for(int i=0;i<classFields.length;i++){
            Field field=classFields[i];
            //是否带有注解类型
            if(field.isAnnotationPresent(ViewID.class)){
                //获取这个注解的view
                ViewID injectViewID=field.getAnnotation(ViewID.class);
                //获取这个注解的id
                int id=injectViewID.value();
                if(id<0){
                    throw new Exception("parser view id <0 is not avalid");
                }else{
                    field.setAccessible(true);
                    if(object instanceof View){
                        view=((View)object).findViewById(id);
                    }else if (object instanceof Activity){
                       view=((Activity)object).findViewById(id);
                    }
                    field.set(object,view);
                }
            }

        }

    }


}
