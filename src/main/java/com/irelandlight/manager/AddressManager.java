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
@Component
public class AddressManager {

    @Resource
    private AddressDao addressDao;
    /**
     * 查询用户的收货地址
     * @return List<Address> 收货地址列表
     * @throws Exception 异常
     */
    //findAddressByConsumerId
    public Map<String,Object> findAddressByConsumerId(@Param("consumerId") Long consumerId)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        List<Address> addresses;
        if (consumerId == null || consumerId <0){
            //System.out.println("用户 不存在");
            map.put("code",1);
            map.put("status","用户不存在");
        }else if((addresses = addressDao.findAddressByConsumerId(consumerId))==null){
            map.put("code",2);
            map.put("status","用户不存在");
        }else {
            map.put("code",0);
            map.put("addresses",addresses);
        }
        return map;
    }
}
