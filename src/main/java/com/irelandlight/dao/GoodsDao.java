package com.irelandlight.dao;

import com.irelandlight.model.ShopCarGoodsRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/20
 * Time: 23:43
 * Description: 目的... .
 */
@Repository
public interface GoodsDao {

    //修改商品库存和销量
    public Integer updateBatchSaleQuantity(@Param("goodsList") List<ShopCarGoodsRelation> goodsList) throws Exception;
}
