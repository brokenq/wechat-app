package com.yihua.wechat.utils;

import com.yihua.wechat.model.*;
import com.yihua.wechat.model.Menu;

/**
 * 菜单管理器
 * Created by brokenq on 2015/7/15.
 */
public class MenuManager {

    public static void main(String[] args) {
        AccessToken accessToken = WeChatUtil.getAccessToken(CodeUtil.WX_APP_ID, CodeUtil.WX_APP_SECRET);
        if (null == accessToken){
            return;
        }
        int errorCode = WeChatUtil.createMenu(getMenu(), accessToken.getToken());
        if (0 == errorCode){
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
        CommonButton progressQueryBtn           = getCommonButton(MenuEnum.PROGRESS_QUERY, CodeUtil.REQ_EVENT_CLICK);
        CommonButton progressCheckBtn           = getCommonButton(MenuEnum.PROGRESS_CHECK, CodeUtil.REQ_EVENT_CLICK);
//        跟进事项
        CommonButton followUpPurchaseBtn        = getCommonButton(MenuEnum.FOLLOW_PURCHASE, CodeUtil.REQ_EVENT_CLICK);
        CommonButton followUpRectificationBtn   = getCommonButton(MenuEnum.FOLLOW_RECTIFICATION, CodeUtil.REQ_EVENT_CLICK);
//        我的
        CommonButton mineContractBtn            = getCommonButton(MenuEnum.MINE_CONTRACT, CodeUtil.REQ_EVENT_CLICK);
        CommonButton mineConstructionTeamBtn    = getCommonButton(MenuEnum.MINE_CONSTRUCTION_TEAM, CodeUtil.REQ_EVENT_CLICK);
        CommonButton mineDecorationTeamBtn      = getCommonButton(MenuEnum.MINE_DECORATION_TEAM, CodeUtil.REQ_EVENT_CLICK);
        CommonButton mineCallCenterBtn          = getCommonButton(MenuEnum.MINE_CALL_CENTER, CodeUtil.REQ_EVENT_CLICK);
        CommonButton minePhoneBtn               = getCommonButton(MenuEnum.MINE_PHONE, CodeUtil.REQ_EVENT_CLICK);

//        一级菜单
        ComplexButton progressBtn = new ComplexButton();
        progressBtn.setName(MenuEnum.PROGRESS.getName());
        progressBtn.setSub_button(new CommonButton[]{progressQueryBtn, progressCheckBtn});

        ComplexButton followUpBtn = new ComplexButton();
        followUpBtn.setName(MenuEnum.FOLLOW.getName());
        followUpBtn.setSub_button(new CommonButton[]{followUpPurchaseBtn, followUpRectificationBtn});

        ComplexButton mineBtn = new ComplexButton();
        mineBtn.setName(MenuEnum.MINE.getName());
        mineBtn.setSub_button(new CommonButton[]{mineContractBtn, mineConstructionTeamBtn, mineDecorationTeamBtn, mineCallCenterBtn, minePhoneBtn});

        Menu menu = new Menu();
        menu.setButton(new BaseButton[]{progressBtn, followUpBtn, mineBtn});
        return menu;
    }

    /**
     * 实例化CommonButton
     * @param menuEnum 菜单枚举
     * @param eventType 事件类型
     * @return CommonButton对象
     */
    private static CommonButton getCommonButton(MenuEnum menuEnum, String eventType){
        CommonButton btn = new CommonButton();
        btn.setName(menuEnum.getName());
        btn.setKey(menuEnum.getKey());
        btn.setType(eventType);
        return btn;
    }
}
