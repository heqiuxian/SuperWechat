package cn.ucai.superwechat.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easemob.redpacketui.utils.RedPacketUtil;
import com.hyphenate.easeui.utils.EaseUserUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

public class ProfileFragment extends Fragment {
    Activity mContext;
    @BindView(R.id.iv_profile_avatar)
    ImageView ivProfileAvatar;
    @BindView(R.id.tv_profile_nick)
    TextView tvProfileNick;
    @BindView(R.id.tv_profile_wxh)
    TextView tvProfileWxh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        initView();
        return view;
    }

    private void initView() {
        EaseUserUtils.setCurrentAppUserAvatar(getActivity(),ivProfileAvatar);
        EaseUserUtils.setCurrentAppUserNick(tvProfileNick);
        EaseUserUtils.setCurrentAppUserNameWithNo(tvProfileWxh);
    }

    @OnClick({R.id.tv_profile_money, R.id.tv_profile_setting,R.id.layout_profile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_profile_money:
                RedPacketUtil.startChangeActivity(getActivity());
                break;
            case R.id.tv_profile_setting:
                MFGT.gotoSetting(mContext);
                break;
            case R.id.layout_profile:
                MFGT.gotoUserProfile(mContext);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }
}
