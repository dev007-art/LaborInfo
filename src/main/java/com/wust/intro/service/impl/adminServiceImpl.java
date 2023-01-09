package com.wust.intro.service.impl;

import com.wust.intro.mapper.adminMapper;
import com.wust.intro.pojo.NotifyPojo;
import com.wust.intro.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl implements adminService {
    @Autowired
    adminMapper adminMapper;
    @Override
    public void add(NotifyPojo notifyPojo) {
        adminMapper.insert(notifyPojo);
    }
}
