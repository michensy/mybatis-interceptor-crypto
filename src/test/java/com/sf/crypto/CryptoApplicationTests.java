package com.sf.crypto;

import com.google.common.collect.Lists;
import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.model.TfSysUser;
import com.sf.hd.util.DeterministicAeadService;
import com.sf.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CryptoApplicationTests {

    @Autowired
    DeterministicAeadService deterministicAeadService;

    @Test
    public void contextLoads() {
        deterministicAeadService.encode("12123");
    }


    @Autowired
    private TfSysUserMapper userMapper;

    @Test
    public void generUsers() {
        long start = System.currentTimeMillis();
        ArrayList<TfSysUser> users = new ArrayList<>(21474);
        for (int i = 0; i < 21474; i++) {
            TfSysUser user = new TfSysUser();
            user.setUserId(0L);
            user.setStaffId(RandomUtils.generateNumberString(10));
            // 加密存储
            user.setMobileNo(deterministicAeadService.encode(RandomUtils.generateNumberString(11)));
            user.setValidTag(true);
            users.add(user);
        }
        List<List<TfSysUser>> partition = Lists.partition(users, 1000);
        for (List<TfSysUser> splitUsers : partition) {
            userMapper.insertBatch(splitUsers);
        }
        long end = System.currentTimeMillis();
        log.debug("耗时：{}", start - end);
    }


}
