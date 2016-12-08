package com.irelandlight.service;

import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;

import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
public interface GoodsListService {
    List<GoodsVO> queryAllGoods();
    List<GoodsVO> queryBySearchGoods(String searchBox);
    List<GoodsVO> queryFilterGoods(FilterGoodsVO filter);
}
