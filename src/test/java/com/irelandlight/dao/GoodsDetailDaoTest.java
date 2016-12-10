package com.irelandlight.dao;

import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.vo.CommentFrom;
import com.irelandlight.model.vo.CommentGoods;
import com.irelandlight.model.vo.GoodsInfo;
import com.irelandlight.model.vo.SizePrice;
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
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class GoodsDetailDaoTest {

    @Resource
    private GoodsDetailDao goodsDetailDao;

    @Test
    public void testQueryGoodsImage() {
        System.out.println(12);
        List<GoodsImage> goodsImages=goodsDetailDao.queryGoodsImage(2);

        for(GoodsImage goodsImage:goodsImages){
            System.out.println(goodsImage);
        }
    }
    @Test
    public void testQueryGoodsDetail(){
        GoodsInfo goodsInfos=goodsDetailDao.queryGoodsDetail(4);
        System.out.println(goodsInfos);
    }
    @Test
    public void testQuerySize(){
        List<SizePrice> sizePrices=goodsDetailDao.querySizePrice(2);
        for(SizePrice sizePrice:sizePrices){
            System.out.println(sizePrice);
        }
    }
    @Test
    public void testQueryCommentGoods(){
        List<CommentGoods> commentGoodses=goodsDetailDao.queryCommentGoods(1);
        for(CommentGoods commentGoods:commentGoodses){
            System.out.println(commentGoods);
        }
    }
    @Test
    public void testQueryCommentComment(){
        List<CommentFrom> commentFroms=goodsDetailDao.queryCommentComment(1);
        for(CommentFrom commentFrom:commentFroms){
            System.out.println(commentFrom);
        }
    }

}
