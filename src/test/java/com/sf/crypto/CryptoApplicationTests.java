package com.sf.crypto;

import com.sf.hd.util.DeterministicAeadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoApplicationTests {

    @Autowired
    DeterministicAeadService deterministicAeadService;

    @Test
    public void contextLoads() {
        deterministicAeadService.encode("12123");
    }

}
