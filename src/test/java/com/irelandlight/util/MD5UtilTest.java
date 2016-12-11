package com.irelandlight.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by destiny on 2016/12/11.
 */
public class MD5UtilTest {

    private static final Logger logger = LoggerFactory.getLogger(MD5UtilTest.class);

    @Test
    public void testMd5Encode() {
        try {
            System.out.println(MD5Util.md5Encode("123"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
