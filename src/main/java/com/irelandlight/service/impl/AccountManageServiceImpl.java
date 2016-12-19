package com.irelandlight.service.impl;

import com.irelandlight.dao.AccountManageDao;
import com.irelandlight.model.Address;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.AccountManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * Created by Matt on 2016/12/9.
 */
@Service
public class AccountManageServiceImpl implements AccountManageService{

    @Resource
    private AccountManageDao accountManageDao;

    /*注册新用户*//*
    public void registerNewConsumer(@RequestBody  Consumer consumer) throws Exception {
        accountManageDao.insertNewConsumer(consumer);
    }*/

    /*该方法用来查找用户的密码，会在两个地方使用到：
        1.用户登录
        2.用户修改密码*/
    public String findConsumerPassword(Long id) throws Exception {
        return accountManageDao.findPassword(id);
    }

    /*该方法用来展示账户管理页，需要展示昵称，手机号，详细默认收货地址，默认收货人；返回值类型待确定*/
    public void displayAccountManage(Long id)throws Exception{
        String nick = accountManageDao.findNickName(id);
        String tel = accountManageDao.findTelphone(id);
        String detail = accountManageDao.findDefaultAddress(id);
        String consumer = accountManageDao.findDefaultConsumer(id);
        System.out.println(
                "nick:"+nick+
                "tel:"+tel+
                "detail:"+detail+
                "consumer:"+consumer
        );
    }

    /*该方法用来完成 换绑手机 页的功能*/
     public void changeTelephone(Long id,String Telephone) throws Exception{
         accountManageDao.updateTelephone(id,Telephone);
     }

     /*该方法用来完成 添加新地址 页的功能*/
     public void addNewAddress(Address address)throws Exception{
         /*consumerId在之前发送过来，包含在address里*/
         accountManageDao.insertNewAddress(address);
     }

    /*该方法用来完成 管理地址 页的功能*/
    public void displayAddress(Long id)throws Exception{
        accountManageDao.findAddress(id);
    }

}
