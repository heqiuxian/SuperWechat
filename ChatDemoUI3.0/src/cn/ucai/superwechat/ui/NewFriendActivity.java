package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.utils.EaseUserUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.SuperWechatHelper;
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

    User user = null;
    @BindView(R.id.btn_add_contact)
    Button btnAddContact;
    @BindView(R.id.btn_send_msg)
    Button btnSendMsg;
    @BindView(R.id.btn_send_video)
    Button btnSendVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_friend);
        ButterKnife.bind(this);
        user = (User) getIntent().getSerializableExtra(I.User.USER_NAME);
        if (user == null) {
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
        isFriend();
    }

    private void setUserInfo() {
        EaseUserUtils.setAppUserAvatar(this, user.getMUserName(), profileImage);
        EaseUserUtils.setAppUserNick(user.getMUserNick(), tvUserinfoNick);
        EaseUserUtils.setAppUserNameWithNo(user.getMUserName(), tvUserinfoName);
    }


    public void isFriend() {
        if (SuperWechatHelper.getInstance().getAppContactList().containsKey(user.getMUserName())) {
            btnSendMsg.setVisibility(View.VISIBLE);
            btnSendVideo.setVisibility(View.VISIBLE);
        } else {
            btnAddContact.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.iv_title_back, R.id.btn_add_contact, R.id.btn_send_msg, R.id.btn_send_video})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back:
                MFGT.finish(this);
                break;
            case R.id.btn_add_contact:
                MFGT.gotoAddFriend(this,user.getMUserName());
                break;
            case R.id.btn_send_msg:
                break;
            case R.id.btn_send_video:
                break;
        }
    }
}
