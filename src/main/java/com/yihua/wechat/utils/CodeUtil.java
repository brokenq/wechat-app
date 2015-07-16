package com.yihua.wechat.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by brokenq on 2015/7/15.
 */
public class CodeUtil {

//    properties配置
    public final static String WX_TOKEN_KEY = "wx_token";
    public final static String WX_APP_ID_KEY = "wx_app_id";
    public final static String WX_APP_SECRET_KEY = "wx_app_secret";
    public static String WX_TOKEN = "";
    public static String WX_APP_ID = "";
    public static String WX_APP_SECRET = "";

//    推送消息类型
    public static final String RESP_MSG_TEXT    = "text";
    public static final String RESP_MSG_IMAGE   = "image";
    public static final String RESP_MSG_VOICE   = "voice";
    public static final String RESP_MSG_VIDEO   = "video";
    public static final String RESP_MSG_MUSIC   = "music";
    public static final String RESP_MSG_NEWS    = "news";

//    接收消息类型
    public final static String REQ_MSG_TEXT         = "text";
    public final static String REQ_MSG_IMAGE        = "image";
    public final static String REQ_MSG_VOICE        = "voice";
    public final static String REQ_MSG_VIDEO        = "video";
    public final static String REQ_MSG_SHORT_VIDEO  = "shortvideo";
    public final static String REQ_MSG_LOCATION     = "location";
    public final static String REQ_MSG_LINK         = "link";
    public final static String REQ_MSG_EVENT        = "event";

//    接收事件类型
    public final static String REQ_EVENT_SUBSCRIBE      = "subscribe";
    public final static String REQ_EVENT_UNSUBSCRIBE    = "unsubscribe";
    public final static String REQ_EVENT_SCAN           = "scan";
    public final static String REQ_EVENT_LOCATION       = "location";
    public final static String REQ_EVENT_CLICK          = "click";
    public final static String REQ_EVENT_VIEW           = "view";

    public final static String REQUEST_METHOD_GET  = "GET";
    public final static String REQUEST_METHOD_POST = "POST";
    public final static String ENCODING = "UTF-8";

    /**
     * 初始化
     */
    public static void init(){
        Properties properties = readProperties();
        WX_TOKEN = properties.getProperty(WX_TOKEN_KEY);
        WX_APP_ID = properties.getProperty(WX_APP_ID_KEY);
        WX_APP_SECRET = properties.getProperty(WX_APP_SECRET_KEY);
    }

    /**
     * 读取配置
     */
    public static Properties readProperties(){
        ClassPathResource resource = new ClassPathResource("/conf.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
