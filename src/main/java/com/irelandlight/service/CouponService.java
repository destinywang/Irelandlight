package com.irelandlight.service;

import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:32
 * Description: 目的... .
 */
public interface CouponService {

    /**
     * 查询用户可用优惠券列表 findCouponByConsumerId
     * @param consumerId 用户id
     * @return List<Coupon> 可用优惠券列表
     * @throws Exception
     */
    public Map<String, Object> findCouponByConsumerId(Long consumerId) throws Exception;

}
