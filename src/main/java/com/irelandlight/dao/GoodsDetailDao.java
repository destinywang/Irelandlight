package com.irelandlight.dao;

import com.irelandlight.model.Comment;
import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.Reply;
import com.irelandlight.model.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 蛋糕详情
 * Created by Zichu on 2016/12/6.
 */
@Repository
public interface GoodsDetailDao {
    /**
     * 查询商品的轮播图
     * @param id
     * @return 返回该商品id对应的图片列表
     */
    List<GoodsImage> queryGoodsImage(Long id);

    /**
     * 查询商品所有信息
     * @param id
     * @return 返回该商品id对应的信息
     */
    GoodsInfo queryGoodsDetail(Long id);

    /**
     * 查询该商品的价格尺寸表
     * @param id
     * @return
     */
    List<SizePrice> querySizePrice(Long id);

    List<CommentGoods> queryCommentGoods(Long id);
    /**
     * 查询评论的所有
     * @param id
     * @return
     */
    List<ReplyVO> queryComments(Long id);
    /**
     * 添加对评论的评论
     * @param reply
     */
    int addComment(Reply reply);

}
