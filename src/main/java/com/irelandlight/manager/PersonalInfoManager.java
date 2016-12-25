package com.irelandlight.manager;

import com.irelandlight.dao.PersonalInfoDao;
import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/21
 * Time: 17:07
 * Description: description
 */
@Component
public class PersonalInfoManager {

    @Resource
    private PersonalInfoDao personalInfoDaoImpl;

    public Map<String,Object> findPersonalInfo(Long consumerId){
        Map<String , Object> updateStatus=new HashMap<String, Object>();
        Consumer consumer=personalInfoDaoImpl.findPersonalInfo(consumerId);
        if (consumer==null){
            updateStatus.put("status",1);
            updateStatus.put("msg","查询用户失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg",consumer);
        }
        return updateStatus;
    }

    public Map<String,Object> updateNickname(Long consumerId,String nickname){
        Map<String , Object> updateStatus=new HashMap<String, Object>();
        Integer updateRow = personalInfoDaoImpl.updateNickname(consumerId, nickname);
        if (updateRow!=1){
            updateStatus.put("status",1);
            updateStatus.put("msg","修改昵称失败");
        }else{
            updateStatus.put("status",0);
            updateStatus.put("msg","修改昵称成功");
        }
        return updateStatus;
    }

    public Map<String,Object> updateEmail(Long consumerId,String email){
        Map<String , Object> updateStatus=new HashMap<String, Object>();
        Integer updateRow = personalInfoDaoImpl.updateEmail(consumerId, email);
        if (updateRow!=1){
            updateStatus.put("status",1);
            updateStatus.put("msg","修改邮箱失败");
        }else{
            updateStatus.put("status",0);
            updateStatus.put("msg","修改邮箱成功");
        }
        return updateStatus;
    }

}
