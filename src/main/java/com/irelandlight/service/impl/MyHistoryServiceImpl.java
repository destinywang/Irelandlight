package com.irelandlight.service.impl;

import com.irelandlight.dao.MyHistoryDao;
import com.irelandlight.model.History;
import com.irelandlight.service.MyHistoryService;
import com.irelandlight.vo.GoodDisplay;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/16
 * Time: 18:14
 * Description: MyHistoryServiceImpl
 */
@Service
public class MyHistoryServiceImpl implements MyHistoryService {

    @Resource
    private MyHistoryDao myHistoryDaoImpl;

    /*根据顾客id返回浏览记录列表*/
    public List<GoodDisplay> findMyHistory(Long consumerId) throws Exception {
        return myHistoryDaoImpl.findMyHistory(consumerId);
    }

    /*根据一条浏览记录进行插入浏览,包含用户id 货物id */
    /*如果浏览中已经存在此浏览信息,则更新 last_update*/
    public void insertMyHistory(History history) throws Exception {
        Long historyId=myHistoryDaoImpl.findExistHistory(history);
        if (historyId==null){
            myHistoryDaoImpl.insertMyHistory(history);
        }
        else {
            myHistoryDaoImpl.updateHistoryTime(historyId);
        }
    }

    /*删除一条浏览记录*/
    public void deleteMyHistory(Long myHistoryId) throws Exception {
        myHistoryDaoImpl.deleteMyHistory(myHistoryId);
    }

    /*批量删除浏览记录*/
    public void deleteHistoryList(List<Long> historyIdList) throws Exception {
        myHistoryDaoImpl.deleteHistoryList(historyIdList);
    }

}
