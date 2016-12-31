package com.irelandlight.controller;

import com.irelandlight.manager.ContextException;
import com.irelandlight.model.Goods;
import com.irelandlight.service.GoodsContainerService;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.BindException;
import java.util.*;

/**
 * Created by mac on 2016/12/13.
 *
 *货柜管理模块，根级url /container
 *
 */

@Controller
@RequestMapping("/container")
public class ContainerManage {
    //服务设置模块
    @Resource
    private GoodsContainerService containerService;
    //图片上传组件
    @Resource
    private ImgeUploadUtil imgeUploadUtil;

    /**
     * 七牛云外链地址
     */
    private final String QINIULINK="http://ohlu5erjk.bkt.clouddn.com/";


    /**
     * 展示商品页的基本商品数量统计信息
     * 包括：商品总数
     * 已上架商品
     * 未上架商品
     * 商品的品论总数
     */
    @RequestMapping(value = "/queryGoodsSimpleInfo",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ItemsInfo showGoodsCountInfo(){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();
        return itemsInfo;
    }

    /**
     *    展示商品页的基本商品数量统计信息,如果不是ajax请求则用这个方法
     */
    @RequestMapping(value = "/queryGoodsInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showGoodsCountInfo(ModelAndView model){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();

        model.addObject("itemsInfo",itemsInfo);
        model.setViewName("");  //待填充,需要前端的页面名称
        return model;
    }


    /**
     *    查询未上架商品列表在商品上架选项卡显示
     */
    @RequestMapping(value = "/queryUnputawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showUnputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForUnPutawayGoods();
        return containerItemList;
    }
    /**
     *    展示已经上架的商品该要信息列表
     */
    @RequestMapping(value = "/queryPutawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForPutawayGoods();
        return containerItemList;
    }

    /**
     *  查找商品详情，绑定参数为上下架标志和商品的Id
     */
    @RequestMapping(value = "/queryGoodsById",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public GoodsDetail showGoodsDetailById(@RequestParam(value = "goodsId",required = true) Long  goodsId,int pwFlag)throws Exception{
        GoodsDetail goodsDetail=null;
        goodsDetail=containerService.queryGoodsById(goodsId,pwFlag);
        return goodsDetail;
    }

    /**
     *  批量上架，上架成功响应成功，上架失败响应失败
     */
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

    /**
     *    批量下架，下架成功返回成功，下架失败返回失败
     */
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

    /**
     *  将参数绑定到map时map必须是某个类的子对象，且在前端页面上以 map[key]-value的形式完成前端页面的设置
     */
    @RequestMapping(value = "/addGoods",method={RequestMethod.POST})
    @ResponseBody
    public String addGoods(Goods goods, ModifyGoodsVO goodsSizeMapPrice, MultipartFile[] goodImgs)throws Exception{
        String message="Add fail!";
        if(!paramValidate(goods)) return "Parameter Error";
        if(!paramValidate(goodsSizeMapPrice)) return "Parameter Error";
        Map<String,Integer>  goodsImgPos=new TreeMap<String, Integer>();
        String imgName=null;
        for(int i=0;i<goodImgs.length;i++){
            imgName=goodImgs[i].getName();
            if(imgName==null) return "商品图片名称出错";
            imgName=UUID.randomUUID()+imgName.substring(imgName.lastIndexOf("."));
            imgeUploadUtil.upLoad(goodImgs[i].getInputStream(),imgName);
            goodsImgPos.put(QINIULINK+imgName,i);
        }
        if(containerService.addGoods(goods,goodsImgPos,goodsSizeMapPrice.getSizeMapPrice())) message="Add success";
        return message;
    }

    /**
     *
     */
    @RequestMapping(value = "/modifyGoodsInfo",method = RequestMethod.POST)
    @ResponseBody
    public String modifyGoodsInfo(Goods goods, ModifyGoodsVO goodsSizeMapPrice, ModifyImgVo modifyImgVo)throws Exception{
        String message="Modify fail!";
        if(!paramValidate(goods)) return "Parameter Error";
        if(!paramValidate(goods)) return "Parameter Error";
        if(!paramValidate(modifyImgVo)) return "Parameter Error";
        if(containerService.modifyGoodsInfoLong(goods,modifyImgVo.getImgMapPos(),goodsSizeMapPrice.getSizeMapPrice()))
            message="Modify success!";
        return message;
    }



    /**
     *
     */
    @ExceptionHandler(value = {ContextException.class,RuntimeException.class, BindException.class})
    @ResponseBody
    public Map<String,Object> goodsExcrptionHandler(Exception ex){
        Map<String,Object> model=new TreeMap<String,Object>();
        model.put("error:",ex.getMessage());
        return model;
    }
    //参数效验
    private boolean paramValidate(Goods goods){
        if(goods == null) return false;
        if(goods.getName()==null) return false;
        if(goods.getDescription()==null) return false;
        if(goods.getPreference()==null) return false;
        if(goods.getQuantity()==null) return false;
        if(goods.getSaleCount()==null) return false;
        if(goods.getUse()==null) return false;
        if(goods.getTaste()==null) return false;
        if(goods.getStatus()==null) return false;
        if(goods.getWeight()==null) return false;
        return true;
    }
    private boolean paramValidate(ModifyGoodsVO goodsSizeMapPrice){
        if(goodsSizeMapPrice==null||goodsSizeMapPrice.getSizeMapPrice()==null
                ||goodsSizeMapPrice.getSizeMapPrice().size()==0)
                        return false;
        return true;
    }

    private boolean paramValidate(ModifyImgVo modifyImgVo){
        if(modifyImgVo==null||modifyImgVo.getImgMapPos()==null
                ||modifyImgVo.getImgMapPos().size()==0)
            return false;
        return true;
    }



}
