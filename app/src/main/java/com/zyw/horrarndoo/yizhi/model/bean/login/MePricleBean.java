package com.zyw.horrarndoo.yizhi.model.bean.login;

/**
 * Created by miao on 2017/7/26.
 * 用户额度查询（这里假设登录接口，返回验证码）
 */

public class MePricleBean {

    /**
     * credit : 9672900
     */

    private DataBean data;
    /**
     * data : {"credit":9672900}
     * message : 获取用户信誉额成功！
     * stateCode : 101
     */

    private String message;
    private int stateCode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public static class DataBean {
        private int credit;

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }
    }
}
