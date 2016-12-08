package com.irelandlight.service;

import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;

import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
public interface HomePageService {
    /**
     * 返回首页轮播图信息，将其位置顺序排好
     * @return
     */
    List<HomePageImage> queryHomePageImage();

    /**
     * 返回公告的信息
     * @return
     */
    List<NewsVO> queryNews();

    /**
     * 查询6个热门商品信息
     * @return
     */
    List<GoodsVO> queryHotGoods();
}
