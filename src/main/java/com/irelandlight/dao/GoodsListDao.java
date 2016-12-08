package com.irelandlight.dao;

import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;

import java.util.List;

/**
 * 蛋糕名录页
 * Created by Zichu on 2016/12/6.
 */
public interface GoodsListDao {
    /**
     * 查询全部商品信息
     * @return 按照权重和销量，返回商品的全部信息还有缩略图
     */
    List<GoodsVO> queryAllGoods();

    /**
     * 按照搜索框内容进行查询
     * @param searchBox
     * @return 返回和搜索框内容模糊匹配的所有商品信息
     */
    List<GoodsVO> queryBySearchGoods(String searchBox);

    /**
     * 按照筛选内容进行查找匹配商品信息
     * @param filter
     * @return 返回符合筛选的商品信息
     */
    List<GoodsVO> queryFilterGoods(FilterGoodsVO filter);


}
