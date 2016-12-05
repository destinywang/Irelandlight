package com.irelandlight.controller;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

/**
 * Created by mac on 2016/12/3.
 */
public class UploadDemo {
    //前端图片上传到七牛，七牛返回图片的名称，然后前端把返回的数据填充到指定的表单中
    // 然后再次提交到后台，保存到数据库中，路子大致是这样的
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "3Is5fv-Sb1bfM7qP4gYJ78ts4ugbbX3sYZvUgxil";
    String SECRET_KEY = "eyYBS3vZbLSgbKpXDwi-ixkD3KBeKAC8a_dlk1rk";
    //要上传的空间
    String bucketname = "irelandlightpic";
    //上传到七牛后保存的文件名
    String key = "useful/git技术栈.png";
    //上传文件的路径
    String FilePath = "/Users/mac/Desktop/git技术栈.png";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    ///////////////////////指定上传的Zone的信息//////////////////
    //自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);
    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new UploadDemo().upload();
    }
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            //在SpringMVC框架中调用MultipartFile对象的getInputStream()方法可以接收到客户端上传到服务器的字节流
            //调用uploadManager.put(multipartFile.getInputStream(),/*文件名*/ key,upToken,null,null)
            //完成图片上传，在数据库中保存字段（外链域名+文件名）http://ohlu5erjk.bkt.clouddn.com/+key
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

}
