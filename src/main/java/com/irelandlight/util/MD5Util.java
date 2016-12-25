package com.irelandlight.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: Matt
 * Date: 2016/12/12
 * Time: 15:51
 * Description: description
 */
/*使用MD5对密码进行加解密*/
public class MD5Util {

    public static String getMD5(String orgin) {
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            //设置编码格式
            md.update(orgin.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }

    public static void main(String[] args) throws Exception {
        String afterMD5 = MD5Util.getMD5("hello" + "654551");
        System.out.println(afterMD5);
    }


}
