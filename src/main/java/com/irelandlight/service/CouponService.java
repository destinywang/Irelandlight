package com.irelandlight.service;

import com.irelandlight.model.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    public List<Coupon> findCouponByConsumerId(Long consumerId) throws Exception;

}
