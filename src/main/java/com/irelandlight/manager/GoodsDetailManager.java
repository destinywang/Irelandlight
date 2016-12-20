package com.irelandlight.manager;

import com.irelandlight.dao.GoodsDetailDao;
import com.irelandlight.model.Comment;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/20.
 */
@Component
public class GoodsDetailManager {
    @Resource
    private GoodsDetailDao goodsDetailDao;

    private static final Logger LOGGER= LoggerFactory.getLogger(GoodsDetailManager.class);

    /**
     * 处理查询的商品轮播图数据
     *   1.商品id不符合条件
     *   2.查出的数据为null
     *   3.查出的数据完好
     * @param id
     * @return
     */
    public Map<String,Object>queryGoodsImage(Long id){
        Map<String,Object>goodsImage=new HashMap<String,Object>();
        if(id==null || id<0){
            goodsImage.put("code",1);
            goodsImage.put("msg","参数有误");
        }
        else{
            List<GoodsImage> goodsImages=goodsDetailDao.queryGoodsImage(id);
            if(goodsImages==null){
                goodsImage.put("code",2);
                goodsImage.put("msg","查询不到该商品轮播图");
            }
            else {
                goodsImage.put("code",0);
                goodsImage.put("goodsImages",goodsImages);
            }
        }
        return goodsImage;
    }

    /**
     * 处理查询出的商品详细信息
     *   1.商品id不符合条件
     *   2.查出的数据为null
     *   3.查出的数据完好
     * @param id
     * @return
     */
    public Map<String,Object>queryGoodsDetail(Long id){
        Map<String,Object> goodsInfo=new HashMap<String,Object>();
        if(id==null || id<0){
            goodsInfo.put("code",1);
            goodsInfo.put("msg","参数有误");
            LOGGER.error("参数有误");
        }
        else{
            GoodsInfo goodsInfo1=goodsDetailDao.queryGoodsDetail(id);
            if(goodsInfo1==null){
                goodsInfo.put("code",2);
                goodsInfo.put("msg","查询不到该商品");
            }else {
                goodsInfo.put("code",0);
                goodsInfo.put("goodsInfo",goodsInfo1);
            }
        }
        return goodsInfo;
    }

    /**
     * 处理查询出来的价格尺寸数据
     *   1.商品id不符合条件
     *   2.查出的数据为null
     *   3.查出的数据完好
     * @param id
     * @return
     */
    public Map<String,Object>querySizePrice(Long id){
        Map<String,Object> sizePrice=new HashMap<String,Object>();
        if(id==null || id<0){
            sizePrice.put("code",1);
            sizePrice.put("msg","参数有误");
            LOGGER.error("参数有误");
        }else{
            List<SizePrice> sizePrices=goodsDetailDao.querySizePrice(id);
            if(sizePrice==null){
                sizePrice.put("code",2);
                sizePrice.put("msg","查询不到该商品");
            }else{
                sizePrice.put("code",0);
                sizePrice.put("sizePrice",sizePrices);
            }
        }
        return sizePrice;
    }

    /**
     * 处理查找到的商品评论数据
     * @param id
     * @return
     */
    public Map<String,Object> queryCommentsGoods(Long id){
        Map<String,Object> commentsMap=new HashMap<String,Object>();
        if(id==null || id<0){
            commentsMap.put("code",1);
            commentsMap.put("msg","参数有误");
            LOGGER.error("参数有误");
        }else{
            List<CommentGoods> commentGoodses=goodsDetailDao.queryCommentGoods(id);
            if(commentGoodses==null){
                commentsMap.put("code",2);
                commentsMap.put("msg","查找不到相应的评论");
            }else{
                commentsMap.put("code",0);
                commentsMap.put("commentGoods",commentGoodses);
            }
        }
        return commentsMap;
    }

    /**
     * 处理商品评论回复数据
     *   1.参数错误
     *   2.查找数据为null
     *   3.查找数据有
     * @param id
     * @return
     */
    public Map<String,Object> queryComments(Long id){
        Map<String,Object> commentsMap=new HashMap<String,Object>();
        if(id==null || id<0){
            commentsMap.put("code",1);
            commentsMap.put("msg","参数有误");
            LOGGER.error("参数有误");
        }else{
            List<ReplyVO> replyVOs=goodsDetailDao.queryComments(id);
            if(replyVOs==null ){
                commentsMap.put("code",2);
                commentsMap.put("msg","查询不到相应回复");
            }else{
                commentsMap.put("code",0);
                commentsMap.put("replyList",replyVOs);
            }
        }
        return commentsMap;
    }

    /**
     * 将回复的评论插入到表中
     *   1.参数为空
     *   2.插入失败
     *   3.插入成功
     * @param reply
     * @return
     */
    public Map<String,Object> addReply(Reply reply){
        Map<String,Object> replyMap=new HashMap<String,Object>();
        if(reply==null){
            replyMap.put("code",1);
            replyMap.put("msg","参数有误");
        }else{
            int result=goodsDetailDao.addComment(reply);
            if(result<0){
                replyMap.put("code",2);
                replyMap.put("msg","插入失败");
                LOGGER.error("数据插入失败");
            }
            else {
                replyMap.put("code",0);
                replyMap.put("msg","数据插入成功");
            }

        }
        return replyMap;
    }

}
