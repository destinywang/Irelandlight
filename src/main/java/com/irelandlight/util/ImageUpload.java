package com.irelandlight.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

import java.io.IOException;

/**
 * Created by Matt on 2016/12/10.
 */
public class ImageUpload {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "lO71nPxKLiV_asN__o7abX_CcmOP1Z7T_RwFcnFo";
    String SECRET_KEY = "g-RlDcydCrLLvsxTK2ND9LdPWvwRqzKVslJduATr";
    //要上传的空间
    String bucketname = "mattchen";

    //上传到七牛后保存的文件名
    //String key = "my-java.png";

    //上传文件的路径
    String FilePath = "C:\\Users\\Matt\\Desktop\\test.jpg";
    //外链路径,获取图片外链地址时拼接上该地址,直接加文件名即可
    String OutChain = "http://ohnx2nsuw.bkt.clouddn.com/";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    ///////////////////////指定上传的Zone的信息//////////////////
    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new ImageUpload().upload();
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传           //key值设置为null,文件名由七牛云随机产生
            Response res = uploadManager.put(FilePath, null, getUpToken());
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
