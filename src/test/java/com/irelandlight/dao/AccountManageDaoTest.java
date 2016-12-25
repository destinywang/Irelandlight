package com.irelandlight.dao;

import com.irelandlight.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Matt on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AccountManageDaoTest {

    @Resource
    private AccountManageDao accountManageDao;

    @Test
    public void find() throws Exception {
        /*System.out.println(123);
        System.out.println(accountManageDao.findConsumerName(1001L));
        System.out.println(accountManageDao.findTelphone(1001L));*/
        System.out.println(accountManageDao.findAddress(1001L));
        /*System.out.println(accountManageDao.findDefaultAddress(1001L));
        System.out.println(accountManageDao.findPassword(1001L));
        System.out.println(accountManageDao.findAddress(1002L));*/
    }

    @Test
    public void update()throws Exception{
        accountManageDao.updatePassword(1001L,"11998");
        accountManageDao.updateTelephone(1001L,"999988");
    }

    @Test
    public void insert() throws Exception{
        Address address=new Address();
        address.setProvince("陕西省");
        address.setCity("西安市");
        address.setDistrict("长安区");
        address.setStreet("子午大道");
        address.setDetail("春天花园");
        address.setPost("518116");
        address.setConsumerId(1001L);
        address.setConsumerName("刘琳姐");
        address.setConsumerPhone("11235813");
        accountManageDao.insertNewAddress(address);
    }

}
