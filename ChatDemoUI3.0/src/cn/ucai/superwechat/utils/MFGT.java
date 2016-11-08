package cn.ucai.superwechat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.baidu.platform.comapi.map.A;
import com.hyphenate.easeui.domain.User;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.ui.AddContactActivity;
import cn.ucai.superwechat.ui.AddFriendActivity;
import cn.ucai.superwechat.ui.LoginActivity;
import cn.ucai.superwechat.ui.MainActivity;
import cn.ucai.superwechat.ui.NewFriendActivity;
import cn.ucai.superwechat.ui.ProfileFragment;
import cn.ucai.superwechat.ui.RegisterActivity;
import cn.ucai.superwechat.ui.SettingsActivity;
import cn.ucai.superwechat.ui.UserProfileActivity;


public class MFGT {
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
    public static void gotoMainActivity(Activity context){
        startActivity(context, MainActivity.class);
    }
    public static void startActivity(Activity context, Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }

    public static void startActivity(Context context, Intent intent){
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    public static void gotoLogin(Activity context){
        startActivity(context,LoginActivity.class);
    }
    public static void gotoRegister(Activity context){
        startActivity(context, RegisterActivity.class);
    }

    public static void gotoSetting(Activity context) {
        startActivity(context, SettingsActivity.class);
    }
    public static void gotoUserProfile(Activity context) {
        startActivity(context, UserProfileActivity.class);
    }
    public static void gotoAddFriend(Activity context) {
        startActivity(context, AddContactActivity.class);
    }
    public static void gotoNewFriend(Activity context, User user) {
        Intent intent=new Intent();
        intent.setClass(context, NewFriendActivity.class);
        intent.putExtra(I.User.USER_NAME,user);
        startActivity(context, AddContactActivity.class);
    }
    public static void gotoAddFriend(Activity context,String username) {
        Intent intent=new Intent();
        intent.setClass(context,AddFriendActivity.class);
        intent.putExtra(I.User.USER_NAME,username);
        startActivity(context,intent);
    }
}
