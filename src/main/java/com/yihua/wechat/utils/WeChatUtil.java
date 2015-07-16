package com.yihua.wechat.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.yihua.wechat.model.AccessToken;
import com.yihua.wechat.model.Menu;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Map;

/**
 * 公众平台通用接口工具类
 * Created by brokenq on 2015/7/14.
 */
public class WeChatUtil {

    // 获取access_token的接口地址（GET） 限200（次/天）
    private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    // 菜单创建（POST） 限100（次/天）
    private final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
    private final static String ACCESS_TOKEN_FIELD = "access_token";
    private final static String EXPIRES_IN_FIELD = "expires_in";
    private final static String ERROR_CODE_FIELD = "errcode";

    /**
     * 获取access token
     * @param appId
     * @param appSecret
     * @return
     */
    public static AccessToken getAccessToken(String appId, String appSecret) {
        AccessToken accessToken = null;
        String reqUrl = String.format(ACCESS_TOKEN_URL, appId, appSecret);
        Map<String, String> map = httpRequest(reqUrl, CodeUtil.REQUEST_METHOD_GET, null);
        if (null == map) {
            return accessToken;
        }
        accessToken = new AccessToken();
        accessToken.setToken(map.get(ACCESS_TOKEN_FIELD));
        accessToken.setExpiresIn(Integer.parseInt(map.get(EXPIRES_IN_FIELD)));
        return accessToken;
    }

    public static int createMenu(Menu menu, String accessToken){
        int result = 0;
        String url = String.format(MENU_CREATE_URL, accessToken);
        Gson gson = new Gson();
        String menuJson = gson.toJson(menu);
        Map<String, String> map = httpRequest(url, CodeUtil.REQUEST_METHOD_POST, menuJson);
        if (null == map) {
            return result;
        }
        if (0 != Integer.parseInt(map.get(ERROR_CODE_FIELD))) {
            System.out.println("创建菜单失败");
        }
        return result;

    }

    /**
     * 发起https请求（POST、GET）
     * @param reqUrl 请求地址
     * @param reqMethod 请求方式（POST、GET）
     * @param reqParam 提交的数据
     * @return
     */
    public static Map<String, String> httpRequest(String reqUrl, String reqMethod, String reqParam) {
        TrustManager[] managers = {new YhX509TrustManager()};
        StringBuffer stringBuffer = new StringBuffer();
        try {
//            创建SSLContext对象，并使用我们指定的信任管理器初始化
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, managers, new SecureRandom());
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            URL url = new URL(reqUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setSSLSocketFactory(socketFactory);

            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod(reqMethod);

            if (CodeUtil.REQUEST_METHOD_GET.equalsIgnoreCase(reqMethod)) urlConnection.connect();

//            有参数情形
            if (null != reqParam) {
                OutputStream outputStream = urlConnection.getOutputStream();
                outputStream.write(reqParam.getBytes(CodeUtil.ENCODING));
                outputStream.close();
            }

//            将返回的输入流转换成字符串
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CodeUtil.ENCODING);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            urlConnection.disconnect();
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
            Map<String, String> resultMap = gson.fromJson(stringBuffer.toString(), new TypeToken<Map<String, String>>() {}.getType());
            return resultMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
