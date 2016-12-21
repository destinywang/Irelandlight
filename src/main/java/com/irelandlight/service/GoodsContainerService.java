package com.irelandlight.service;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.manager.ContextException;
import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsSizePrice;
import com.irelandlight.vo.ContainerItem;
import com.irelandlight.vo.GoodsDetail;
import com.irelandlight.vo.ItemsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/6.
 */
@Service
public class GoodsContainerService {
    @Resource
    private GoodsMapper goodsMapper;

    //查找商品概述信息
    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public ItemsInfo searchForGoodsCountInfo() {                        //查找商品的基本统计信息
        ItemsInfo goodsCountInfo = new ItemsInfo();
        goodsCountInfo.setGoodsTotal(goodsMapper.selectGoodsCount());
        goodsCountInfo.setUpedGoods(goodsMapper.selectPutawayGoodsCount());
        goodsCountInfo.setUnUpGoods(goodsMapper.selectSoldOutGoodsCount());
        goodsCountInfo.setGoodsComment(goodsMapper.selectGoodsComment());
        return goodsCountInfo;
    }

    //查找上架商品
    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ContainerItem> searchForPutawayGoods() {                 //为商品下架页面提供已经上架的商品
        List<ContainerItem> itemsList = new ArrayList<ContainerItem>();

        List<Goods> goodsList = goodsMapper.selectPutawayGoods();

        if (goodsList != null) {
            for (Goods goods : goodsList) {
                ContainerItem containerItem = new ContainerItem();
                List<GoodsSizePrice> listGoodSizeInfo = goodsMapper.selectPWSizePriceMapByGoodsId(goods.getId());
                addGoodsInfoToContainerItem(containerItem, goods, listGoodSizeInfo);
                //将查到的这个加入到试图展示层的list中
                itemsList.add(containerItem);
            }
        }
        return itemsList;
    }

    //查找下架商品
    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ContainerItem> searchForUnPutawayGoods() {                 //为商品下架页面提供已经上架的商品
        List<ContainerItem> itemsList = new ArrayList<ContainerItem>();

        List<Goods> goodsList = goodsMapper.selectUnPutawayGoods();

        if (goodsList != null) {
            for (Goods goods : goodsList) {
                ContainerItem containerItem = new ContainerItem();
                List<GoodsSizePrice> listGoodSizeInfo = goodsMapper.selectUPWSizePriceMapByGoodsId(goods.getId());
                addGoodsInfoToContainerItem(containerItem, goods, listGoodSizeInfo);
                //将查到的这个加入到试图展示层的list中
                itemsList.add(containerItem);
            }
        }
        return itemsList;
    }

    //批量上架
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public boolean putawayAllGoods(Map<Long, List<String>> idMappingSize) throws Exception {
        boolean tag=false;
        if (idMappingSize != null && !idMappingSize.isEmpty()) {
            List<Long> ids = new ArrayList<Long>();
            ids.addAll(idMappingSize.keySet());
            tag= goodsMapper.updateGoodsByIds(ids, 1)==0?false:true;
            tag= goodsMapper.updateGoodsByIdsAndSize(idMappingSize, 1)==0?false:true;
        } else {
            throw new ContextException("上架失败，请传入尺寸价格映射关系！");
        }
        return tag;
    }

    //批量下架
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public boolean saleoutAllGoods(Map<Long, List<String>> idMappingSize) throws Exception {
        boolean tag=false;
        if (idMappingSize != null && !idMappingSize.isEmpty()) {
            List<Long> ids = new ArrayList<Long>();
            ids.addAll(idMappingSize.keySet());
            tag= goodsMapper.updateGoodsByIds(ids, 0)==0?false:true;
            tag= goodsMapper.updateGoodsByIdsAndSize(idMappingSize, 0)==0?false:true;
        } else {
            throw new ContextException("下架失败，请传入尺寸价格映射关系！");
        }
        return tag;
    }

    //查找下架商品
    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public GoodsDetail queryGoodsById(Long goodsId,int pwFlag)throws Exception{
        GoodsDetail goodsDetail=new GoodsDetail();

        Goods goodsInfo=goodsMapper.selectGoodsById(goodsId);
        List<GoodsSizePrice> goodsSizePriceList=null;
        if(pwFlag==0){
            goodsSizePriceList=goodsMapper.selectUPWSizePriceMapByGoodsId(goodsId);
        }else {
            goodsSizePriceList=goodsMapper.selectPWSizePriceMapByGoodsId(goodsId);
        }

        String imgHeadUrl=goodsMapper.selectGoodsHeadImgUrlByGoodsId(goodsId);
        if(goodsInfo==null){ throw new ContextException("查找的商品不存在");}
        if(imgHeadUrl==null){throw new ContextException("商品头像缺失");}
        if(goodsSizePriceList==null){throw new ContextException("商品尺寸列表存在问题");}
        addGoodsInfoToGoodsDetail(goodsDetail,goodsInfo,goodsSizePriceList);
        goodsDetail.setHeadImgUrl(imgHeadUrl);
        return  goodsDetail;
    }



    //修改商品信息
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public boolean modifyGoodsInfoLong(Goods goods, Map<String, Integer> imgMapPosition,Map<String,BigDecimal> sizeMapPrice)throws Exception{
        boolean tag=false;
        if(goods!=null){
            tag=goodsMapper.updateGoods(goods)==0?false:true;
            if(imgMapPosition!=null){
               tag=goodsMapper.updateGoodsImg(goods.getId(),imgMapPosition)==0?false:true;
            }
            tag=goodsMapper.updateGoodsSizePrice(goods.getId(),sizeMapPrice)==0?false:true;
        }else {
            throw new ContextException("请传入商品");
        }
        return tag;
    }




    //添加商品
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public boolean addGoods(Goods goods, Map<String, Integer> imgMapPosition,Map<String,BigDecimal> sizeMapPrice)throws Exception {
        boolean tag=false;
        if(goods!=null){
           goodsMapper.insertIntoGoods(goods);
            if(goods.getId()!=null){
                goodsMapper.insertIntoGoodsImg(goods.getId(),imgMapPosition);
               tag= goodsMapper.insertIotoGoodsSizePrice(goods.getId(),sizeMapPrice)==0?tag:true;
            }
        }else {
            throw new ContextException("请传入商品信息");
        }
        return tag;
    }


    private void addGoodsInfoToGoodsDetail(GoodsDetail goodsDetail,Goods goods,List<GoodsSizePrice> goodsSizePriceList){
        goodsDetail.setName(goods.getName());
        goodsDetail.setPreference(goods.getPreference());
        goodsDetail.setUse(goods.getUse());
        goodsDetail.setDescription(goods.getDescription());
        goodsDetail.setGoodsId(goods.getId());
        goodsDetail.setQuantity(goods.getQuantity());
        goodsDetail.setSaleCount(goods.getSaleCount());
        goodsDetail.setStatus(goods.getStatus());
        goodsDetail.setTaste(goods.getTaste());
        goodsDetail.setWeight(goods.getWeight());
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        //查找当前商品的尺寸和价格
        if (goodsSizePriceList != null) {
            for (GoodsSizePrice item : goodsSizePriceList) {
                map.put(item.getSize(), item.getPrice());
            }
        }
        goodsDetail.setPriceMapSize(map);
    }


    private void addGoodsInfoToContainerItem(ContainerItem containerItem, Goods goods, List<GoodsSizePrice> listGoodSizeInfo) {
        //给查找出来的商品信息填充到试图展示层的vo对象当中
        containerItem.setDescription(goods.getDescription());
        containerItem.setQuantity(goods.getQuantity());
        containerItem.setGoodsId(goods.getId());
        containerItem.setGoodsName(goods.getName());
        containerItem.setLastUpdate(goods.getLastUpdate());
        containerItem.setWeight(goods.getWeight());
        //根据商品id查找商品主图
        containerItem.setGoodsImgUrl(goodsMapper.selectGoodsHeadImgUrlByGoodsId(goods.getId()));
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        //查找当前商品的尺寸和价格
        if (listGoodSizeInfo != null) {
            for (GoodsSizePrice item : listGoodSizeInfo) {
                map.put(item.getSize(), item.getPrice());
            }
        }
        containerItem.setPriceMapSize(map);
    }

}
