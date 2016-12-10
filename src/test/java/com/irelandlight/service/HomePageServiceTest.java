package com.irelandlight.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by Zichu on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml"})
public class HomePageServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(HomePageServiceTest.class);

    @Resource
    private GoodsDetailService goodsDetailService;

    @Test
    public void testQueryHotGoods() {
//        System.out.println(goodsDetailService);
        //logger.info(homePageService.queryHotGoods().toString());
        /*
        List<HomePageImage> homePageImages=homePageService.queryHomePageImage();
        for(HomePageImage homePageImage:homePageImages){
            System.out.println(homePageImage);
        }*/
    }
}
