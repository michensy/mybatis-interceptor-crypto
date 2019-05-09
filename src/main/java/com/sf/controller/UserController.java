package com.sf.controller;

import com.sf.dao.model.TfSysUser;
import com.sf.service.UserService;
import com.sf.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
}
