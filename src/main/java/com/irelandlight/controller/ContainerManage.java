package com.irelandlight.controller;

import com.irelandlight.manager.ContextException;
import com.irelandlight.service.GoodsContainerService;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.ContainerItem;
import com.irelandlight.vo.GoodsDetail;
import com.irelandlight.vo.ItemsInfo;
import com.irelandlight.vo.ModifyGoodsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.BindException;
import java.util.*;

/**
 * Created by mac on 2016/12/13.
 */
@Controller
@RequestMapping("/container")
public class ContainerManage {
    @Resource
    private GoodsContainerService containerService;
    @Resource
    private ImgeUploadUtil imgeUploadUtil;
    //展示商品页的基本商品数量统计信息
    @RequestMapping(value = "/queryGoodsSimpleInfo",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ItemsInfo showGoodsCountInfo(){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();
        return itemsInfo;
    }
    //展示商品页的基本商品数量统计信息,如果不是ajax请求则用这个方法
    @RequestMapping(value = "/queryGoodsInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showGoodsCountInfo(ModelAndView model){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();

        model.addObject("itemsInfo",itemsInfo);
        model.setViewName("");  //待填充,需要前端的页面名称
        return model;
    }
    //查询未上架商品列表在商品上架选项卡显示
    @RequestMapping(value = "/queryUnputawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showUnputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForUnPutawayGoods();
        return containerItemList;
    }
    @RequestMapping(value = "/queryPutawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForPutawayGoods();
        return containerItemList;
    }
    //查找商品详情，绑定参数为上下架标志和商品的Id
    @RequestMapping(value = "/queryGoodsById",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public GoodsDetail showGoodsDetailById(@RequestParam(value = "goodsId",required = true) Long  goodsId,int pwFlag)throws Exception{
        GoodsDetail goodsDetail=null;
        goodsDetail=containerService.queryGoodsById(goodsId,pwFlag);
        return goodsDetail;
    }
    //批量上架，上架成功响应成功，上架失败响应失败
    @RequestMapping(value = "/putawayAllGoods",method = {RequestMethod.POST})
    public void putawayAllGoods(@RequestBody List<ModifyGoodsVO> goodsVOS, HttpServletResponse resp)throws Exception{
        Map<Long,List<String>> map=new HashMap<Long, List<String>>();
        String message="Modify fail!";
        if(goodsVOS!=null&&goodsVOS.size()!=0) {
            for (ModifyGoodsVO goodsVO:goodsVOS) {
                List<String> sizes=new LinkedList<String>(goodsVO.getSizeMapPrice().keySet());
                map.put(goodsVO.getGoodsId(),sizes);
            }
        }
        message=containerService.putawayAllGoods(map)?"Modify success":message;
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().println(message);
    }

    //批量下架，下架成功返回成功，下架失败返回失败
    @RequestMapping(value = "/saleoutAllGoods",method = {RequestMethod.POST})
    @ResponseBody
    public String saleOutAllGoods(@RequestBody List<ModifyGoodsVO> goodsVOS)throws Exception{
        Map<Long,List<String>> map=new HashMap<Long, List<String>>();
        String message="Modify fail!";
        if(goodsVOS!=null&&goodsVOS.size()!=0) {
            for (ModifyGoodsVO goodsVO:goodsVOS) {
                List<String> sizes=new LinkedList<String>(goodsVO.getSizeMapPrice().keySet());
                map.put(goodsVO.getGoodsId(),sizes);
            }
        }
        message=containerService.saleoutAllGoods(map)?"Modify success":message;
        return message;
    }




    @ExceptionHandler(value = {ContextException.class,RuntimeException.class, BindException.class})
    @ResponseBody
    public Map<String,Object> goodsExcrptionHandler(Exception ex){
        Map<String,Object> model=new TreeMap<String,Object>();
        model.put("error:",ex.getMessage());
        return model;
    }

}
