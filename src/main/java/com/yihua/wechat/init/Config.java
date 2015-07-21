package com.yihua.wechat.init;

import com.yihua.wechat.utils.CodeUtil;
import com.yihua.wechat.utils.MenuManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by brokenq on 2015/7/16.
 */
public class Config implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (null == event.getApplicationContext().getParent()) {
            CodeUtil.init();
            MenuManager.createMenu();
        }
    }
}
