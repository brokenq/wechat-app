package com.yihua.wechat.model.req.msg;

/**
 * Created by brokenq on 2015/7/14.
 */
public class VoiceReqMsg extends BaseReqMsg {
//    语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String mediaId;
//    语音格式，如amr，speex等
    private String format;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
