package com.irelandlight.dao;

import com.irelandlight.model.Address;
import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Matt on 2016/12/9.
 */
@Repository
public interface AccountManageDao {

    /*//注册新用户
    public void insertNewConsumer(Consumer consumer) throws Exception;*/

    //根据cid查找用户名
    public String findConsumerName(Long id)throws Exception;

    //根据cid查找用户昵称
    public String findNickName(Long id)throws Exception;

    //根据cid查找手机号码
    public String findTelphone(Long id)throws Exception;

    //根据cid修改手机号码
    public void updateTelephone(Long id,String telephone)throws Exception;

    //根据cid查找原密码
    public String findPassword(Long id)throws Exception;

    //根据cid修改密码
    public void  updatePassword(Long id,String password)throws Exception;

    //根据cid查找默认收货地址
    public String findDefaultAddress(Long id)throws Exception;

    //根据cid查找默认地址收货人
    public String findDefaultConsumer(Long id)throws Exception;

    //根据cid查找所有收货地址
    public List<Address> findAddress(Long id) throws Exception;

    //根据cid添加新地址
    public void insertNewAddress(Address address) throws Exception;


}
