package com.yihua.wechat.model.resp.msg;

import com.yihua.wechat.model.Article;

import java.util.List;

/**
 * Created by brokenq on 2015/7/14.
 */
public class NewsRespMsg extends BaseRespMsg {
//    图文消息个数，限制为10条以内
    private int articleCount;
//    多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    private List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
