package com.irelandlight.service.impl;

import com.irelandlight.dao.HomeRotationMapper;
import com.irelandlight.model.HomeRotation;
import com.irelandlight.service.HomeRotationService;

/**
 * Created by Joyoung on 2016/12/10.
 */
public class HomeRotationServiceImpl implements HomeRotationService {
    private HomeRotationMapper homeRotationMapper;
    public void insertHomeRotation(HomeRotation homeRotation) throws Exception {
        homeRotationMapper.insertHomeRotation(homeRotation);
    }
}
