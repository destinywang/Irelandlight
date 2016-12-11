package com.irelandlight.service.impl;

import com.irelandlight.dao.CouponDao;
import com.irelandlight.model.Coupon;
import com.irelandlight.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:34
 * Description: 目的... .
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponDao couponDao;

    public List<Coupon> findCouponByConsumerId(Long consumerId) throws Exception {
        return couponDao.findCouponByConsumerId(consumerId);
    }
}
