package com.irelandlight.dao;

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
public class PersonalInfoDaoTest {

    @Resource
    private PersonalInfoDao personalInfoDaoImpl;

    @Test
    public void findPersonalInfo() throws Exception {
        System.out.println( personalInfoDaoImpl.findPersonalInfo(1001L));
    }

    @Test
    public void update()throws Exception{
        personalInfoDaoImpl.updateEmail(1001L,"52238962@qq.com");
        personalInfoDaoImpl.updateNickname(1001L,"精神领袖");
    }

}
