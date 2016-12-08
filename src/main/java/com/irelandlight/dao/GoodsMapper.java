package com.irelandlight.dao;

import com.irelandlight.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mac on 2016/12/3.
 */
public interface GoodsMapper {
    //查询商品总数
    Integer selectGoodsCount();
    //查询回收站商品
    Integer selectRecycleGoodsCount();
    //查询上架商品数
    Integer selectPutawayGoodsCount();
    //查询下架商品数
    Integer selectSoldOutGoodsCount();
    //按照商品名称查找商品
    List<Goods> selectGoodsByName(@Param("name") String name);
    //查询未上架商品
    List<Goods> selectUnPutawayGoods();
    //查询已上架商品
    List<Goods> selectPutawayGoods();



    //test
    List<Goods> selectGoods();



    //修改商品中的字段值
    void updateGoods(@Param("goods") Goods goods);
    //将商品添加到tb_goods表中 @Param("goods")
    void insertIntoGoods(@Param("goods") Goods goods);
    void insertIntoGoodsByParam(Goods goods);
    //将商品从tb_goods表中删除
    void deleteFromGoods(@Param("goods") Goods goods);
}
