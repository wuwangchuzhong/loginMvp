package com.zyw.horrarndoo.yizhi.presenter.login;

import com.zyw.horrarndoo.yizhi.contract.login.LoginContract;
import com.zyw.horrarndoo.yizhi.model.bean.login.MePricleBean;
import com.zyw.horrarndoo.yizhi.model.login.LoginModel;

import io.reactivex.functions.Consumer;

/**
 * 功能：登录p层
 * 作者：miao
 * 日期：2018/4/8
 */

public class LoginPresenter extends LoginContract.LoginPresenter {

    public static LoginPresenter newInstance(){
        return new LoginPresenter();
    }

    @Override
    public LoginModel getModel() {
        return LoginModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadCode(String phone,String auctionId) {
        if (mIModel==null&&mIView==null)
            return;
        mRxManager.register(mIModel.getLoginCode(phone,auctionId).subscribe(new Consumer<MePricleBean>() {
            @Override
            public void accept(MePricleBean bean) throws Exception {
                mIView.showLoginCode(bean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView==null)
                    return;
                mIView.showToast("Network error.");
                mIView.showNetError();
            }
        }));
    }

    @Override
    public void login(String account, String password) {

    }
}
