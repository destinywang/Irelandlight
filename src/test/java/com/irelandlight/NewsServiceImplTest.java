package com.irelandlight;

import com.irelandlight.service.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Joyoung on 2016/12/5.
 */
public class NewsServiceImplTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[] {
                "spring/spring-manager.xml",
                "spring/spring-dao.xml",
                "spring/spring-service.xml"

        });
    }
    @Test
    public void testSelectNews()throws Exception {
        NewsService newsService=(NewsService)applicationContext.getBean("newsService");
       //List<News> list=newsService.selectAllNews();
        //System.out.println(list.toString());
    }

}
