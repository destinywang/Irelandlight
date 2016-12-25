package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.irelandlight.model.Address;
import com.irelandlight.service.AccountManageService;
import com.irelandlight.vo.AccountManagerDisplay;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/12
 * Time: 6:31
 * Description: description
 */

public class AccountManageController {

    @Resource
    private AccountManageService accountManageServiceImpl;

    private static final ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    @RequestMapping("accountmanage")
    public ModelAndView displayAccountManage() {
        consumerId.set(1001l);
        Map<String, Object> updateStatus = accountManageServiceImpl.displayAccountManage(consumerId.get());
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        JSONObject json=new JSONObject();
        ModelAndView modelAndView=new ModelAndView();
        String Sjson=null;
        if (status==0){
            Sjson=json.toJSONString(updateStatus.get("msg"));
            modelAndView.setViewName("前端MM快发viewname");
            modelAndView.addObject("AccountManage", Sjson);
        }else if(status==2){
            SimplePropertyPreFilter filter=new SimplePropertyPreFilter(AccountManagerDisplay.class,"nickname","telephone");
            Sjson=json.toJSONString(updateStatus.get("msg"),filter);
            modelAndView.setViewName("前端MM快发viewname");
            modelAndView.addObject("AccountManage", Sjson);
        }else{
            Sjson=json.toJSONString(updateStatus.get("msg"));
            modelAndView.setViewName("ERROR");
            modelAndView.addObject(Sjson);
        }
        return modelAndView;
    }

    @RequestMapping("addressList")
    public ModelAndView displayAddressList(){
        consumerId.set(1001l);
        Map<String, Object> updateStatus=accountManageServiceImpl.displayAddress(consumerId.get());
        ModelAndView modelAndView=new ModelAndView();
        if (updateStatus.get("addressList")!=null){
            modelAndView.setViewName("前端MM快发viewname");
            modelAndView.addObject("addressList",updateStatus.get("addressList"));
        }else {
            modelAndView.setViewName("无收货地址,请添加");
        }
        return modelAndView;
    }

    /*该方法用于修改电话号码*/
    @ResponseBody
    @RequestMapping(value = "changeTelephone")
    public String changeTelephone(@RequestBody String Telephone) {
        Map<String, Object> updateStatus = accountManageServiceImpl.changeTelephone(consumerId.get(), Telephone);
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        String msg = null;
        if (status == 0) {
            msg = "success";
        } else {
            msg = "error";
        }
        JSONObject json = new JSONObject();
        String SJson = json.toJSONString(msg);
        return SJson;
    }

    /*该方法用于修改密码*/
    @ResponseBody
    @RequestMapping(value = "changePassword")
    public String changePassword(@RequestBody String oldPass, @RequestBody String newPass) {
        Map<String, Object> updateStatus = accountManageServiceImpl.changePassword(consumerId.get(), oldPass, newPass);
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        String msg = null;
        if (status == 0) {
            msg = "success";
        } else {
            msg = "error";
        }
        JSONObject json = new JSONObject();
        String SJson = json.toJSONString(msg);
        return SJson;
    }

    @RequestMapping(value = "addNewAddress")
    public ModelAndView addNewAddress(@RequestBody Address address,@RequestBody Integer flag){
        Map<String,Object> updateStatus =accountManageServiceImpl.addNewAddress(consumerId.get(),address,flag);
        Integer status= Integer.valueOf( updateStatus.get("status").toString());
        if (status==0){
            //设置页面跳转至 displayAddress
            return this.displayAddressList();
        }else {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("ERROR");
            return modelAndView;
        }
    }


}
