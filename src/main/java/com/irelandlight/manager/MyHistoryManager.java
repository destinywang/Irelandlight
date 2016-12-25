package com.irelandlight.manager;

import com.irelandlight.dao.MyHistoryDao;
import com.irelandlight.model.History;
import com.irelandlight.vo.GoodDisplay;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/23
 * Time: 14:00
 * Description: description
 */
@Component
public class MyHistoryManager {

    @Resource
    private MyHistoryDao myHistoryDaoImpl;

    public Map<String , Object> findMyHistory(Long consumerId){
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        List<GoodDisplay> historyList = myHistoryDaoImpl.findMyHistory(consumerId);
        if (historyList==null){
            updateStatus.put("status",1);
            updateStatus.put("msg","查询浏览历史失败");
        }else{
            updateStatus.put("status",0);
            updateStatus.put("msg",historyList);
        }
        return updateStatus;
    }

    public Map<String ,Object> deleteHistory(Long historyId){
        Map<String,Object> updateStatus =new HashMap<String,Object>();
        Integer updateRow=myHistoryDaoImpl.deleteMyHistory(historyId);
        if (updateRow==1){
            updateStatus.put("status",0);
            updateStatus.put("msg","删除浏览历史成功");
        }else {
            updateStatus.put("status",1);
            updateStatus.put("msg","删除浏览历史失败");
        }
        return updateStatus;
    }

    public Map<String ,Object> deleteHistoryList(List<Long> historyIdList){
        Map<String,Object> updateStatus =new HashMap<String,Object>();
        Integer updateRow=myHistoryDaoImpl.deleteHistoryList(historyIdList);
        if (updateRow==0){
            updateStatus.put("status",1);
            updateStatus.put("msg","删除浏览历史列表失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg","删除浏览历史列表成功");
        }
        return updateStatus;
    }

    public Map<String ,Object> insertHistory(History history){
        Map<String,Object> updateStatus =new HashMap<String,Object>();
        Integer updateRow=null;
        Integer insertRow=null;
        Long historyId=myHistoryDaoImpl.findExistHistory(history);
        if (historyId==null){
            insertRow=myHistoryDaoImpl.insertMyHistory(history);
        }
        else {
            updateRow=myHistoryDaoImpl.updateHistoryTime(historyId);
        }

        if (updateRow==null && insertRow==null){
            updateStatus.put("status",1);
            updateStatus.put("msg","添加浏览历史失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg","添加浏览历史成功");
        }

        return  updateStatus;
    }


}
