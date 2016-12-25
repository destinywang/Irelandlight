package com.irelandlight.service.impl;

import com.irelandlight.manager.ShopCarGoodsRelationManager;
import com.irelandlight.manager.ShopCarManager;
import com.irelandlight.model.ShopCar;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.ShopCarGoodsRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/8
 * Time: 15:21
 * Description: 购物车详情service实现类.
 */
@Service
public class ShopCarGoodsRelationServiceImpl implements ShopCarGoodsRelationService {

    @Resource
    private ShopCarManager shopCarManager;

    @Resource
    private ShopCarGoodsRelationManager shopCarGoodsRelationManager;
    /**
     * 添加购物车详情
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public Map<String, Object> insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationManager.insertGoodsWithNo(shopCarGoodsRelation);
    }



    /**
     * 更新购物车商品详情
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public Map<String, Object> updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationManager.updateShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 删除某条购物车详情 deleteShopCarGoodsRelation
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public Map<String, Object> deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationManager.deleteShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 批量删除购物车详情 batchDeleteShopCarGoodsRelations
     * @param shopCarGoodsRelations
     * @throws Exception
     */
    public Map<String, Object> batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws Exception {
        return shopCarGoodsRelationManager.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);
    }


    /**
     * 查找用户购物车商品详情 findShopCarGoodsRelationByShopCarId
     * @param shopCarGoodsRelation
     * @return List<ShopCarGoodsRelation> 购物车商品详情列表
     * @throws Exception
     */
    public Map<String, Object> findShopCarGoodsRelationByShopCarId(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationManager.findShopCarGoodsRelationByShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 向购物车添加商品，解决购物车有需要添加的商品 insertGoodsRelation
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    @Transactional
    public Map<String, Object> insertGoodsRelation(Long consumerId ,ShopCarGoodsRelation shopCarGoodsRelation) throws Exception{
        //查找用户购物车商品（通过购物车id + 商品id + 商品size） 如果有则返回的该商品详情
        Map<String, Object> rMap = new HashMap<String, Object>();

        Map<String, Object> Relation = shopCarGoodsRelationManager.findSameGoodsRelation(shopCarGoodsRelation);
        Integer code = (Integer) Relation.get("code");
        if (code == 0){
            ShopCarGoodsRelation shopCarGoodsRelation1 = (ShopCarGoodsRelation) Relation.get("shopCarGoodsRelation");
            shopCarGoodsRelation1.setCount(shopCarGoodsRelation1.getCount()+shopCarGoodsRelation.getCount());
            Map<String, Object> updateSCGR =shopCarGoodsRelationManager.updateShopCarGoodsRelation(shopCarGoodsRelation1);
            Integer code1 = (Integer) updateSCGR.get("code");
            if(code1 == 0){
                rMap.put("code",0);
                rMap.put("status","修改购物车商品成功");
            }else if(code1 == 1){
                rMap.put("code",1);
                rMap.put("status","无购物车详情信息");
            }else {
                rMap.put("code",2);
                rMap.put("status","修改购物车信息失败");
            }
        }else if(code == 2){
            Map<String, Object> findGoods = shopCarManager.findShopCarDetailByConsumerId(consumerId);
            Integer code1 = (Integer) findGoods.get("code");
            if (code1 == 0){
                ShopCar shopCar = (ShopCar) findGoods.get("shopCar");
                shopCarGoodsRelation.setShopCarId(shopCar.getId());
                Map<String, Object> insertGoods = shopCarGoodsRelationManager.insertGoodsWithNo(shopCarGoodsRelation);
                Integer code2 = (Integer) insertGoods.get("code");
                if (code2 == 0){
                    rMap.put("code",0);
                    rMap.put("status","向购物车添加商品成功");
                }else if (code2 == 1){
                    rMap.put("code",1);
                    rMap.put("status","无购物车详情信息");
                }else {
                    rMap.put("code",2);
                    rMap.put("status","无购物车详情信息");
                }
            }else if (code1 == 1){
                rMap.put("code",1);
                rMap.put("status","用户不存在");
            }else {
                rMap.put("code",2);
                rMap.put("status","无购物车信息");
            }
        }else {
            rMap.put("code",1);
            rMap.put("status","无购物车详情信息");
        }
        return  rMap;
    }
}
