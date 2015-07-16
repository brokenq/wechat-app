package com.yihua.wechat.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * Created by brokenq on 2015/7/13.
 */
public class SignUtil {

    // 微信公众平台token
    public static String token = "wechat";

    /**
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        String[] files = {token, timestamp, nonce};
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
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
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
