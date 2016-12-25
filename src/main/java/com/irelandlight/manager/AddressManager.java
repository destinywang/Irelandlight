package com.irelandlight.manager;

import com.irelandlight.dao.AddressDao;
import com.irelandlight.model.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 12:06
 * Description: AddressManager .
 */
@Component("addressManager")
public class AddressManager {

    @Resource
    private AddressDao addressDao;

    public Map<String,Object> findAddressByConsumerId(@Param("consumerId") Long consumerId)throws Exception{
        Map<String,Object> rMap = new HashMap<String,Object>();
        List<Address> addresses;
        if (consumerId == null || consumerId <0){
            rMap.put("code",1);
            rMap.put("status","用户不存在");
        }else if((addresses = addressDao.findAddressByConsumerId(consumerId))==null){
            rMap.put("code",2);
            rMap.put("status","用户不存在");
        }else {
            rMap.put("code",0);
            rMap.put("addresses",addresses);
        }
        return rMap;
    }
}
