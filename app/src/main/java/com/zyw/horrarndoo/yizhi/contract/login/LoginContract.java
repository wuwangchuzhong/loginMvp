package com.zyw.horrarndoo.yizhi.contract.login;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseModel;
import com.zyw.horrarndoo.sdk.base.IBaseView;
import com.zyw.horrarndoo.yizhi.model.bean.login.MePricleBean;

/**
 * 功能：登录的Contract
 * 作者：miao
 * 日期：2018/4/8
 */

public interface LoginContract {

    abstract class LoginPresenter extends BasePresenter<ILoginModel,ILoginView>{

        //加载发送验证码(用户id, 拍场id)
        public abstract void loadCode(String phone,String auctionId);

        //点击登录
        public abstract void login(String account,String password);

    }

    interface ILoginModel extends IBaseModel{
        /**
         * 获取验证码
         * @param userId 用户id
         * @param auctionId 拍场id
         * @return
         */
        io.reactivex.Observable<MePricleBean> getLoginCode(String userId, String auctionId);
    }

    interface ILoginView extends IBaseView {
        /**
         * 显示验证码
         * @param bean
         */
        void showLoginCode(MePricleBean bean);

        /**
         * 显示网络错误
         */
        void showNetError();

        /**
         * 显示登录是否成功
         */
        void isLogin();
    }
}
