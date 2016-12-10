package com.irelandlight.dao;

import com.irelandlight.model.News;
import com.irelandlight.model.vo.SomeNews;

import java.util.List;

/**
 * Created by Joyoung on 2016/12/5.
 */
public interface NewsMapper {
    //保存新的公告
    public void insertNews(News news)throws Exception;
    //查询所有的公告
    public List<SomeNews> selectAllNews()throws Exception;
    //假删除公告
    public void delateNews(Long id)throws Exception;


}
