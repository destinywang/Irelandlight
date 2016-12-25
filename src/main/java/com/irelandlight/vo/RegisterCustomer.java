package com.irelandlight.vo;

import com.irelandlight.model.Consumer;

/**
 * User: Matt
 * Date: 2016/12/20
 * Time: 21:45
 * Description: 保存由前端传来的参数
 */
public class RegisterCustomer extends Consumer {
    
    private String confirmPass;

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
    
}
