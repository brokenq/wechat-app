package com.yihua.wechat.service;

import com.yihua.wechat.model.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 核心服务接口，处理微信服务器POST过来的请求
 * Created by brokenq on 2015/7/14.
 */
@Service
public class CoreService {

    @Autowired
    private PushMsgService pushMsgService;

    public String processRequest(Map<String, String> requestMap){
        String fromUserName = requestMap.get("FromUserName");
        String toUserName = requestMap.get("ToUserName");
        String msgType = requestMap.get("MsgType");
        String event = requestMap.get("Event");
        String eventKey = requestMap.get("EventKey");
//
        BaseResp baseResp = new BaseResp();
        baseResp.setFromUserName(toUserName);
        baseResp.setToUserName(fromUserName);
        baseResp.setCreateTime(new Date().getTime());

        return pushMsgService.pushMsg(msgType, baseResp, event, eventKey);
    }
}
