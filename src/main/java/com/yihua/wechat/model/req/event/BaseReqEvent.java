package com.yihua.wechat.model.req.event;

import com.yihua.wechat.model.req.BaseReq;

/**
 * 事件请求基类
 * Created by brokenq on 2015/7/14.
 */
public class BaseReqEvent extends BaseReq {

//    事件类型
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
