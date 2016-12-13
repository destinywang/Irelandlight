package com.irelandlight.service;

import com.irelandlight.dao.OrderMapper;
import com.irelandlight.manager.ContextException;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by mac on 2016/12/12.
 */
@Service
public class OrderManageService {
    @Resource
    private OrderMapper orderMapper;


    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
   public OrderInfo queryOrderInfo(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderUnhandle(orderMapper.selectOrderUnhandle());
        orderInfo.setOrderCanceled(orderMapper.selectOrderCanceled());
        orderInfo.setOrderSucceed(orderMapper.selectOrderSucceed());
        orderInfo.setOrderUndispatch(orderMapper.selectOrderUndispatch());
        orderInfo.setOrderUnpay(orderMapper.selectOrderUnpay());
        orderInfo.setOrderDetailByMonth(orderMapper.selectOrderDetailByMonth());
        return orderInfo;
    }

    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<OrderSimpleInfo> queryOrderSimpleInfoList(){
       return orderMapper.selectOrderSimpleInfo();
    }

    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public OrderDetail queryOrderDetaiByOrderId(Long orderId){
        return queryOrderDetaiByOrderId(orderId);
    }

    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<OrderGoodsDetail> queryOrderGoodsDetail(Long orderId){
        List<OrderGoodsDetail> goodsList=orderMapper.selectOrderGoodsDetailById(orderId);
        return goodsList;
    }


    //修改订单
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public void modifyOrderById(Long orderId, OrderModify modifyOperation) throws Exception{
        if(modifyOperation!=null) {
            switch (modifyOperation.getOrderStatus()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    orderMapper.updateStatus(orderId, modifyOperation.getOrderStatus());
                    break;
                default:
                    throw new ContextException("输入订单状态错误");
            }
            if((modifyOperation.getTransferBegin() instanceof Date)&&(modifyOperation.getTransferEnd() instanceof Date)){
                orderMapper.updateTransferBegin(orderId,modifyOperation.getTransferBegin());
                orderMapper.updateTransferEnd(orderId,modifyOperation.getTransferEnd());
            }else {
                throw new ContextException("日期格式错误");
            }
            if(modifyOperation.getTransferWay() instanceof Integer){
                orderMapper.updateTransferWay(orderId,modifyOperation.getTransferWay());
            }else {
                throw new ContextException("输入配送方式格式错误");
            }

        }

    }

}
