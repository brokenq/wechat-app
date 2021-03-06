package com.yihua.wechat.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.yihua.wechat.model.Article;
import com.yihua.wechat.model.resp.BaseResp;
import com.yihua.wechat.model.resp.msg.MusicRespMsg;
import com.yihua.wechat.model.resp.msg.NewsRespMsg;
import com.yihua.wechat.model.resp.msg.TextRespMsg;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 消息处理工具类
 * Created by brokenq on 2015/7/14.
 */
public class MsgUtil {

    /**
     * 解析xml
     * @param request
     * @return
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        HashMap<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element e : elements) {
            map.put(e.getName(), e.getText());
        }
        inputStream.close();

        return map;
    }

    /**
     * 文本消息转xml
     * @param msg 文本消息
     */
    public static String textMsgToXml(TextRespMsg msg) {
        xstream.alias("xml", msg.getClass());
        return xstream.toXML(msg);
    }

    /**
     * 音乐消息转xml
     * @param msg 音乐消息
     */
    public static String musicMsgToXml(MusicRespMsg msg) {
        xstream.alias("xml", msg.getClass());
        return xstream.toXML(msg);
    }

    /**
     * 图文消息转xml
     * @param msg 图文消息
     */
    public static String newsMsgToXml(NewsRespMsg msg) {
        xstream.alias("xml", msg.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(msg);
    }

    /**
     * 重载XStream对象，使其支持CDATA块
     */
    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = false;

                @Override
                public void startNode(String name, Class clz) {
                    if (!name.equals("xml")) {
                        char[] chars = name.toCharArray();
                        if (chars[0] >= 'a' && chars[0] <= 'z') {
                            chars[0] = (char) ((int)chars[0] - 32);
                        }
                        name = new String(chars);
                    }
                    super.startNode(name, clz);
                }

                @Override
                public void setValue(String text) {
                    if (null != text && !StringUtils.isEmpty(text)) {
                        Pattern intPattern = Pattern.compile("[0-9]+");
                        Pattern floatPattern = Pattern.compile("[0-9]*(\\\\.?)[0-9]*");
                        cdata = intPattern.matcher(text).matches() || floatPattern.matcher(text).matches() ? false : true;
                    }
                    super.setValue(text);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    writer.write(cdata ? String.format("<![CDATA[%s]]>", text) : text);
                }
            };
        }
    });

}
