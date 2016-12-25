package com.irelandlight.service;

import com.irelandlight.model.History;
import com.irelandlight.vo.GoodDisplay;

import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/16
 * Time: 17:29
 * Description: description
 */
public interface MyHistoryService {
    /*根据顾客id返回浏览记录列表*/
    public List<GoodDisplay> findMyHistory(Long consumerId);

    /*插入一条浏览记录*/
    public Map<String, Object> insertMyHistory(History history);

    /*删除一条浏览记录*/
    public Map<String, Object> deleteMyHistory(Long myHistoryId);

    /*根据一条浏览记录添加一条收藏记录*//*
    public void addToMyCollectionFromHistory(History history) throws Exception;*/

    /*批量删除浏览记录*/
    public Map<String, Object> deleteHistoryList(List<Long> historyIdList);

    /*由浏览记录ID批量添加收藏记录
    public void addToMyCollectionFromHistoryList(List<Long> historyId) throws Exception;*/
}
