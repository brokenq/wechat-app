package com.yihua.wechat.model.req.msg;

/**
 * 文本消息
 * Created by brokenq on 2015/7/14.
 */
public class TextReqMsg extends BaseReqMsg {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
