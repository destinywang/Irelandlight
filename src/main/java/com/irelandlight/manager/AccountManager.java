package com.irelandlight.manager;

import com.irelandlight.dao.AccountManageDao;
import com.irelandlight.model.Address;
import com.irelandlight.util.MD5Util;
import com.irelandlight.vo.AccountManagerDisplay;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/22
 * Time: 9:39
 * Description: description
 */
@Component
public class AccountManager {

    @Resource
    private AccountManageDao accountManageDaoImpl;

    public Map<String, Object> changeTelephone(Long consumerId, String phoneNum) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Integer updateRow = accountManageDaoImpl.updateTelephone(consumerId, phoneNum);
        if (updateRow == 0) {
            updateStatus.put("status", 1);
            updateStatus.put("msg", "修改电话号码失败");
        } else {
            updateStatus.put("status", 0);
            updateStatus.put("msg", "修改电话号码成功");
        }
        return updateStatus;
    }

    public Map<String, Object> changePassword(Long consumerId, String oldPass, String newPass) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        String DBold = accountManageDaoImpl.findPassword(consumerId);
        String DBsalt = accountManageDaoImpl.findSalt(consumerId);
        String before = MD5Util.getMD5(oldPass + DBsalt);
        if (DBold.equals(before)) {
            Integer updateRow = accountManageDaoImpl.updatePassword(consumerId, MD5Util.getMD5(newPass + DBsalt));
            if (updateRow == 1) {
                updateStatus.put("status", 0);
                updateStatus.put("msg", "修改密码成功");
            } else {
                updateStatus.put("status", 1);
                updateStatus.put("msg", "修改密码失败");
            }
        } else {
            updateStatus.put("status", 2);
            updateStatus.put("msg", "原密码错误");
        }
        return updateStatus;
    }

    public Map<String, Object> displayAccountManage(Long consumerId) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        String nickname = accountManageDaoImpl.findNickName(consumerId);
        String telephone = accountManageDaoImpl.findTelphone(consumerId);
        Integer defaultAddressId = accountManageDaoImpl.findDefaultAddressId(consumerId);
        String detail = accountManageDaoImpl.findDefaultAddress(consumerId);
        String packagePicker = accountManageDaoImpl.findDefaultConsumer(consumerId);
        //set基本信息,只要是查询成功的都会有
        AccountManagerDisplay accountManagerDisplay = new AccountManagerDisplay();
        accountManagerDisplay.setNickname(nickname);
        accountManagerDisplay.setTelephone(telephone);
        if (nickname == null || telephone == null) {
            updateStatus.put("status", 1);
            updateStatus.put("msg", "获取账户信息失败");
        } else if (defaultAddressId == null) {
            updateStatus.put("status", 2);
            updateStatus.put("msg", accountManagerDisplay);
        } else {
            accountManagerDisplay.setDetail(detail);
            accountManagerDisplay.setConsumerName(packagePicker);
            updateStatus.put("status", 0);
            updateStatus.put("msg", accountManagerDisplay);
        }
        return updateStatus;
    }

    public Map<String, Object> displayAddressList(Long consumerId) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        //发送默认收货地址id
        Integer defaultId = accountManageDaoImpl.findDefaultAddressId(consumerId);
        List<Address> addressList = accountManageDaoImpl.findAddress(consumerId);
        updateStatus.put("defaultId", defaultId);
        updateStatus.put("addressList", addressList);
        return updateStatus;
    }

    public Map<String, Object> addNewAddress(Long consumerId, Address address, Integer flag) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Integer addressId = accountManageDaoImpl.insertNewAddress(address);
        Integer updateRow =null;
        if (flag == 1) {
            updateRow = accountManageDaoImpl.updateDefaultAddressId(consumerId, addressId);
        }
        if (addressId != null ) {
            if (flag==1){
                if (updateRow!=null){
                    updateStatus.put("status", 0);
                    updateStatus.put("msg", "设置默认地址成功");
                }else{
                    updateStatus.put("status", 1);
                    updateStatus.put("msg", "设置默认地址失败");
                }
            }else {
                updateStatus.put("status", 0);
                updateStatus.put("msg", "添加成功");
            }
        } else {
            updateStatus.put("status", 1);
            updateStatus.put("msg", "添加失败");
        }
        return updateStatus;
    }
}
