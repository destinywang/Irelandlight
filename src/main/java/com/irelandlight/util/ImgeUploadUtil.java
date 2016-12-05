package com.irelandlight.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.io.InputStream;

/**
 * Created by mac on 2016/12/3.
 */
public class ImgeUploadUtil {
    //设置好账号的ACCESS_KEY和SECRET_KEY
     String ACCESS_KEY = "3Is5fv-Sb1bfM7qP4gYJ78ts4ugbbX3sYZvUgxil";
    String SECRET_KEY = "eyYBS3vZbLSgbKpXDwi-ixkD3KBeKAC8a_dlk1rk";
    //要上传的空间
    String bucketname = "irelandlightpic";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    ///////////////////////指定上传的Zone的信息//////////////////
    //自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
     Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);
    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }


    /**
     *
     * @imgInputStream 文件上传的字节流
     * @fileName     保存到七牛云上的文件名，在Controler层以uuid加后缀实现
     * 这里为简单文件上传，非覆盖文件上传，必须指定不同的文件名，否则七牛云会报异常
     *
     */
    public void upLoad(InputStream imgInputStream,String fileName)throws Exception{
        try {
            //调用put方法上传
            //在SpringMVC框架中调用MultipartFile对象的getInputStream()方法可以接收到客户端上传到服务器的字节流
            //调用uploadManager.put(multipartFile.getInputStream(),/*文件名*/ key,upToken,null,null)
            //完成图片上传，在数据库中保存字段（外链域名+文件名）http://ohlu5erjk.bkt.clouddn.com/+key
            Response res = uploadManager.put(imgInputStream, fileName, getUpToken(),null,null);
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
