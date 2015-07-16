package com.yihua.wechat.utils;

import com.yihua.wechat.model.WxValidateUrlReq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * Created by brokenq on 2015/7/13.
 */
public class SignUtil {

    /**
     * 签名校验
     * 加密/校验流程如下：
     * <ul>
     *     <li>将token、timestamp、nonce三个参数进行字典序排序</li>
     *     <li>将三个参数字符串拼接成一个字符串进行sha1加密</li>
     *     <li>开发者获得加密后的字符串可与signature对比，标识该请求来源于微信</li>
     * </ul>
     * @param validateReq 微信服务器验证地址有效性请求对象
     * @return true：校验成功 | false：校验失败
     */
    public static boolean checkSignature(WxValidateUrlReq validateReq){
        String[] files = {CodeUtil.WX_TOKEN, validateReq.getTimestamp(), validateReq.getNonce()};
        Arrays.sort(files);
        StringBuilder content = new StringBuilder();
        for (String file : files) {
            content.append(file);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmpStr != null ? tmpStr.equals(validateReq.getSignature().toUpperCase()) : false;
    }

    /**
     * @param bytes
     * @return
     */
    private static String byteToStr(byte[] bytes) {
        String digest = "";
        for (byte b : bytes) {
            digest += byteToHexStr(b);
        }
        return digest;
    }

    /**
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] chars = new char[2];
        chars[0] = digit[(mByte >>> 4) & 0X0F];
        chars[1] = digit[mByte & 0X0F];

        return new String(chars);
    }
}
