package com.yihua.wechat.model.req.msg;

/**
 * ͼƬ��Ϣ
 * Created by brokenq on 2015/7/14.
 */
public class ImageReqMsg extends BaseReqMsg {
//    图片链接
    private String picUrl;
//    图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
