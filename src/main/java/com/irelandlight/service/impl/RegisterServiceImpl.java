package com.irelandlight.service.impl;

import com.irelandlight.dao.RegisterDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.RegisterService;
import com.irelandlight.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 15:41
 * Description: description
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterDao registerDaoImpl;

    public int RegisterConsumer(Consumer consumer) throws Exception {

        //生成随机盐值
        String u = UUID.randomUUID().toString();
        String salt = u.substring(0, 6);
        consumer.setSalt(salt);
        //使用MD5加密获取加密后的密码
        String orgin = MD5Util.getMD5(consumer.getPassword() + salt);
        consumer.setPassword(orgin);
        //设置默认头像
        consumer.setHeadImgurl("http://ohnx2nsuw.bkt.clouddn.com/20150303104600_PmTmE.thumb.224_0.jpeg");

        int row = registerDaoImpl.insertNewConsumer(consumer);
        //获取自增主键
        Long consumer_id = consumer.getId();
        registerDaoImpl.insertShopCar(consumer_id);
        //统计管理员数目
        Integer ProNum = registerDaoImpl.countProductor();
        //随机分配一个管理员id
        Integer ProductorId = new Random().nextInt(ProNum) + 1;
        Long from_id = Long.valueOf(ProductorId);
        //插入一条welcome信息
        registerDaoImpl.sendWelcome(from_id, consumer_id);

        return row;
    }
}
