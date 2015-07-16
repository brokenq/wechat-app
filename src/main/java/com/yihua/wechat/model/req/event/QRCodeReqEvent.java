package com.yihua.wechat.model.req.event;

/**
 * 扫描带参数二维码事件
 * Created by brokenq on 2015/7/14.
 */
public class QRCodeReqEvent extends BaseReqEvent {

//    事件KEY值
    private String eventKey;
//    二维码的ticket，可用来换取二维码图片
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
