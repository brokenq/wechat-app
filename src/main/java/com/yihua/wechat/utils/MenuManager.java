package com.yihua.wechat.utils;

import com.yihua.wechat.model.*;
import com.yihua.wechat.model.menu.*;

/**
 * 菜单管理器
 * Created by brokenq on 2015/7/15.
 */
public class MenuManager {

//    accessToken 通过ehcache来进行管理，由于ehcache一直下载不了，暂时先测试
    private static String ACCESS_TOKEN = "";

    public static String getAccessToken() {
        return ACCESS_TOKEN;
    }

    /**
     * 创建菜单
     */
    public static void main(String[] args) {
        createMenu();
    }

    /**
     * 创建菜单
     */
    public static void createMenu(){
        WxAccessToken accessToken = WeChatUtil.getAccessToken(CodeUtil.WX_APP_ID, CodeUtil.WX_APP_SECRET);
        if (null == accessToken){
            return;
        }
        int errorCode = WeChatUtil.createMenu(getMenu(), accessToken.getToken());
        if (0 == errorCode){
            ACCESS_TOKEN = accessToken.getToken();
            System.out.println("菜单创建成功！");
            return;
        }
        System.out.println("菜单创建失败，错误码：" + errorCode);
    }

    /**
     * 组装菜单
     */
    private static Menu getMenu() {
//        二级菜单
//        工地进展
        ClickButton progressQueryBtn           = getClickButton(MenuEnum.PROGRESS_QUERY);
        ClickButton progressCheckBtn           = getClickButton(MenuEnum.PROGRESS_CHECK);
//        跟进事项
        ClickButton followUpPurchaseBtn        = getClickButton(MenuEnum.FOLLOW_PURCHASE);
        ClickButton followUpRectificationBtn   = getClickButton(MenuEnum.FOLLOW_RECTIFICATION);
//        我的
        ClickButton mineContractBtn            = getClickButton(MenuEnum.MINE_CONTRACT);
        ClickButton mineConstructionTeamBtn    = getClickButton(MenuEnum.MINE_CONSTRUCTION_TEAM);
        ClickButton mineDecorationTeamBtn      = getClickButton(MenuEnum.MINE_DECORATION_TEAM);
        ClickButton mineCallCenterBtn          = getClickButton(MenuEnum.MINE_CALL_CENTER);
        ClickButton minePhoneBtn               = getClickButton(MenuEnum.MINE_PHONE);

//        一级菜单
        ComplexButton progressBtn = new ComplexButton();
        progressBtn.setName(MenuEnum.PROGRESS.getName());
        progressBtn.setSub_button(new ClickButton[]{progressQueryBtn, progressCheckBtn});

        ComplexButton followUpBtn = new ComplexButton();
        followUpBtn.setName(MenuEnum.FOLLOW.getName());
        followUpBtn.setSub_button(new ClickButton[]{followUpPurchaseBtn, followUpRectificationBtn});

        ComplexButton mineBtn = new ComplexButton();
        mineBtn.setName(MenuEnum.MINE.getName());
        mineBtn.setSub_button(new ClickButton[]{mineContractBtn, mineConstructionTeamBtn, mineDecorationTeamBtn, mineCallCenterBtn, minePhoneBtn});

        Menu menu = new Menu();
        menu.setButton(new BaseButton[]{progressBtn, followUpBtn, mineBtn});
        return menu;
    }

    /**
     * 实例化ClickButton
     * @param menuEnum 菜单枚举
     * @return ClickButton对象
     */
    private static ClickButton getClickButton(MenuEnum menuEnum){
        ClickButton btn = new ClickButton();
        btn.setName(menuEnum.getName());
        btn.setKey(menuEnum.getKey());
        btn.setType(CodeUtil.REQ_EVENT_CLICK);
        return btn;
    }

    /**
     * 实例化ViewButton
     * @param menuEnum 菜单枚举
     * @return ViewButton对象
     */
    private static ViewButton getViewButton(MenuEnum menuEnum){
        ViewButton btn = new ViewButton();
        btn.setName(menuEnum.getName());
        btn.setUrl(menuEnum.getKey());
        btn.setType(CodeUtil.REQ_EVENT_VIEW);
        return btn;
    }
}
