package com.irelandlight.service.impl;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.model.vo.SomeGoods;
import com.irelandlight.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Joyoung on 2016/12/10.
 */
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    public List<SomeGoods> selectGoods() throws Exception {
        List<SomeGoods> list=goodsMapper.selectGoods();
        return list;
    }

    public void updateGoodsWeight(Long id) throws Exception {
        goodsMapper.updateGoodsWeight(id);
    }
}
