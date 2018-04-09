package com.zyw.horrarndoo.yizhi.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.activity.BaseMVPCompatActivity;
import com.zyw.horrarndoo.yizhi.R;
import com.zyw.horrarndoo.yizhi.contract.login.LoginContract;
import com.zyw.horrarndoo.yizhi.model.bean.login.MePricleBean;
import com.zyw.horrarndoo.yizhi.presenter.login.LoginPresenter;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * 登录页
 */
public class LoginActivity extends BaseMVPCompatActivity<LoginContract.LoginPresenter, LoginContract.ILoginModel>
        implements LoginContract.ILoginView {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassWord;
    @BindView(R.id.et_login)
    TextView etLogin;
    @BindView(R.id.et_login_userid_mess)
    TextView et_login_userid_mess;


    @Override
    protected void initView(Bundle savedInstanceState) {

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = etAccount.getText().toString().trim();//922062778
                String auctionid = etPassWord.getText().toString().trim();//8671393
                if (userid.length()>0&&auctionid.length()>0){
                    mPresenter.loadCode("922062778", "8671393");
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return LoginPresenter.newInstance();
    }

    //显示登录（模拟用户查询信用额度）
    @Override
    public void showLoginCode(MePricleBean bean) {
        if (bean.getData()!=null)
        et_login_userid_mess.setText(bean.getData().getCredit()+"");
    }

    @Override
    public void showNetError() {

    }

    @Override
    public void isLogin() {

    }
}
