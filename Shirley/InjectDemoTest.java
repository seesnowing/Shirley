package com.test.app.Shirley;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import com.test.app.R;
import com.test.app.Shirley.InjectCompile.ShirleyUtils;
import com.test.app.Shirley.Injectes.views.ContentLayout;
import com.test.app.Shirley.Injectes.views.OnClick;
import com.test.app.Shirley.Injectes.views.ViewID;

/**
 * Created by Administrator on 2017/7/10.
 */
@ContentLayout(R.layout.ioc_test_layout)
public class InjectDemoTest extends Activity {
    @ViewID(R.id.testPlainView)
    private TextView plainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这一句代码，初始化所有view，以及监听。
        ShirleyUtils.inject(this);
        plainView.setText("hello");

    }

    @OnClick({R.id.testPlainView})
    public void doSumbmit(View view){
        Snackbar.make(view, "点击测试事件",Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}





