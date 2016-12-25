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

    //根据cid查找用户名
    public String findConsumerName(Long id);

    //根据cid查找用户昵称
    public String findNickName(Long id);

    //根据cid查找手机号码
    public String findTelphone(Long id);

    //根据cid修改手机号码
    public Integer updateTelephone(Long id, String telephone);

    //根据cid查找原密码
    public String findPassword(Long id);

    //根据cid查找默认收货地址id
    public Integer findDefaultAddressId(Long id);

    //根据cid查找盐值
    public String findSalt(Long id);

    //根据cid修改密码
    public Integer updatePassword(Long id, String password);

    //根据cid查找默认收货地址
    public String findDefaultAddress(Long id);

    //根据cid查找默认地址收货人
    public String findDefaultConsumer(Long id);

    //根据cid查找所有收货地址
    public List<Address> findAddress(Long id);

    //根据cid添加新地址
    public Integer insertNewAddress(Address address);

    //根据cid,flag,设置默认收货地址id
    public Integer updateDefaultAddressId(Long consumerId,Integer defaultAddressId);
}
