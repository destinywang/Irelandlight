package com.irelandlight.dao;

import com.irelandlight.model.Comment;
import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.vo.SizePrice;

import java.util.List;

/**
 * 蛋糕详情
 * Created by Zichu on 2016/12/6.
 */
public interface GoodsDetailDao {
    /**
     * 查询商品的轮播图
     * @param id
     * @return 返回该商品id对应的图片列表
     */
    List<GoodsImage> queryGoodsImage(int id);

    /**
     * 查询商品所有信息
     * @param id
     * @return 返回该商品id对应的信息
     */
    List<Goods> queryGoodsDetail(int id);

    /**
     * 查询该商品的价格尺寸表
     * @param id
     * @return
     */
    List<SizePrice> querySizePrice(int id);

    /**
     * 查询评论
     * @param id
     * @return 返回该商品的全部评论
     */
    List<Comment> queryGoodsComment(int id);

    /**
     * 添加对评论的评论
     * @param comment
     */
    void addComment(Comment comment);

}
