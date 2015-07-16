package com.yihua.wechat.utils;

/**
 * 微信返回码工具类
 * Created by brokenq on 2015/7/16.
 */
public class WxRespCodeUtil {

    /**
     *  获取错误信息
     *  @param code 错误码
     *  @return 错误信息
     */
    public static String getMsg(int code){
        String msg = "";
        switch (code){
            case -1:    msg = "系统繁忙，此时请开发者稍候再试"; break;
            case 0:     msg = "请求成功"; break;
            default:    msg = "请求失败"; break;
        }
        return msg;
    }

}
