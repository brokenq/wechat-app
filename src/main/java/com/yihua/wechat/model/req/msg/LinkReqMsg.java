package com.yihua.wechat.model.req.msg;

/**
 * Created by brokenq on 2015/7/14.
 */
public class LinkReqMsg extends BaseReqMsg {
//    消息标题
    private String title;
//    消息描述
    private String description;
//    消息链接
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
