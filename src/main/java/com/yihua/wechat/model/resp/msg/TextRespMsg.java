package com.yihua.wechat.model.resp.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * �ı���Ϣ
 * Created by brokenq on 2015/7/14.
 */
public class TextRespMsg extends BaseRespMsg {
//    回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
