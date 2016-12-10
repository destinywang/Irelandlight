package com.irelandlight.service;

import com.irelandlight.model.HomeRotation;

/**
 * Created by Joyoung on 2016/12/10.
 */
public interface HomeRotationService {
    //存储轮播图
    public void insertHomeRotation(HomeRotation homeRotation)throws Exception;
}
