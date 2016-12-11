package com.irelandlight.model;

import java.util.Date;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/3
 * Time: 16:52
 * Description: 管理员操作日志表 .
 */
public class ProductorLog {
    private Long id;
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最近一次更新时间
    private Integer visibility;     //是否逻辑删除
    private Long productorId;       //管理员表的外键
    private String content;         //操作内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Long getProductorId() {
        return productorId;
    }

    public void setProductorId(Long productorId) {
        this.productorId = productorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
