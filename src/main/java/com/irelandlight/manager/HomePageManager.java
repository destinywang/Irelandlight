package com.irelandlight.manager;

import com.irelandlight.dao.HomePageDao;
import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/19.
 */
@Component
public class HomePageManager {
    @Resource
    private HomePageDao homePageDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageManager.class);

    /**
     * 处理首页轮播图从数据库查找回来数据的问题
     * 1.取出的数据为空
     * 2.取出的数据数量不足
     * 3.取出的数据正确
     *
     * @return
     */
    public List<HomePageImage> queryHomePageImage() {
     List<HomePageImage> homePageImages=homePageDao.queryHomePageImage();
        if(homePageImages!=null && homePageImages.size()!=3){
            int i=homePageImages.size();
            for(;i<3;i++){
                homePageImages.add(homePageImages.get(0));
            }
        }
        return homePageImages;
    }

    /**
     * 处理查找公告数据出现的问题
     * 1.查找回来的数据为NULL
     * 2.查找回来的数据完整
     *
     * @return
     */
    public List<NewsVO> queryNews() {
        List<NewsVO> newsVOList = homePageDao.queryNews();
        return newsVOList;
    }

    /**
     * 处理查找热门商品数据的问题
     * 1.查找到的数量为空
     * 2.查找到的数量不足6个
     * 3.查找到的数据完整
     *
     * @return
     */
    public List<GoodsVO> queryHotGoods() {
        List<GoodsVO> goodsVOs=homePageDao.queryHotGoods();
        return goodsVOs;
    }

}
