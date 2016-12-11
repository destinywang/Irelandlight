package com.irelandlight.service;

import com.irelandlight.model.Coupon;
import com.irelandlight.test.BaseJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:48
 * Description: 目的... .
 */
public class CouponTest extends BaseJunitTest{

    @Resource
    private CouponService couponService;

    @Test
    public void TestFindCouponByConsumerId() throws Exception{
        List<Coupon> coupons = couponService .findCouponByConsumerId(1002L);
        System.out.println(coupons);
    }
}
