package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.model.Consumer;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 15:03
 * Description: description
 */
public class RegisterDaoTest extends BaseJunitTest {

    @Resource
    private RegisterDao registerDao;

    @Test
    public void testInsertNewConsumer(){
        Consumer consumer=new Consumer();
        consumer.setUsername("ttt");
        consumer.setNickname("test");
        consumer.setBirthday(new Date(2016,12,100));
        consumer.setEmail("4452@qq.com");
        consumer.setGender("男");
        consumer.setPassword("456951");
        consumer.setTelephone("110");
        consumer.setHeadImgurl("http://ohnx2nsuw.bkt.clouddn.com/20150303104600_PmTmE.thumb.224_0.jpeg");
        /*生成随机盐值*/
        String u = UUID.randomUUID().toString();
        consumer.setSalt(u.substring(0,6));

        registerDao.insertNewConsumer(consumer);
        System.out.println(consumer.getId());
    }

    @Test
    public void testInsertShopCar(){
        registerDao.insertShopCar(1008L);
    }

    @Test
    public void testCountProductor(){
        System.out.println( registerDao.countProductor() );;
    }

    @Test
    public void testTransfer()throws Exception{
        Integer ProNum=registerDao.countProductor();
        //随机分配一个管理员id
       for (int i=0;i<30;i++){
           Integer ProductorId=new Random().nextInt(ProNum)+1;
           Long from_id=Long.valueOf( ProductorId );
           System.out.println(from_id);
       }
    }

    @Test
    public void testfindConsumerByUserName(){
        System.out.println( registerDao.findConsumerByUserName("laosi") );
    }

}
