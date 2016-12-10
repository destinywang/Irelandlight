package com.irelandlight.dao;

import com.irelandlight.model.vo.SomeGoods;

import java.util.List;

/**
 * Created by Joyoung on 2016/12/10.
 */
public interface GoodsMapper {
    //查询所有商品的id和name
    public List<SomeGoods> selectGoods()throws Exception;
    //修改商品的权重
    public void updateGoodsWeight(Long id)throws Exception;
}
