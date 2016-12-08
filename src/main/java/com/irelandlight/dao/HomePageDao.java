package com.irelandlight.dao;

import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;

import java.util.List;

/**
 * 首页
 * Created by Zichu on 2016/12/6.
 */
public interface HomePageDao {
    /**
     * 查询首页轮播图
     * @return 返回轮播图信息
     */
    List<HomePageImage> queryHomePageImage();

    /**
     * 查询公告
     * @return 返回表中的未被删除的所有公告
     */
    List<NewsVO> queryNews();

    /**
     * 查询热门商品信息
     * @return 返回商品信息包装类：GoodsImage和Goods
     */
    List<GoodsVO> queryHotGoods();
}
