package com.yihua.wechat.model.resp.msg;

/**
 * 图片消息
 * Created by brokenq on 2015/7/14.
 */
public class ImageRespMsg extends BaseRespMsg {
//    通过素材管理接口上传多媒体文件，得到的id。
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
