package com.irelandlight.dao;

import com.irelandlight.model.ProductorLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mac on 2016/12/8.
 */
public interface POperatinonLogMapper {
    public int insertOperation(@Param("productorLog") ProductorLog productorLog);
    public List<String> selectOperationByPid( @Param("pid") Long pid);
}
