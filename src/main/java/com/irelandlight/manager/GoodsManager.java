package com.irelandlight.manager;

import com.irelandlight.dao.GoodsDao;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/23
 * Time: 1:08
 * Description: 目的... .
 */
@Component
public class GoodsManager {
    @Resource
    private GoodsDao goodsDao;

    public Map<String,Object> updateBatchSaleQuantity(List<ShopCarGoodsRelation> shopCarGoodsRelations)throws Exception{
        Map<String,Object> rMap = new HashMap<String,Object>();
        if (shopCarGoodsRelations == null || shopCarGoodsRelations.size()<=0){
            rMap.put("code",1);
            rMap.put("status","商品不存在");
        }else if(goodsDao.updateBatchSaleQuantity(shopCarGoodsRelations)==0){
            rMap.put("code",2);
            rMap.put("status","更新库存销量失败");
        }else {
            rMap.put("code",0);
            rMap.put("status","更新库存销量成功");
        }
        return rMap;
    }

}
