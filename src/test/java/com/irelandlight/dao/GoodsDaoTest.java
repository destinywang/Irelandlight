package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.controller.GoodsMapperTest;
import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsSizePrice;
import com.irelandlight.model.vo.ContainerItem;
import com.irelandlight.model.vo.ItemsInfo;
import com.irelandlight.service.GoodsContainerService;
import com.qiniu.streaming.model.ActivityRecords;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/6.
 */
public class GoodsDaoTest extends BaseJunitTest{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsContainerService goodsContainerService;

    @Test
    public void testMethod() {


//        Map<String,Integer> goodImg=new HashMap<String, Integer>();
//        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/f13e0b45-dd44-4156-a417-a1f4b0962dd7.jpg",1);
//        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/9d45443a-89fd-4aff-8563-1e59d835025c.jpg",2);
//        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/267b16d4-36aa-4040-a8e5-a2c88205e2b8.jpg",3);
//        goodsMapper.insertIntoGoodsImg(new Long(3),goodImg);

        Map<String,BigDecimal> sizeMapPrice=new HashMap<String, BigDecimal>();
        sizeMapPrice.put("2",new BigDecimal(36.90));
        sizeMapPrice.put("4",new BigDecimal(74.90));
        sizeMapPrice.put("5",new BigDecimal(180.90));
        goodsMapper.insertIotoGoodsSizePrice(new Long(2),sizeMapPrice);


        List<Long> ids=new ArrayList<Long>();
        ids.add(new Long(1));
        ids.add(new Long(2));
        ids.add(new Long(3));
        goodsMapper.updateGoodsByIds(ids,1);

        List<String> sizeList=new ArrayList<String>();
        sizeList.add("1");
        sizeList.add("2");
        List<String> sizlist2=new ArrayList<String>();
        sizlist2.add("1");
        sizlist2.add("3");
        Map<Long,List<String>> goodSizeMap=new HashMap<Long, List<String>>();
        goodSizeMap.put(new Long(1),sizeList);
        goodSizeMap.put(new Long(2),sizlist2);
        goodsMapper.updateGoodsByIdsAndSize(goodSizeMap,1);


        System.out.println(orderMapper.selectOrderCanceled());
        System.out.println(orderMapper.selectOrderSucceed());
        System.out.println(orderMapper.selectOrderUnpay());
        System.out.println(orderMapper.selectOrderUnhandle());
        List<Map<Object, Object>> orderList = orderMapper.selectOrderDetailByMonth();

        for (Map<Object, Object> map : orderList) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

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
        ItemsInfo itemsInfo =goodsContainerService.searchForGoodsCountInfo();
        System.out.println(itemsList);
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

    @Test
    public void testMap(){

        Map<String,Integer> goodImg=new HashMap<String, Integer>();
        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/f13e0b45-dd44-4156-a417-a1f4b0962dd7.jpg",0);
        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/9d45443a-89fd-4aff-8563-1e59d835025c.jpg",2);
        goodImg.put("http://ohlu5erjk.bkt.clouddn.com/267b16d4-36aa-4040-a8e5-a2c88205e2b8.jpg",3);
        System.out.println(goodImg.get("http://ohlu5erjk.bkt.clouddn.com/f13e0b45-dd44-4156-a417-a1f4b0962dd7.jpg"));
        System.out.println(goodImg.get("http://ohlu5erjk.bkt.clouddn.com/9d45443a-89fd-4aff-8563-1e59d835025c.jpg"));
        System.out.println(goodImg.get("http://ohlu5erjk.bkt.clouddn.com/267b16d4-36aa-4040-a8e5-a2c88205e2b8.jpg"));
    }
}
