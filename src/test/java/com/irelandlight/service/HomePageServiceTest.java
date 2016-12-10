package com.irelandlight.service;

import com.irelandlight.service.HomePageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Zichu on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml"})
public class HomePageServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(HomePageServiceTest.class);

    @Autowired
    private HomePageService homePageService;

    @Test
    public void testQueryHotGoods() {
        //logger.info(homePageService.queryHotGoods().toString());
        /*
        List<HomePageImage> homePageImages=homePageService.queryHomePageImage();
        for(HomePageImage homePageImage:homePageImages){
            System.out.println(homePageImage);
        }*/
    }
}
