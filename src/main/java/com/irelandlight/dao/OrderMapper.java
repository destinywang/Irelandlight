package com.irelandlight.dao;

import com.irelandlight.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/3.
 */
public interface OrderMapper {
    public int selectOrderUnhandle();   //查找未处理订单   0
    public int selectOrderUnpay();      //查询未支付订单   1
    public int selectOrderUndispatch(); //查询未派送订单数  2
    public int selectOrderSucceed();    //查询交易成功订单数 3
    public int selectOrderCanceled();   //查询被取消订单数  4
    public List <Map<Object,Object>> selectOrderDetailByMonth(); //按月查询每月订单数
    public Order selectOrderByOrderNum(@Param("orderNo") String orderNo); //按照订单编号查找订单


}
