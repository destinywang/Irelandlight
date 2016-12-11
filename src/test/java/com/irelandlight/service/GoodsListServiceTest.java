package com.irelandlight.service;

import com.irelandlight.model.Goods;
import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;
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
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class GoodsListServiceTest {
    @Resource
    private  GoodsListService goodsListService;
    @Test
    public void testQueryAllGoods(){
        List<GoodsVO> goodsVOs=goodsListService.queryAllGoods();
        for(GoodsVO goodsVO:goodsVOs){
            System.out.println(goodsVO);
        }
    }
    @Test
    public void testQueryBySearchGoods(){
        List<GoodsVO> goodsVOs=goodsListService.queryBySearchGoods("奶油");
        for(GoodsVO goodsVO:goodsVOs){
            System.out.println(goodsVO);
        }
    }
    @Test
    public void testQueryFilterGoods(){
        FilterGoodsVO filterGoodsVO=new FilterGoodsVO();
        filterGoodsVO.setPerference("奶油");
        filterGoodsVO.setTaste("奶油");
        List<GoodsVO> goodsVOs=goodsListService.queryFilterGoods(filterGoodsVO);
        for(GoodsVO goodsVO:goodsVOs){
            System.out.println(goodsVO);
        }
    }
}
