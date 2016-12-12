package com.irelandlight.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 23:13
 * Description: 目的... .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class OrderControllerTest {

    @Resource
    private OrderController orderController;

    @Test
    public void testOneOrderDetail() {
        try {
            System.out.println(orderController.oneOrderDetail(18L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
