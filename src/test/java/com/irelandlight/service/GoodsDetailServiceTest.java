package com.irelandlight.service;

import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.vo.CommentsVO;
import com.irelandlight.model.vo.GoodsAll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Zichu on 2016/12/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml" })
public class GoodsDetailServiceTest {
    @Resource
    private GoodsDetailService goodsDetailService;
    @Test
    public void testQueryGoodsImage(){
        List<GoodsImage> goodsImages =goodsDetailService.queryGoodsImage(1);
        for(GoodsImage goodsImage:goodsImages){
            System.out.println(goodsImage);
        }
    }
    @Test
    public void testQueryGoodsInfo(){
        GoodsAll goodsAll=goodsDetailService.queryGoodsDetail(1);
        System.out.println(goodsAll);
    }
    @Test
    public void testQueryComments(){
        List<CommentsVO> commentsVOs=goodsDetailService.queryComments(1);
        for(CommentsVO commentsVO:commentsVOs){
            System.out.println(commentsVO);
        }
    }
}
