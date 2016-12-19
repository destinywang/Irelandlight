package com.irelandlight.manager;

import com.irelandlight.dao.CouponDao;
import com.irelandlight.model.Coupon;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 12:10
 * Description: 目的... .
 */
@Component
public class CouponManager {

    @Resource
    private CouponDao couponDao;
    /**
     * 查询用户可用优惠券 findCouponByConsumerId
     * @param consumerId 用户Id
     * @return List<Coupon> 用户可用优惠券列表
     * @throws Exception 异常
     */
    public Map<String,Object> findCouponByConsumerId(Long consumerId) throws Exception{
        Map<String,Object> coupon = new HashMap<String, Object>();

        if (consumerId == null || consumerId < 0){

            coupon.put("code",1);
            coupon.put("status","用户不存在");
            //System.out.println("用户不存在");
            return coupon;
        }
        List<Coupon> coupons = couponDao.findCouponByConsumerId(consumerId);
        if(coupons == null){
            coupon.put("code",2);
            coupon.put("status","无可用优惠券");
            //System.out.println("无可用优惠券");
            return coupon;
        }
        coupon.put("code",0);
        coupon.put("coupons",coupons);
        return coupon;
    }


    /**
     * 删除已用优惠券 deleteCoupon
     * @param consumerId 用户id
     * @param couponId 优惠券id
     * @throws Exception 异常
     */
    public Map<String,Object> deleteCoupon(Long consumerId,Long couponId) throws Exception{
        Map<String,Object> delCoupon = new HashMap<String, Object>();
        if (consumerId == null || consumerId <0){
            delCoupon.put("code",1);
            delCoupon.put("status","用户不存在");
            //System.out.println("用户不存在");
            return delCoupon;
        }
        if (couponId == null || couponId <0){
            delCoupon.put("code",2);
            delCoupon.put("status","优惠券不存在");
            //System.out.println("优惠券不存在");
            return delCoupon;
        }
        if(couponDao.deleteCoupon(consumerId,couponId)==0){
            delCoupon.put("code",3);
            delCoupon.put("status","优惠券删除失败");
            return delCoupon;
        }
        delCoupon.put("code",0);
        delCoupon.put("status","删除成功");
        return delCoupon;
    }
}
