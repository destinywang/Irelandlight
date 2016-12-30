package com.irelandlight.service;

import com.irelandlight.manager.GoodsListManager;
import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/8.
 */
@Service
public class GoodsListService {

    @Resource
    private GoodsListManager goodsListManager;

    public List<GoodsVO> queryAllGoods() {
        return goodsListManager.queryAllGoods();
    }

    public Map<String,Object> queryBySearchGoods(String searchBox) {
        return goodsListManager.queryBySearchGoods(searchBox);
    }

    public Map<String,Object> queryFilterGoods(FilterGoodsVO filter) {
        return goodsListManager.queryFilterGoods(filter);
    }
}
