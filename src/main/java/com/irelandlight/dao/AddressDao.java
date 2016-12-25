package com.irelandlight.dao;

import com.irelandlight.model.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 8:57
 * Description: 用户收货地址dao .
 */
@Repository
public interface AddressDao {
    /**
     * 查询用户的收货地址
     * @return List<Address> 收货地址列表
     * @throws Exception
     */
    //findAddressByConsumerId
    public List<Address> findAddressByConsumerId(@Param("consumerId") Long consumerId)throws Exception;
}
