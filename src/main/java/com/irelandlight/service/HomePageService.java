package com.irelandlight.service;

import com.irelandlight.dao.HomePageDao;
import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
@Service
public class HomePageService {

    @Resource
    private HomePageDao homePageDao;

    /**
     * 返回热门商品列表，共6个，排好序
     * @return
     */
    public List<GoodsVO> queryHotGoods() {
        return homePageDao.queryHotGoods();
    }

    /**
     * 返回公告信息，包含内容，标题及发布的管理员名字
     * @return
     */
    public List<NewsVO> queryNews() {
        return homePageDao.queryNews();
    }

    /**
     * 返回首页轮播图，按位置顺序排好
     * @return
     */
    public List<HomePageImage> queryHomePageImage() {
        return homePageDao.queryHomePageImage();
    }
}
