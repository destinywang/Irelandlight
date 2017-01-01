package com.irelandlight.manager;

import com.irelandlight.dao.RegisterDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/19
 * Time: 21:54
 * Description: description
 */
@Component
public class RegisterManager {

    @Resource
    private RegisterDao registerDaoImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterManager.class);

    public Map<String, Object> RegisterConsumer(Consumer consumer) {
        Map<String, Object> RegisterMap = new HashMap<String, Object>();

        //生成随机盐值
        String u = UUID.randomUUID().toString();
        String salt = u.substring(0, 6);
        //设置默认昵称
        String afterNickname = u.substring(26, 34);
        consumer.setNickname("cake_" + afterNickname);
        //设置盐值
        consumer.setSalt(salt);
        //使用MD5加密获取加密后的密码
        String orgin = MD5Util.getMD5(consumer.getPassword() + salt);
        consumer.setPassword(orgin);
        //设置默认头像
        consumer.setHeadImgurl("http://ohnx2nsuw.bkt.clouddn.com/20150303104600_PmTmE.thumb.224_0.jpeg");

        Integer consumerRow = registerDaoImpl.insertNewConsumer(consumer);
        RegisterMap.put("status", consumerRow);
        //获取自增主键
        Long consumer_id = consumer.getId();
        Integer shopCarRow = registerDaoImpl.insertShopCar(consumer_id);
        //统计管理员数目
        Integer ProNum = registerDaoImpl.countProductor();
        //随机分配一个管理员id
        Integer ProductorId = new Random().nextInt(ProNum) + 1;
        Long from_id = Long.valueOf(ProductorId);
        //插入一条welcome信息
        registerDaoImpl.sendWelcome(from_id, consumer_id);

        return RegisterMap;
    }


}
