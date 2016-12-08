package com.irelandlight.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2016/5/26.
 */
@Repository
public interface SeckillDao {

    /**
     * 减库存，
     * @param seckillId
     * @param killTime
     * @return 如果影响记录行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据ID去查询秒杀对象
     * @param seckillId
     * @return
     */
   // Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset 偏移量
     * @param limit 在偏移量之后去多少条记录
     * @return
     */
   // List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
