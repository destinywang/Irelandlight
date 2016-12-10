package com.irelandlight.service.impl;

import com.irelandlight.dao.NewsMapper;
import com.irelandlight.model.News;
import com.irelandlight.model.vo.SomeNews;
import com.irelandlight.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Joyoung on 2016/12/5.
 */

public class NewsServiceImpl implements NewsService{
   @Autowired
    private NewsMapper newsMapper;
    //保存新的公告
    public void insertNews(News news) throws Exception {
       newsMapper.insertNews(news);
    }
    //查询所有的公告
    public List<SomeNews> selectAllNews() throws Exception {
        List<SomeNews> list=newsMapper.selectAllNews();
        return list;
    }
    //假删除公告
    public void delateNews(Long id) throws Exception {
            newsMapper.delateNews(id);
    }
}
