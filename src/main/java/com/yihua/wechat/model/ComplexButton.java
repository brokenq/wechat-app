package com.yihua.wechat.model;

/**
 * Created by brokenq on 2015/7/14.
 */
public class ComplexButton extends BaseButton {

    private BaseButton[] sub_button;

    public BaseButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(BaseButton[] sub_button) {
        this.sub_button = sub_button;
    }
}
