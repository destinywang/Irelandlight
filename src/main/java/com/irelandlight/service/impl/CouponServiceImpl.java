package com.irelandlight.service.impl;

import com.irelandlight.manager.CouponManager;
import com.irelandlight.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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
    private CouponManager couponManager;

    public Map<String, Object> findCouponByConsumerId(Long consumerId) throws Exception {
        return couponManager.findCouponByConsumerId(consumerId);
    }
}
