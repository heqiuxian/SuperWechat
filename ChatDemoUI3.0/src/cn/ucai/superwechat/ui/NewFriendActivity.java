package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.utils.EaseUserUtils;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

public class NewFriendActivity extends BaseActivity {

    @BindView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.iv_txt_right)
    TextView ivTxtRight;
    @BindView(R.id.profile_image)
    ImageView profileImage;
    @BindView(R.id.tv_userinfo_nick)
    TextView tvUserinfoNick;
    @BindView(R.id.tv_userinfo_name)
    TextView tvUserinfoName;

    User user=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_friend);
        ButterKnife.bind(this);
        user= (User) getIntent().getSerializableExtra(I.User.USER_NAME);
        if(user==null){
            MFGT.finish(this);
        }
        initView();
    }

    private void initView() {
        ivTitleBack.setVisibility(View.VISIBLE);
        tvTitleText.setVisibility(View.VISIBLE);
        ivTxtRight.setVisibility(View.VISIBLE);
        tvTitleText.setText(R.string.userinfo_txt_profile);
        setUserInfo();
    }
    private void setUserInfo() {
        EaseUserUtils.setAppUserAvatar(this, user.getMUserName(), profileImage);
        EaseUserUtils.setAppUserNick(user.getMUserNick(), tvUserinfoNick);
        EaseUserUtils.setAppUserNameWithNo(user.getMUserName(), tvUserinfoName);
    }

    @OnClick({R.id.iv_title_back, R.id.iv_txt_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back:
                break;
            case R.id.iv_txt_right:
                break;
        }
    }
}
