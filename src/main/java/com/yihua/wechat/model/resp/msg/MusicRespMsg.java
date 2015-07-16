package com.yihua.wechat.model.resp.msg;

import com.yihua.wechat.model.Music;

/**
 * Created by brokenq on 2015/7/14.
 */
public class MusicRespMsg extends BaseRespMsg {

    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
