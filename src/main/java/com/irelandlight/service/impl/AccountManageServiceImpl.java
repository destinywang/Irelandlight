package com.irelandlight.service.impl;

import com.irelandlight.manager.AccountManager;
import com.irelandlight.model.Address;
import com.irelandlight.service.AccountManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
@Service
public class AccountManageServiceImpl implements AccountManageService{

    @Resource
    private AccountManager accountManagerImpl;

    /*该方法用来修改密码*/
    public Map<String, Object> changePassword(Long consumerId,String oldPass,String newPass) {
        return accountManagerImpl.changePassword(consumerId,oldPass,newPass);
    }

    /*该方法用来展示账户管理页，需要展示昵称，手机号，详细默认收货地址，默认收货人；返回值类型待确定*/
    public Map<String,Object> displayAccountManage(Long id){
        return accountManagerImpl.displayAccountManage(id);
    }

    /*该方法用来完成 换绑手机 页的功能*/
     public Map<String ,Object> changeTelephone(Long id, String Telephone) {
         return accountManagerImpl.changeTelephone(id,Telephone);
     }

     /*该方法用来完成 添加新地址 页的功能*/
     public Map<String ,Object> addNewAddress(Long consumerId,Address address,Integer flag){
         return accountManagerImpl.addNewAddress(consumerId,address,flag);
     }

    /*该方法用来完成 管理地址 页的功能*/
    public Map<String ,Object> displayAddress(Long id){
        return accountManagerImpl.displayAddressList(id);
    }

}
