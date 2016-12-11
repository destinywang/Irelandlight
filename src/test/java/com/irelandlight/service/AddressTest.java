package com.irelandlight.service;

import com.irelandlight.model.Address;
import com.irelandlight.service.impl.AddressServiceImpl;
import com.irelandlight.test.BaseJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:15
 * Description: 测试用户收货地址 .
 */
public class AddressTest extends BaseJunitTest {

    @Resource
    private AddressService addressService;

    @Test
    public void testFindAddressByConsumerId() throws Exception {
       List<Address> addresses = addressService.findAddressByConsumerId(1002L);
        System.out.println(addresses);
    }
}
