package com.irelandlight.manager;

import com.irelandlight.dao.HomePageDao;
import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/19.
 */
@Component
public class HomePageManager {
    @Resource
    private HomePageDao homePageDao;
    private static final Logger LOGGER= LoggerFactory.getLogger(HomePageManager.class);

    /**
     * 处理首页轮播图从数据库查找回来数据的问题
     *    1.取出的数据为空
     *    2.取出的数据数量不足
     *    3.取出的数据正确
     * @return
     */
    public Map<String, Object> queryHomePageImage(){
        List<HomePageImage> homePageImages;
        homePageImages=homePageDao.queryHomePageImage();
        Map<String,Object> homePage=new HashMap<String,Object>();
        if(homePageImages==null){
            homePage.put("code", 1);
            homePage.put("msg", "无法查找到图片");
        }
        else if(homePageImages.size()!=3){
            homePage.put("code",2);
            homePage.put("msg","首页轮播图数量为"+homePageImages.size());
        }
        else{
            homePage.put("code",0);
            homePage.put("homePageImages",homePageImages);
        }
        return homePage;
    }

    /**
     * 处理查找公告数据出现的问题
     *    1.查找回来的数据为NULL
     *    2.查找回来的数据完整
     * @return
     */
    public Map<String,Object> queryNews(){
        Map<String,Object> newsMap=new HashMap<String,Object>();
        List<NewsVO> newsVOList=homePageDao.queryNews();
        if(newsVOList==null){
            newsMap.put("code",1);
            newsMap.put("mag","无法查找到公告");
        }
        else{
            newsMap.put("code",0);
            newsMap.put("news",newsVOList);
        }
        return newsMap;
    }

    /**
     * 处理查找热门商品数据的问题
     *   1.查找到的数量为空
     *   2.查找到的数量不足6个
     *   3.查找到的数据完整
     * @return
     */
    public Map<String,Object> queryHotGoods(){
        Map<String,Object> hotGoodsMap=new HashMap<String,Object>();
        List<GoodsVO> goodsVOList=homePageDao.queryHotGoods();
        if(goodsVOList==null){
            hotGoodsMap.put("code",1);
            hotGoodsMap.put("msg","查找到的热门商品为空");
        }
        else if(goodsVOList.size()!=6){
            hotGoodsMap.put("code",2);
            hotGoodsMap.put("msg","查找到商品数量为"+goodsVOList.size());
        }
        else {
            hotGoodsMap.put("code",0);
            hotGoodsMap.put("HotGoods",goodsVOList);
        }
        return hotGoodsMap;
    }

}
