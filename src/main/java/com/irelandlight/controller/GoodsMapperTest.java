package com.irelandlight.controller;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.dao.OrderMapper;
import com.irelandlight.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/5.
 */
@Controller
public class GoodsMapperTest {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("/queryTest")
    public void testSel(){
        System.out.println(orderMapper.selectOrderCanceled());
        System.out.println(orderMapper.selectOrderSucceed());
        System.out.println(orderMapper.selectOrderUnpay());
        System.out.println(orderMapper.selectOrderUnhandle());

        List<Map<Object,Object>>  orderList=orderMapper.selectOrderDetailByMonth();

        for (Map<Object,Object> map:orderList) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }


        System.out.println(orderMapper.selectOrderByOrderNum("cx06143047").getRemark());

        List<Goods> goodsList=goodsMapper.selectPutawayGoods();

        //goodsMapper.insertIntoGoods(good);

        //  System.out.println(good.getId());

        // goodsMapper.insertIntoGoodsByParam(good);

        // System.out.println(good.getId());
    }

}
