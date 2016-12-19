package com.irelandlight.dao;

import com.irelandlight.model.History;
import com.irelandlight.vo.GoodDisplay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/13
 * Time: 19:36
 * Description: MyHistoryDao
 */
@Repository
public interface MyHistoryDao {

    public void insertMyHistory(History history) throws Exception;

    public void deleteMyHistory(Long historyId) throws Exception;

    public List<History> findHistoryTest(Long consumerId) throws Exception;

    public Long findExistHistory(History history) throws Exception;

    public int updateHistoryTime(Long historyId) throws Exception;

    public int deleteHistoryList(@Param("HistoryId") List<Long> historyId) throws Exception;

    public List<GoodDisplay> findMyHistory(Long consuerId) throws Exception;

    public History findMyHistoryByHistoryId(Long historyId) throws Exception;

}
