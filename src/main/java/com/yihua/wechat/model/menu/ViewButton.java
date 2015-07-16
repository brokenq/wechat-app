package com.yihua.wechat.model.menu;

/**
 * Created by brokenq on 2015/7/16.
 */
public class ViewButton extends BaseButton {

    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
