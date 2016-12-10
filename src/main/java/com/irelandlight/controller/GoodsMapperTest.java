package com.irelandlight.controller;

import com.irelandlight.dao.GoodsMapper;
import com.irelandlight.dao.OrderMapper;
import com.irelandlight.model.Goods;
import com.irelandlight.util.ImgeUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mac on 2016/12/5.
 */
@Controller
public class GoodsMapperTest {
    @Resource
    private ImgeUploadUtil imgeUploadUtil;

    @RequestMapping(value = "/uplodaFile",method = {RequestMethod.POST,RequestMethod.GET})
    public void testSel(Model model, @RequestParam("imgFile") MultipartFile [] imgFile)throws Exception {
        for (MultipartFile file:imgFile){
            String originalFilename = file.getOriginalFilename();
            imgeUploadUtil.upLoad(file.getInputStream(),
                    UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf(".")));
        }
    }

}
