package com.irelandlight.service.impl;

import com.irelandlight.dao.AddressDao;
import com.irelandlight.model.Address;
import com.irelandlight.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:10
 * Description: 用户收货地址service实现类 .
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;

    /**
     * 查找用户收货地址列表 findAddressByConsumerId
     * @param consumerId
     * @return List<Address> 收货地址列表
     * @throws Exception
     */
    public List<Address> findAddressByConsumerId(Long consumerId) throws Exception {
        return addressDao.findAddressByConsumerId(consumerId);
    }
}
