package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

public class HelloActivity extends BaseActivity {
    HelloActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hello);
        ButterKnife.bind(this);
        mContext=this;
        super.onCreate(savedInstanceState);
    }


    @OnClick({R.id.bt_hello_login, R.id.bt_hello_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_hello_login:
                MFGT.gotoLogin(mContext);
                break;
            case R.id.bt_hello_register:
                MFGT.gotoRegister(mContext);
                break;
        }
    }
}
