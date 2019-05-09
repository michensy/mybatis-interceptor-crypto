package com.sf.service;

import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.model.TfSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zidong
 * @date 2019/5/9 10:01 AM
 */
@Service
public class UserService {

    @Autowired
    private TfSysUserMapper userMapper;


    public Long addUser(TfSysUser user) {
        userMapper.insert(user);
        return user.getUserId();
    }

    public TfSysUser getUser(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
