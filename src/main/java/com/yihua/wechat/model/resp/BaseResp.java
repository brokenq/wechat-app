package com.yihua.wechat.model.resp;

/**
 * 推送消息基类（公众平台->微信服务器）
 * Created by brokenq on 2015/7/14.
 */
public class BaseResp {
    //    接收方帐号（收到的OpenID）
    private String toUserName;
    //    开发者微信号
    private String fromUserName;
    //    消息创建时间 （整型）
    private long createTime;
    //    消息类型
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
