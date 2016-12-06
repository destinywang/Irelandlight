package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.controller.GoodsMapperTest;
import com.irelandlight.model.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/6.
 */
public class GoodsDaoTest extends BaseJunitTest{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void testMethod(){
        System.out.println(orderMapper.selectOrderCanceled());
        System.out.println(orderMapper.selectOrderSucceed());
        System.out.println(orderMapper.selectOrderUnpay());
        System.out.println(orderMapper.selectOrderUnhandle());

        List<Map<Object,Object>> orderList=orderMapper.selectOrderDetailByMonth();

        for (Map<Object,Object> map:orderList) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }


        System.out.println(orderMapper.selectOrderByOrderNum("cx06143047").getRemark());

        List<Goods> goodsList=goodsMapper.selectPutawayGoods();
        for (Goods goods:goodsList){
            System.out.println("已经上架的商品为:"+goods.getName()+" size:"+goods.getSize());
        }
        goodsList=goodsMapper.selectUnPutawayGoods();

        for (Goods goods:goodsList){
            System.out.println("未上架的商品为:"+goods.getName()+" size:"+goods.getSize());
        }
        Goods good=new Goods();
        good.setIsPutaway(1);
        good.setName("香");
        good.setDescription("吃");
        good.setPreference("绿绿的，很美味");
        good.setPrice(new BigDecimal(223.56));
        good.setUse("啦啦");
        good.setTaste("哈哈");
        good.setSize("2");
        good.setQuantity(58);
        good.setSaleCount(77);
        good.setWeight(3);
        //goodsMapper.insertIntoGoods(good);

        //  System.out.println(good.getId());

        // goodsMapper.insertIntoGoodsByParam(good);

        // System.out.println(good.getId());
    }


}
