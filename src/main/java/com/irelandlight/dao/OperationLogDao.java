package com.irelandlight.dao;

import com.irelandlight.vo.ProductorLogCustom;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2016/12/19.
 */
@Repository
public interface OperationLogDao {

    public int insertOperationLog(ProductorLogCustom productorLogCustom)throws Exception;

}
