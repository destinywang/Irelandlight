package com.irelandlight.manager;

import com.irelandlight.dao.GoodsListDao;
import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/19.
 */
@Component
public class GoodsListManager {
    @Resource
    private GoodsListDao goodsListDao;

    private static final Logger LOGGER= LoggerFactory.getLogger(GoodsListManager.class);

    /**
     * 处理查询全部商品名录的数据
     *   1.数据为空
     *   2.有数据
     * @return
     */
    public Map<String,Object> queryAllGoods(){
        Map<String,Object> cakeList=new HashMap<String,Object>();
        List<GoodsVO> goodsVOs=goodsListDao.queryAllGoods();
        if(goodsVOs==null){
            cakeList.put("code",1);
            cakeList.put("msg","商品列表为空");
        }
        else{
            cakeList.put("code",0);
            cakeList.put("goodsList",goodsVOs);
        }
        return cakeList;
    }

    /**
     * 根据搜索框里面的内容查找商品列表数据
     *   1.搜索框为Null；
     *   2.查询到的数据为空
     *   3.查询到的数据完好
     *       但是这里我有问题，万一我查出来的数据List中有某一个商品的某一个信息出现问题应该怎么办
     * @param searchBox
     * @return
     */
    public Map<String,Object>queryBySearchGoods(String searchBox) {
        Map<String, Object> cakeList = new HashMap<String, Object>();
        if (searchBox == null) {
            cakeList.put("code", 1);
            cakeList.put("msg", "参数为null");
            LOGGER.error("查询参数searchBox为null");
        } else {
            List<GoodsVO> goodsVOs = goodsListDao.queryBySearchGoods(searchBox);
            if (goodsVOs == null) {
                cakeList.put("code", 2);
                cakeList.put("msg", "无法查询到相应商品");
            } else {
                cakeList.put("code", 0);
                cakeList.put("goodsList", goodsVOs);
            }
        }
        return cakeList;
    }

    /**
     * 根据筛选数组中的条件查找数据库得到的数据
     *   1.参数为空
     *   2.查找到的数据为null
     *   3.查找到了数据
     * @param filter
     * @return
     */
    public Map<String,Object> queryFilterGoods(FilterGoodsVO filter){
        Map<String,Object> cakeList=new HashMap<String,Object>();
        if(filter==null){
            cakeList.put("code",1);
            cakeList.put("msg","筛选数组为null");
            LOGGER.error("筛选数组为null");
        }
        else{
            List<GoodsVO> goodsVOs=goodsListDao.queryFilterGoods(filter);
            if(goodsVOs==null){
                cakeList.put("code",2);
                cakeList.put("msg","未找到符合条件的商品");
            }
            else{
                cakeList.put("code",0);
                cakeList.put("goodsList",goodsVOs);
            }
        }
        return cakeList;
    }



}
