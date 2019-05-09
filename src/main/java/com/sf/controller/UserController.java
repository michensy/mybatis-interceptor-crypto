package com.sf.controller;

import com.google.common.collect.Lists;
import com.sf.crypt.DeterministicAeadServiceCus;
import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.model.TfSysUser;
import com.sf.service.UserService;
import com.sf.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Zidong
 * @date 2019/5/9 9:22 AM
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TfSysUserMapper userMapper;

    /**
     * 新增一条用户，手机号加密
     * @return uid
     */
    @GetMapping("/add")
    public String addUser() {
        TfSysUser user = new TfSysUser();
        user.setUserName("测试用户");
        user.setStaffId(RandomUtils.generateNumberString(11));
        user.setMobileNo(RandomUtils.generateNumberString(11));
        user.setValidTag(true);
        user.setCreateTime(new Date());
        log.debug("加密前手机号：{}", user.getMobileNo());
        Long uid = userService.addUser(user);
        if (uid == 0) {
            return "新增失败！";
        }
        return "新增成功，UID为：" + uid;
    }

    /**
     * 获取解密后的手机号
     * @param uid 用户 ID
     * @return mobileNo
     */
    @GetMapping("/get")
    public String getUser(String uid) {
        TfSysUser user = userService.getUser(uid);
        if (user == null) {
            return "无数据！";
        }
        return "解密手机号成功，UID为：" + uid + "的手机号解密为：" + user.getMobileNo();
    }

    /**
     * 获取所有用户的手机号
     * 耗时：10036
     */
    @GetMapping("/all")
    public String getAll() {
        long start = System.currentTimeMillis();
        List<TfSysUser> users = userService.getAll();
        if (users == null) {
            return "无数据";
        }
        StringBuilder sb = new StringBuilder(users.size());
        for (int i = 1; i <= users.size(); i++){
            if (i != users.size()) {
                sb.append(users.get(i).getMobileNo());
                sb.append(",");
            } else {
                sb.append(users.get(i -1 ).getMobileNo());
            }
        }
        long end = System.currentTimeMillis();
        log.debug("耗时：{}", end - start);
        return sb.toString();
    }

    /**
     * 新增 21474条数据并加密
     * 耗时：11550
     * @return
     */
    @GetMapping("/addUsers")
    public String addUsers() {
        long start = System.currentTimeMillis();
        ArrayList<TfSysUser> users = new ArrayList<>(21474);
        for (int i = 0; i < 21474; i++) {
            TfSysUser user = new TfSysUser();
            user.setUserId(0L);
            user.setStaffId(RandomUtils.generateNumberString(10));
            user.setMobileNo(RandomUtils.generateNumberString(11));
            user.setValidTag(true);
            users.add(user);
        }
        List<List<TfSysUser>> partition = Lists.partition(users, 1000);
        for (List<TfSysUser> splitUsers : partition) {
            userMapper.insertBatch(splitUsers);
        }
        long end = System.currentTimeMillis();
        log.debug("耗时：{}", end - start);
        return "";
    }
}
