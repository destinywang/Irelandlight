package com.irelandlight.service;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.vo.ContainerItem;
import com.irelandlight.vo.ItemsInfo;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/13.
 */
public class ContainerItemTest extends BaseJunitTest{
    @Resource
    private GoodsContainerService goodsContainerService;


    @Test
    public void testSearchForGoodsCountInfo(){
        ItemsInfo itemsInfo =goodsContainerService.searchForGoodsCountInfo();
        System.out.println(itemsInfo);
    }


    @Test
    public void testSearchForPutawayGoods(){
        List<ContainerItem> containerItemList= goodsContainerService.searchForPutawayGoods();
        System.out.println(containerItemList);
    }

    @Test
    public void testSearchForUnPutawayGoods(){
        List<ContainerItem> containerItemList= goodsContainerService.searchForUnPutawayGoods();
    }

    @Test
    public void testPutawayAllGoods() throws Exception{
        List<ContainerItem> containerItemList= goodsContainerService.searchForUnPutawayGoods();
        Map<Long,List<String>> idMappingSize=new HashMap<Long,List<String>>();
        for (ContainerItem item:containerItemList){
           List<String> list=new ArrayList<String>();
           list.add("1");
           list.add("2");
           idMappingSize.put(item.getGoodsId(),list);
        }
        goodsContainerService.putawayAllGoods(idMappingSize);
    }
    @Test
    public void testSaleoutAllGoods() throws Exception{
        //List<ContainerItem> containerItemList= goodsContainerService.searchForPutawayGoods();
        Map<Long,List<String>> idMappingSize=new HashMap<Long,List<String>>();

            List<String> list=new ArrayList<String>();
            list.add("1");
            list.add("2");
            idMappingSize.put(new Long(1),list);
        goodsContainerService.saleoutAllGoods(idMappingSize);
    }





}
