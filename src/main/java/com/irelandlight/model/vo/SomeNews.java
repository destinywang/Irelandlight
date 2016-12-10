package com.irelandlight.model.vo;

/**
 * Created by Joyoung on 2016/12/10.
 */
public class SomeNews {
    private Long id;
    private String title;           //标题
    private String content;         //内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
