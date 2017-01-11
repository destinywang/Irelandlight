package com.irelandlight.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by destiny on 2016/12/11.
 */
public class MD5UtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    @Test
    public void testGetMD5() {
//        LOGGER.info(MD5Util.GetMD5Code("123456"));
        String str = MD5Util.getMD5Code("123456");
        System.out.println(str);
    }
}
