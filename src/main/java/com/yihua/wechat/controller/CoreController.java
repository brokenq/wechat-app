package com.yihua.wechat.controller;

import com.yihua.wechat.model.WxValidateUrlReq;
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
     * 接入微信服务器，验证服务器地址的有效性
     * @param validateReq 微信服务器验证公众平台地址的有效性请求
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String access(String signature, String timestamp, String nonce, String echostr) {
        WxValidateUrlReq validateReq = new WxValidateUrlReq();
        validateReq.setEchostr(echostr);
        validateReq.setNonce(nonce);
        validateReq.setSignature(signature);
        validateReq.setTimestamp(timestamp);
        return SignUtil.checkSignature(validateReq) ? echostr : null;
    }

    /**
     * 处理微信服务器POST请求
     * @param request
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String core(HttpServletRequest request){
        try {
            Map<String, String> requestMap = MsgUtil.parseXml(request);
            String msg = coreService.processRequest(requestMap);
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
