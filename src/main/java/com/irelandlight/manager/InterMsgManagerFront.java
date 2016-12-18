package com.irelandlight.manager;

import com.irelandlight.dao.InterMsgDaoFront;
import com.irelandlight.vo.MessageCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2016/12/16.
 */
@Component
public class InterMsgManagerFront {

    @Resource
    private InterMsgDaoFront interMsgDaoFront;

    private static final Logger LOGGER = LoggerFactory.getLogger(InterMsgManagerFront.class);

    public int insertMsg(MessageCustom messageCustom)throws Exception{
        if(messageCustom != null){
            return interMsgDaoFront.insertMsg(messageCustom);
        }else {
            return 0;
        }
    }

}
