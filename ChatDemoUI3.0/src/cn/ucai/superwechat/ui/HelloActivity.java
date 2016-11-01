package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;

public class HelloActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_hello_login, R.id.bt_hello_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_hello_login:
                break;
            case R.id.bt_hello_register:
                break;
        }
    }
}
