package com.irelandlight.service;

import com.irelandlight.dao.GoodsListDao;
import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
@Service
public class GoodsListService {

    @Resource
    private GoodsListDao goodsListDao;

    public List<GoodsVO> queryAllGoods() {
        return goodsListDao.queryAllGoods();
    }

    public List<GoodsVO> queryBySearchGoods(String searchBox) {
        return goodsListDao.queryBySearchGoods(searchBox);
    }

    public List<GoodsVO> queryFilterGoods(FilterGoodsVO filter) {
        return goodsListDao.queryFilterGoods(filter);
    }
}
