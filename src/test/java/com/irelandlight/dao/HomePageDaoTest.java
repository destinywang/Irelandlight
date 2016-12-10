package com.irelandlight.dao;

import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class HomePageDaoTest {
    @Resource
    private HomePageDao homePageDao;
    @Test
    public void testQueryHomePageImage() {
        List<HomePageImage> homePageImages=homePageDao.queryHomePageImage();
        for(HomePageImage homePageImage:homePageImages){
            System.out.println(homePageImage);
        }
    }
    @Test
    public void testQueryNews(){
        List<NewsVO> newsVOs=homePageDao.queryNews();
        System.out.println(newsVOs);
      for(NewsVO newsVO:newsVOs){
          System.out.println(newsVO.toString());
      }
    }
    @Test
    public void testQueryHotGoods(){
        List<GoodsVO> goodsVOs=homePageDao.queryHotGoods();
        for(GoodsVO goodsVO:goodsVOs){
            System.out.println(goodsVO.toString());
        }
    }
}
