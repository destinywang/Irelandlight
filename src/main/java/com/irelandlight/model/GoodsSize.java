package com.irelandlight.model;


import java.util.Date;

/**
 * Created by Zichu on 2016/12/11.
 */
public class GoodsSize {
    private Long id;
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最后更新时间
    private Integer visibility;     //表示是否已删除
    private Long goodsId;           //商品id
    private Integer isPutaway;      //表示是否上架
    private String size;            //表示商品的价格
    private Double price;           //表示商品的价格

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public String getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
