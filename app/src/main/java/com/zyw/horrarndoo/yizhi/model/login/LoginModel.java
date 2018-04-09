package com.zyw.horrarndoo.yizhi.model.login;

import com.zyw.horrarndoo.sdk.base.BaseModel;
import com.zyw.horrarndoo.sdk.helper.RetrofitCreateHelper;
import com.zyw.horrarndoo.sdk.helper.RxHelper;
import com.zyw.horrarndoo.yizhi.api.DoubanApi;
import com.zyw.horrarndoo.yizhi.contract.login.LoginContract;
import com.zyw.horrarndoo.yizhi.model.bean.login.MePricleBean;

import io.reactivex.functions.Function;

/**
 * 功能：登录数据返回是否正确登录
 * 作者：miao
 * 日期：2018/4/8
 */

public class LoginModel extends BaseModel implements LoginContract.ILoginModel {

    public static LoginModel newInstance(){
        return new LoginModel();
    }

    @Override
    public io.reactivex.Observable<MePricleBean> getLoginCode(String userId, String auctionId) {
        return RetrofitCreateHelper.createApi(DoubanApi.class,DoubanApi.HOST).getLoginCode(userId,auctionId)
                .compose(RxHelper.<MePricleBean>rxSchedulerHelper())
                .map(new Function<MePricleBean, MePricleBean>() {
                    @Override
                    public MePricleBean apply(MePricleBean bean) throws Exception {
                        return bean;
                    }
                });
    }
}
