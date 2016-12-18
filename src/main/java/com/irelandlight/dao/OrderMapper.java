package com.irelandlight.dao;

import com.irelandlight.model.Order;
import com.irelandlight.vo.OrderDetail;
import com.irelandlight.vo.OrderGoodsDetail;
import com.irelandlight.vo.OrderModify;
import com.irelandlight.vo.OrderSimpleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    public Order selectOrderByOrderNo(@Param("orderNo") String orderNo); //按照订单编号查找订单
    public List<OrderSimpleInfo> selectOrderSimpleInfo();
    public OrderDetail selectOrderDetailById(@Param("orderId") Long orderId);

    public List<OrderGoodsDetail> selectOrderGoodsDetailById(@Param("orderId")Long orderId);
    public int updateTransferBegin(@Param("orderId") Long orderId, @Param("transferBegin")Date transferBegin);
    public int updateStatus(@Param("orderId")Long orderId,@Param("newStatus")Integer newStatus);
    public int updateTransferEnd(@Param("orderId")Long orderId,@Param("transferEnd")Date transferEnd);
    public int updateTransferWay(@Param("orderId")Long orderId,@Param("transferWay")Integer transferWay);
    public int updateOrder(@Param("orderId")Long orderId, @Param("orderModify")OrderModify orderModify);
}
