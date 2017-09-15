package com.test.app.Shirley.Injectes.views;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/7/10.
 */

//表示字段
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewID {
    //id 表示哪些控件，-1 表示默认值
    int value() default -1;
}


