package com.irelandlight.service;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.manager.ContextException;
import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsSizePrice;
import com.irelandlight.vo.ContainerItem;
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
    public void putawayAllGoods(Map<Long, List<String>> idMappingSize) throws Exception {
        if (idMappingSize != null && !idMappingSize.isEmpty()) {
            List<Long> ids = new ArrayList<Long>();
            ids.addAll(idMappingSize.keySet());
            goodsMapper.updateGoodsByIds(ids, 1);
            goodsMapper.updateGoodsByIdsAndSize(idMappingSize, 1);
        } else {
            throw new ContextException("上架失败，请传入尺寸价格映射关系！");
        }
    }

    //批量下架
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = ContextException.class)
    public void saleoutAllGoods(Map<Long, List<String>> idMappingSize) throws Exception {
        if (idMappingSize != null && !idMappingSize.isEmpty()) {
            List<Long> ids = new ArrayList<Long>();
            ids.addAll(idMappingSize.keySet());
            goodsMapper.updateGoodsByIds(ids, 0);
            goodsMapper.updateGoodsByIdsAndSize(idMappingSize, 0);
        } else {
            throw new ContextException("下架失败，请传入尺寸价格映射关系！");
        }
    }

    //添加商品
    //设置事务隔离级别为提交读，传播行为为：若存在事务则加入，若不存在事务则新建事务执行
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    private void addGoods(Goods goods, Map<String, Integer> imgMapPosition,Map<String,BigDecimal> sizeMapPrice)throws Exception {

        if(goods!=null){
            goodsMapper.insertIntoGoods(goods);
            if(goods.getId()!=null){
                goodsMapper.insertIntoGoodsImg(goods.getId(),imgMapPosition);
                goodsMapper.insertIotoGoodsSizePrice(goods.getId(),sizeMapPrice);
            }
        }else {
            throw new ContextException("请传入商品信息");
        }

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
