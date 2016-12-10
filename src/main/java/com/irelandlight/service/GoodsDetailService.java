package com.irelandlight.service;

import com.irelandlight.dao.GoodsDetailDao;
import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.vo.GoodsAll;
import com.irelandlight.model.vo.GoodsInfo;
import com.irelandlight.model.vo.SizePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
@Service
public class GoodsDetailService {

    @Resource
    private GoodsDetailDao goodsDetailDao;

    /**
     * 返回商品的轮播图
     * @param id
     * @return
     */
    List<GoodsImage> queryGoodsImage(int id){
        return goodsDetailDao.queryGoodsImage(id);
    }

    /**
     * 查询某个商品的全部信息
     * @param id
     * @return
     */
    void  queryGoodsDetail(int id){
        GoodsInfo goodsInfo=goodsDetailDao.queryGoodsDetail(id);
        List<SizePrice> sizePrices=goodsDetailDao.querySizePrice(id);
        GoodsAll goodsAll=new GoodsAll();
        goodsAll.setGoodsInfo(goodsInfo);
        goodsAll.setSizePrices(sizePrices);
        System.out.println(goodsAll);

    }


}
