package com.irelandlight.manager;

import com.irelandlight.dao.RegisterDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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




}
