package com.irelandlight.service;

import com.irelandlight.manager.HomePageManager;
import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
@Service
public class HomePageService {
    @Resource
   private HomePageManager homePageManager;

    /**
     * 返回热门商品列表，共6个，排好序
     * @return
     */
    public List<GoodsVO> queryHotGoods() {
        return homePageManager.queryHotGoods();
    }

    /**
     * 返回公告信息，包含内容，标题及发布的管理员名字
     * @return
     */
    public List<NewsVO>  queryNews() {
        return homePageManager.queryNews();
    }

    /**
     * 返回首页轮播图，按位置顺序排好
     * @return
     */
    public List<HomePageImage> queryHomePageImage() {
        return homePageManager.queryHomePageImage();
    }
}
