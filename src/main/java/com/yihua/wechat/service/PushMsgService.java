package com.yihua.wechat.service;

import com.yihua.wechat.model.resp.BaseResp;
import com.yihua.wechat.model.resp.msg.TextRespMsg;
import com.yihua.wechat.utils.CodeUtil;
import com.yihua.wechat.utils.MenuEnum;
import com.yihua.wechat.utils.MsgUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 推送消息服务接口
 * Created by brokenq on 2015/7/14.
 */
@Service
public class PushMsgService {

    /**
     * 根据消息类型推送对应的消息
     * @param msgType 消息类型
     * @return
     */
    public String pushMsg(String msgType, BaseResp baseResp, String event, String eventKey) {
//        接收的消息类型
        if (CodeUtil.REQ_MSG_TEXT.equals(msgType))           return pushTextMsg(baseResp);
        if (CodeUtil.REQ_MSG_IMAGE.equals(msgType))          return pushImageMsg(baseResp);
        if (CodeUtil.REQ_MSG_VOICE.equals(msgType))          return pushVoiceMsg(baseResp);
        if (CodeUtil.REQ_MSG_VIDEO.equals(msgType))          return pushVideoMsg(baseResp);
        if (CodeUtil.REQ_MSG_SHORT_VIDEO.equals(msgType))    return pushMusicMsg(baseResp);
        if (CodeUtil.REQ_MSG_LOCATION.equals(msgType))       return pushNewsMsg(baseResp);
        if (CodeUtil.REQ_MSG_LINK.equals(msgType))           return pushNewsMsg(baseResp);
//        接收的事件类型
        if (null != event && CodeUtil.REQ_MSG_EVENT.equals(msgType)) {
            if (CodeUtil.REQ_EVENT_SUBSCRIBE.equals(event))      return pushTextMsg(baseResp);
            if (CodeUtil.REQ_EVENT_UNSUBSCRIBE.equals(event))    return pushTextMsg(baseResp);
            if (CodeUtil.REQ_EVENT_SCAN.equals(event))           return pushTextMsg(baseResp);
            if (CodeUtil.REQ_EVENT_LOCATION.equals(event))       return pushTextMsg(baseResp);
            if (CodeUtil.REQ_EVENT_CLICK.equals(event)){
                if (MenuEnum.PROGRESS_QUERY.getKey().equals(eventKey)) return pushTextMsg(baseResp);
            }
            if (CodeUtil.REQ_EVENT_VIEW.equals(event))           return pushTextMsg(baseResp);
        }
//        默认处理
        TextRespMsg msg = new TextRespMsg();
        BeanUtils.copyProperties(msg, baseResp);
        msg.setMsgType(CodeUtil.RESP_MSG_TEXT);
        msg.setContent("请稍后访问！");
        return MsgUtil.textMsgToXml(msg);
    }

    /**
     * 推送文本消息
     * @param baseResp
     * @return
     */
    private String pushTextMsg(BaseResp baseResp) {
        TextRespMsg msg = new TextRespMsg();
        BeanUtils.copyProperties(msg, baseResp);
        msg.setMsgType(CodeUtil.RESP_MSG_TEXT);
        msg.setContent("test");
        return MsgUtil.textMsgToXml(msg);
    }

    /**
     * 推送图片消息
     * @param baseResp
     * @return
     */
    private String pushImageMsg(BaseResp baseResp) {
        return null;
    }

    /**
     * 推送语音消息
     * @param baseResp
     * @return
     */
    private String pushVoiceMsg(BaseResp baseResp) {
        return null;
    }

    /**
     * 推送视频消息
     * @param baseResp
     * @return
     */
    private String pushVideoMsg(BaseResp baseResp) {
        return null;
    }

    /**
     * 推送音乐消息
     * @param baseResp
     * @return
     */
    private String pushMusicMsg(BaseResp baseResp) {
        return null;
    }

    /**
     * 推送图文消息
     * @param baseResp
     * @return
     */
    private String pushNewsMsg(BaseResp baseResp) {
        return null;
    }

}
