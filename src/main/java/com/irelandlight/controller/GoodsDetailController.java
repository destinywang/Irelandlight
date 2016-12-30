package com.irelandlight.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.irelandlight.model.GoodsImage;
import com.irelandlight.model.Reply;
import com.irelandlight.model.vo.CommentsVO;
import com.irelandlight.model.vo.GoodsInfo;
import com.irelandlight.model.vo.SizePrice;
import com.irelandlight.service.GoodsDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/20.
 */
@Controller
public class GoodsDetailController {
    @Resource
    private GoodsDetailService goodsDetailService;
    @ResponseBody
    @RequestMapping(value = "/goodsDetail" ,produces = "text/json;charset=utf-8")
    public String goodsDetail(@RequestBody String goodsIds,Model model){
        Integer goodsId=Integer.parseInt(goodsIds);
        if( goodsId==null||goodsId<0){
            return "errorPage";
        }else{
            GoodsInfo goodsDetail=goodsDetailService.queryGoodsDetail(goodsId);
            if(goodsDetail==null){
                return "errorPage";
            }
            else{
                List<GoodsImage> goodsImages=goodsDetailService.queryGoodsImage(goodsId);
                List<CommentsVO>  goodsComments=goodsDetailService.queryComments(goodsId);
                List<SizePrice>  goodsSizePrice=goodsDetailService.querySizePrice(goodsId);
                model.addAttribute("goodsImage",goodsImages);
                model.addAttribute("goodsInfo",goodsDetail);
                model.addAttribute("goodsComments",goodsComments);
                model.addAttribute("goodsSize",goodsSizePrice);

                return "goodsDetail";
            }
        }



    }

    @RequestMapping("/addReply")
    @ResponseBody
    public  Integer addReply(@RequestBody(required = true)Reply reply){
        Integer result=goodsDetailService.addReply(reply);
        return result;
    }
}
