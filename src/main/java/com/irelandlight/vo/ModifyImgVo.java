package com.irelandlight.vo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by mac on 2016/12/22.
 */
public class ModifyImgVo {
    private Long goodsId;

    public Map<String, Integer> getImgMapPos() {
        return imgMapPos;
    }

    public void setImgMapPos(Map<String, Integer> imgMapPos) {
        this.imgMapPos = imgMapPos;
    }

    private Map<String,Integer> imgMapPos;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }


}
