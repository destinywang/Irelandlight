package com.irelandlight.service;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsSizePrice;
import com.irelandlight.model.vo.ContainerItem;
import com.irelandlight.model.vo.ItemsInfo;
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
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public ItemsInfo searchForGoodsCountInfo(){                        //查找商品的基本统计信息
        ItemsInfo goodsCountInfo=new ItemsInfo();
        goodsCountInfo.setGoodsTotal(goodsMapper.selectGoodsCount());
        goodsCountInfo.setUpedGoods(goodsMapper.selectPutawayGoodsCount());
        goodsCountInfo.setUnUpGoods(goodsMapper.selectSoldOutGoodsCount());
        goodsCountInfo.setGoodsComment(goodsMapper.selectGoodsComment());
        return goodsCountInfo;
    }

    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<ContainerItem> searchForPutawayGoods(){                 //为商品下架页面提供已经上架的商品
        List<ContainerItem> itemsList=new ArrayList<ContainerItem>();

        List<Goods> goodsList=goodsMapper.selectPutawayGoods();

        if(goodsList!=null) {
            for (Goods goods : goodsList) {
                ContainerItem containerItem=new ContainerItem();
                List<GoodsSizePrice> listGoodSizeInfo=goodsMapper.selectPWSizePriceMapByGoodsId(goods.getId());
                addGoodsInfoToContainerItem(containerItem,goods,listGoodSizeInfo);
                //将查到的这个加入到试图展示层的list中
                itemsList.add(containerItem);
            }
        }
        return itemsList;
    }

    //设置该操作为只读操作，总是以非事务的方式运行，并且会挂起任何已经存在的事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<ContainerItem> searchForUnPutawayGoods(){                 //为商品下架页面提供已经上架的商品
        List<ContainerItem> itemsList=new ArrayList<ContainerItem>();

        List<Goods> goodsList=goodsMapper.selectUnPutawayGoods();

        if(goodsList!=null) {
            for (Goods goods : goodsList) {
                ContainerItem containerItem=new ContainerItem();
                List<GoodsSizePrice> listGoodSizeInfo=goodsMapper.selectUPWSizePriceMapByGoodsId(goods.getId());
                addGoodsInfoToContainerItem(containerItem,goods,listGoodSizeInfo);
                //将查到的这个加入到试图展示层的list中
                itemsList.add(containerItem);
            }
        }
        return itemsList;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void putawayAllGoods(List<Long> ids){

    }




    private void addGoodsInfoToContainerItem(ContainerItem containerItem,Goods goods,List<GoodsSizePrice> listGoodSizeInfo){
        //给查找出来的商品信息填充到试图展示层的vo对象当中
        containerItem.setDescription(goods.getDescription());
        containerItem.setQuantity(goods.getQuantity());
        containerItem.setGoodsId(goods.getId());
        containerItem.setGoodsName(goods.getName());
        containerItem.setLastUpdate(goods.getLastUpdate());
        containerItem.setWeight(goods.getWeight());
        //根据商品id查找商品主图
        containerItem.setGoodsImgUrl(goodsMapper.selectGoodsHeadImgUrlByGoodsId(goods.getId()));
        List<Map<String ,BigDecimal>> sizePriceMapList=new ArrayList<Map<String, BigDecimal>>();
        //查找当前商品的尺寸和价格
        if(listGoodSizeInfo!=null){
            for(GoodsSizePrice item:listGoodSizeInfo){
                Map<String,BigDecimal> map=new HashMap<String, BigDecimal>();
                map.put(item.getSize(),item.getPrice());
                sizePriceMapList.add(map);
            }
        }
        containerItem.setPriceMapSize(sizePriceMapList);
    }


}
