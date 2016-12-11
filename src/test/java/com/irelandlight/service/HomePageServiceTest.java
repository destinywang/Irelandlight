package com.irelandlight.service;


import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class HomePageServiceTest {
    @Resource
    private HomePageService homePageService;
    @Test
    public void testQueryHotGoods(){
        List<GoodsVO> goodsVOs=homePageService.queryHotGoods();
        for(GoodsVO goodsVO:goodsVOs){
            System.out.println(goodsVO);
        }
    }
    @Test
    public void testQueryNews(){
        List<NewsVO> newsVOs=homePageService.queryNews();
        for(NewsVO newsVO:newsVOs){
            System.out.println(newsVO);
        }
    }
    @Test
    public void testQueryHomePageImage(){
        List<HomePageImage> homePageImages=homePageService.queryHomePageImage();
        for(HomePageImage homePageImage:homePageImages){
            System.out.println(homePageImage);
        }
    }
}
