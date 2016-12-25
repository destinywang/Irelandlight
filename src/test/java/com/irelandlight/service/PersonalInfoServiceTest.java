package com.irelandlight.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.irelandlight.model.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2016/12/9.
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class PersonalInfoServiceTest {

    @Resource
    private PersonalInfoService personalInfoServiceImpl;

    @Test
    public void findPersonalInfo() throws Exception {
        personalInfoServiceImpl.findPersonalInfo(1001L);
    }

    @Test
    public void updata()throws Exception{
        personalInfoServiceImpl.changeEmail(1001L,"522@qq.com");
        personalInfoServiceImpl.changeNickName(1001L,"长者");
    }

    @Test
    public void testJson()throws Exception{
        Consumer consumer=personalInfoServiceImpl.findPersonalInfo(1001L);
        //创建JSON对象
        JSONObject json=new JSONObject();
        //给json添加数据对象
        json.put("PersonalInfo",consumer);
        System.out.println("json"+ json.toJSONString() );
    }

    @Test
    public void testJsonList()throws Exception{
        Consumer consumer=personalInfoServiceImpl.findPersonalInfo(1001L);
        Consumer consumer1=personalInfoServiceImpl.findPersonalInfo(1002L);
        List<Consumer> list=new ArrayList<Consumer>();

        list.add(consumer);
        list.add(consumer1);
        //创建JSON对象
        JSONObject json=new JSONObject();
        //给json添加数据对象
        json.put("PersonalInfo",list);
        System.out.println("json"+ json.toJSONString() );
    }

只对username和nickname进行序列化

    @Test
    public void testJsonSer()throws Exception{
        Consumer consumer=personalInfoServiceImpl.findPersonalInfo(1001L);
        //字段为我们需要序列化的字段，如果实体类中没有改字段则不解析放弃该字段而不会报错。
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Consumer.class, "username","nickname");
        //创建JSON对象
        JSONObject json=new JSONObject();
        //给json添加数据对象
        //json.put("PersonalInfo",consumer);
        System.out.println("json"+ json.toJSONString(consumer,filter) );
    }

进行反序列化

    @Test
    public void testAntiSeq()throws Exception{
        Consumer consumer=personalInfoServiceImpl.findPersonalInfo(1001L);
        //创建JSON对象
        JSONObject json=new JSONObject();
        //给json添加数据对象
        json.put("PersonalInfo",consumer);
        String jsonString = json.toJSONString();
        System.out.println("\njson"+ jsonString );
        System.out.println();

/*
以上获得一个json String对象jsonString

TODO:对JSON数据的反序列化失败
*/

        Consumer consumer1=JSON.parseObject(jsonString, Consumer.class );
        System.out.println(consumer1.getNickname()+"......"+consumer1.getTelephone());
    }

}
