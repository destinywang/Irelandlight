package com.irelandlight.manager;

import com.irelandlight.dao.GoodsDetailDao;
import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.Reply;
import com.irelandlight.model.vo.CommentGoods;
import com.irelandlight.model.vo.GoodsInfo;
import com.irelandlight.model.vo.ReplyVO;
import com.irelandlight.model.vo.SizePrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/20.
 */
@Component
public class GoodsDetailManager {
    @Resource
    private GoodsDetailDao goodsDetailDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsDetailManager.class);

    /**
     * 处理查询的商品轮播图数据
     * 1.商品id不符合条件
     * 2.查出的数据为null
     * 3.查出的数据完好
     *
     * @param id
     * @return
     */
    public List<GoodsImage> queryGoodsImage(Integer id) {

        List<GoodsImage> goodsImages = goodsDetailDao.queryGoodsImage(id);

        return goodsImages;
    }

    /**
     * 处理查询出的商品详细信息
     * 1.商品id不符合条件
     * 2.查出的数据为null
     * 3.查出的数据完好
     *
     * @param id
     * @return
     */
    public GoodsInfo queryGoodsDetail(Integer id) {
        GoodsInfo goodsInfo=goodsDetailDao.queryGoodsDetail(id);
        return goodsInfo;
    }

    /**
     * 处理查询出来的价格尺寸数据
     * 1.商品id不符合条件
     * 2.查出的数据为null
     * 3.查出的数据完好
     *
     * @param id
     * @return
     */
    public List<SizePrice>  querySizePrice(Integer id) {
        List<SizePrice> sizePrice=goodsDetailDao.querySizePrice(id);

        return sizePrice;
    }

    /**
     * 处理查找到的商品评论数据
     *
     * @param id
     * @return
     */
    public List<CommentGoods> queryCommentsGoods(Integer id) {
        List<CommentGoods> commentGoodses=goodsDetailDao.queryCommentGoods(id);
        return commentGoodses;
    }

    /**
     * 处理商品评论回复数据
     * 1.参数错误
     * 2.查找数据为null
     * 3.查找数据有
     *
     * @param id
     * @return
     */
    public List<ReplyVO> queryComments(Integer id) {

        List<ReplyVO> replyVOs = goodsDetailDao.queryComments(id);

        return replyVOs;
    }

    /**
     * 将回复的评论插入到表中
     * 1.参数为空
     * 2.插入失败
     * 3.插入成功
     *
     * @param reply
     * @return
     */
    public int addReply(Reply reply) {

        int result = goodsDetailDao.addComment(reply);
        if(result==0){
            LOGGER.error("插入失败");
        }
        return result;
    }

}
