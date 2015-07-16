package com.yihua.wechat.model;

/**
 * 微信返回码
 * Created by brokenq on 2015/7/16.
 */
public class WxResp {

//    错误码（0正确，其他错误）
    private int errcode;
//    错误信息
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
