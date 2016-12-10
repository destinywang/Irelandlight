package com.irelandlight.controller;

import com.irelandlight.model.News;
import com.irelandlight.model.vo.SomeNews;
import com.irelandlight.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Joyoung on 2016/12/6.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private  NewsService newsService;

    //向数据库写入新的公告
    @RequestMapping("/write")
    public void saveNews(@Param(value = "news")News news, HttpServletRequest request, HttpServletResponse response)throws Exception{
        newsService.insertNews(news);
        request.getRequestDispatcher("/news/look.action").forward(request,response);
    }
    //查询所有公告
    @RequestMapping("/look")
    public String sendNews(@Param("SomeNews")SomeNews someNews, HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<SomeNews> list=newsService.selectAllNews();
        request.setAttribute("list",list);
        return "look";
    }
    //删除公告
    @RequestMapping("/delete")
        public void delNews(Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
        newsService.delateNews(id);
        request.getRequestDispatcher("/news/look.action").forward(request,response);
    }
}
