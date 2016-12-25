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

    public Integer insertMyHistory(History history);

    public Integer deleteMyHistory(Long historyId);

    public List<History> findHistoryTest(Long consumerId);

    public Long findExistHistory(History history);

    public Integer updateHistoryTime(Long historyId);

    public Integer deleteHistoryList(@Param("HistoryId") List<Long> historyId);

    public List<GoodDisplay> findMyHistory(Long consuerId);

    public History findMyHistoryByHistoryId(Long historyId);

}
