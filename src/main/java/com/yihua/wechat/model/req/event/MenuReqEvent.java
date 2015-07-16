package com.yihua.wechat.model.req.event;

/**
 * Created by brokenq on 2015/7/14.
 */
public class MenuReqEvent extends BaseReqEvent {

//    事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
