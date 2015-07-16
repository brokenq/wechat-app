package com.yihua.wechat.controller;

import com.yihua.wechat.service.CoreService;
import com.yihua.wechat.utils.MsgUtil;
import com.yihua.wechat.utils.SignUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by brokenq on 2015/7/13.
 */
@Controller
@RequestMapping("/core")
public class CoreController {

    @Autowired
    private CoreService coreService;

    /**
     * 接入微信服务器
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String access(String signature, String timestamp, String nonce, String echostr) {
        return SignUtil.checkSignature(signature, timestamp, nonce) ? "success" : "fault";
    }

    /**
     * 处理微信服务器POST请求
     * @param request
     */
    public String core(HttpServletRequest request){
        try {
            Map<String, String> requestMap = MsgUtil.parseXml(request);
            coreService.processRequest(requestMap);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
