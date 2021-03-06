package cn.ucai.superwechat.data;

import android.content.Context;
import android.widget.CheckBox;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;

import java.io.File;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.SuperWechatHelper;
import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.utils.MD5;


/**
 * Created by Administrator on 2016/10/17.
 */

/**
 * Dao层连接服务下载数据.
 */
public class NetDao {
    /**
     * 用户注册
     */
    public static void Register(Context context, String userName, String userNick
    , String passWord, OkHttpUtils.OnCompleteListener<Result>listener){
    OkHttpUtils<Result> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_REGISTER)
                .addParam(I.User.USER_NAME,userName)
                .addParam(I.User.NICK,userNick)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(passWord))
                .targetClass(Result.class)
                .post()
                .execute(listener);
    }

    /**
     *用户取消注册
     */
    public static void unRegister(Context context, String userName,OkHttpUtils.OnCompleteListener<Result>listener){
        OkHttpUtils<Result> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UNREGISTER)
                .addParam(I.User.USER_NAME,userName)
                .targetClass(Result.class)
                .execute(listener);
    }

    /**
     * 用户登录
     * @param context 上下文
     * @param userName 用户名
     * @param passWord 密码
     * @param listener listener
     */
    public static void Login(Context context, String userName, String passWord, OkHttpUtils.OnCompleteListener<String>listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_LOGIN)
                .addParam(I.User.USER_NAME,userName)
                .addParam(I.User.PASSWORD,MD5.getMessageDigest(passWord))
                .targetClass(String.class)
                .execute(listener);
    }
    public static void updateNick(Context context, String userName, String nick, OkHttpUtils.OnCompleteListener<String>listener){
        OkHttpUtils<String> utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UPDATE_USER_NICK)
                .addParam(I.User.USER_NAME,userName)
                .addParam(I.User.NICK,nick)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void updateAvatar(Context context, String username, File file, OkHttpUtils.OnCompleteListener<String> listener){
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_UPDATE_AVATAR)
                .addParam(I.NAME_OR_HXID,username)
                .addParam(I.AVATAR_TYPE,I.AVATAR_TYPE_USER_PATH)
                .addFile2(file)
                .targetClass(String.class)
                .post()
                .execute(listener);
    }
    public static void syncUserInfo(Context context, String username, OkHttpUtils.OnCompleteListener<String>listener){
        OkHttpUtils<String>utils=new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_FIND_USER)
                .addParam(I.User.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);
    }

    public static void searchUser(Context context, String username, OkHttpUtils.OnCompleteListener<String> listener){
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_FIND_USER)
                .addParam(I.User.USER_NAME,username)
                .targetClass(String.class)
                .execute(listener);
    }

    /**
     * 添加好友
     */
    public static void addContact(Context context, String username,String cusername ,OkHttpUtils.OnCompleteListener<String> listener){
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_ADD_CONTACT)
                .addParam(I.Contact.USER_NAME,username)
                .addParam(I.Contact.CU_NAME,cusername)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void deleteContact(Context context, String username,String cusername ,OkHttpUtils.OnCompleteListener<String> listener){
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DELETE_CONTACT)
                .addParam(I.Contact.USER_NAME,username)
                .addParam(I.Contact.CU_NAME,cusername)
                .targetClass(String.class)
                .execute(listener);
    }
    public static void loadContact(Context context,OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_DOWNLOAD_CONTACT_ALL_LIST)
                .addParam(I.Contact.USER_NAME, EMClient.getInstance().getCurrentUser())
                .targetClass(String.class)
                .execute(listener);
    }
    public static void createGroup(Context context, EMGroup emGroup, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_CREATE_GROUP)
                .addParam(I.Group.HX_ID,emGroup.getGroupId())
                .addParam(I.Group.NAME,emGroup.getGroupName())
                .addParam(I.Group.DESCRIPTION,emGroup.getDescription())
                .addParam(I.Group.OWNER,emGroup.getOwner())
                .addParam(I.Group.IS_PUBLIC, String.valueOf(emGroup.isPublic()))
                .addParam(I.Group.ALLOW_INVITES, String.valueOf(emGroup.isAllowInvites()))
                .targetClass(String.class)
                .post()
                .execute(listener);
    }
    public static void createGroup(Context context, EMGroup emGroup,File file, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_CREATE_GROUP)
                .addParam(I.Group.HX_ID,emGroup.getGroupId())
                .addParam(I.Group.NAME,emGroup.getGroupName())
                .addParam(I.Group.DESCRIPTION,emGroup.getDescription())
                .addParam(I.Group.OWNER,emGroup.getOwner())
                .addParam(I.Group.IS_PUBLIC, String.valueOf(emGroup.isPublic()))
                .addParam(I.Group.ALLOW_INVITES, String.valueOf(emGroup.isAllowInvites()))
                .targetClass(String.class)
                .addFile2(file)
                .post()
                .execute(listener);
    }
    public static void addGroupMebers(Context context, EMGroup emGroup, OkHttpUtils.OnCompleteListener<String> listener) {
        String memberArr="";
        for (String m:emGroup.getMembers()){
            if(!m.equals(SuperWechatHelper.getInstance().getCurrentUsernName())){
                memberArr +=m+",";
            }
        }
        memberArr=memberArr.substring(0,memberArr.length()-1);
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_ADD_GROUP_MEMBERS)
                .addParam(I.Member.GROUP_HX_ID,emGroup.getGroupId())
                .addParam(I.Member.USER_NAME,memberArr)
                .targetClass(String.class)
                .execute(listener);
    }

}