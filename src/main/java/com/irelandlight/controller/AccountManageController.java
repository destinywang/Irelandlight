package com.irelandlight.controller;

import com.irelandlight.model.Consumer;
import com.irelandlight.service.AccountManageService;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * User: Matt
 * Date: 2016/12/12
 * Time: 6:31
 * Description: description
 */
@RequestMapping("accountmanage")
public class AccountManageController {

    @Resource
    private AccountManageService accountManageServiceImpl;

    private static final ThreadLocal<Long> consumerId=new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    /*该方法用于修改电话号码*/
    @RequestMapping(value = "changeTelephone")
    public void changeTelephone(@RequestBody Consumer consumer) throws Exception {
        System.out.println("accept");
        accountManageServiceImpl.changeTelephone(consumerId.get(), consumer.getTelephone());
    }






}
