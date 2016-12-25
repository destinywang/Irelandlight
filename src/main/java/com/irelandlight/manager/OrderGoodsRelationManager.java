package com.irelandlight.manager;

import com.irelandlight.dao.OrderGoodsRelationDao;
import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/20
 * Time: 19:10
 * Description: OrderGoodsRelationManager .
 */
@Component("orderGoodsRelationManager")
public class OrderGoodsRelationManager {

    @Resource
    private OrderGoodsRelationDao orderGoodsRelationDao;


    //添加订单详情
    public Map<String,Object> insertOrderDetail(Long orderId, List<ShopCarGoodsRelation> shopCarGoodsRelations)throws Exception{
        Map<String, Object> rMap = new HashMap<String,Object>();
        if(orderId == null || orderId < 0){
            rMap.put("code",1);
            rMap.put("status","订单号不存在");
        }else if (shopCarGoodsRelations == null || shopCarGoodsRelations.size() <= 0 ){
            rMap.put("code",2);
            rMap.put("status","商品信息不存在");
        }else {
            if (orderGoodsRelationDao.insertOrderDetail(orderId, shopCarGoodsRelations) == 0){
                rMap.put("code",3);
                rMap.put("status","添加订单商品失败");
            }else {
                rMap.put("code",0);
                rMap.put("status","添加订单商品成功");
            }
        }
        return rMap;
    }



    //立即购买
    public Map<String,Object> buyNow(OrderGoodsRelation orderGoodsRelation) throws Exception{
        Map<String, Object> rMap = new HashMap<String,Object>();
        if(orderGoodsRelation == null){
            rMap.put("code",1);
            rMap.put("status","参数异常");
        }else if(orderGoodsRelationDao.buyNow(orderGoodsRelation)!=0){
            rMap.put("code",0);
            rMap.put("status","添加成功");
        }else {
            rMap.put("code",2);
            rMap.put("status","添加失败");
        }
        return rMap;
    }
}
