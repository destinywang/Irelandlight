package com.irelandlight.controller;

import com.irelandlight.dao.OrderMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mac on 2016/12/5.
 */
@Controller
@RequestMapping("/")
public class GoodsMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("queryTest")
    public void testSel(){
        System.out.print(orderMapper.selectOrderCanceled());
        System.out.println(orderMapper.selectOrderSucceed());
        System.out.println(orderMapper.selectOrderUnpay());
        System.out.println(orderMapper.selectOrderUnhandle());
    }




}
