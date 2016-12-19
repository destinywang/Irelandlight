package com.irelandlight.dao;

import com.irelandlight.model.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:23
 * Description: 优惠券dao .
 */
@Repository
public interface CouponDao {

    /**
     * 查询用户可用优惠券 findCouponByConsumerId
     * @param consumerId 用户Id
     * @return List<Coupon> 用户可用优惠券列表
     * @throws Exception
     */
    public List<Coupon> findCouponByConsumerId(@Param("consumerId") Long consumerId) throws Exception;


    /**
     * 删除已用优惠券 deleteCoupon
     * @param consumerId 用户id
     * @param couponId 优惠券id
     * @throws Exception
     */
    public Integer deleteCoupon(@Param("consumerId") Long consumerId,@Param("couponId") Long couponId) throws Exception;
}
