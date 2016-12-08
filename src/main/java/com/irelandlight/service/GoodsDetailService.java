package com.irelandlight.service;

import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.vo.GoodsVO;

import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
public interface GoodsDetailService {
    /**
     * 查询商品的轮播图
     * @param id
     * @return 返回该商品id对应的图片列表
     */
    List<GoodsImage> queryGoodsImage(int id);

    /**
     * 查询商品的全部信息
     * @param id
     * @return
     */
    List<GoodsVO> queryGoodsDetail(int id);
}
