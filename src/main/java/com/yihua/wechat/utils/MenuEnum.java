package com.yihua.wechat.utils;

/**
 * 菜单枚举类
 * Created by brokenq on 2015/7/16.
 */
public enum MenuEnum {
//    二级菜单
    PROGRESS_QUERY("进度查询", "progress_query"),
    PROGRESS_CHECK("验收进程", "progress_check"),

    FOLLOW_PURCHASE("采购跟进", "follow_purchase"),
    FOLLOW_RECTIFICATION("整改清单", "follow_rectification"),

    MINE_CONTRACT("我的合同", "mine_contract"),
    MINE_CONSTRUCTION_TEAM("我的施工队", "mine_construction_team"),
    MINE_DECORATION_TEAM("我的装修队", "mine_decoration_team"),
    MINE_CALL_CENTER("客服中心", "mine_call_center"),
    MINE_PHONE("手机号绑定", "mine_phone"),

//    一级菜单
    PROGRESS("工地进展", "progress"),
    FOLLOW("跟进事项", "follow"),
    MINE("我的", "mine");

    private String name;
    private String key;

    MenuEnum(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
